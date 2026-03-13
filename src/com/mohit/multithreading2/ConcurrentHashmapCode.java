package com.mohit.multithreading2;


import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// ConcurrentHashmap is thead safe hashmap
// this is more performant than our own synchronized keyword map because here lock is taken on segment level while we take lock on whole map
public class ConcurrentHashmapCode<S, I extends Number> {

        static int num_thread = 5;
        static ExecutorService executorService = Executors.newFixedThreadPool(num_thread);
        static ConcurrentHashMap<String,Integer> concurrentHashmapCode = new ConcurrentHashMap<>();

    static void main() {


        for(int i=0;i<num_thread;i++) {
            executorService.submit(() -> insertRecord());
        }
        executorService.shutdown();

        System.out.println("hashmpa size before isTerminated " + concurrentHashmapCode.size());

        if(!executorService.isTerminated()) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }

        System.out.println(concurrentHashmapCode.size());


        // 2nd use is here
        // IN normal map we can't modify at the same time but here we can while iterating

        Map<String,Integer> mp = new ConcurrentHashMap<>();
        mp.put("ONE",1);
        mp.put("TWO",2);

        Iterator<Map.Entry<String,Integer>>  it = mp.entrySet().iterator();

        while(it.hasNext()) {
            Map.Entry<String , Integer> entry = it.next();
            if(entry.getKey().equals("ONE")) {
                mp.put("FOUR",4);
            }
        }

        System.out.println(mp);
    }

    static  void insertRecord() {
        for(int i=0;i<100;i++) {
            concurrentHashmapCode.put(Thread.currentThread().getName() + i ,i);
        }
    }

}
