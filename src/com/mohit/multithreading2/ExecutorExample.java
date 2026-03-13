package com.mohit.multithreading2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Executor interface -> ExecutorService interface -> ThreadPoolExector class
// Exectors is a class having some factory method
public class ExecutorExample {
    static void main() {


        String[] filepaths = {
                "/Users/mohitkumarbharti/IdeaProjects/pracj/src/com/mohit/multithreading/abc.txt",
                "/Users/mohitkumarbharti/IdeaProjects/pracj/src/com/mohit/multithreading/abc.txt"
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for(String filepath : filepaths) {
            executorService.execute(() -> readFile(filepath));
        }

        executorService.shutdown();


    }

    static void readFile(String filepath) {
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while((line = br.readLine()) != null) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("file path : " + Thread.currentThread().getName() + ":reaeded " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
