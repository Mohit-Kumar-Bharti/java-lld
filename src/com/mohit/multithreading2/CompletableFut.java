package com.mohit.multithreading2;

import java.util.concurrent.CompletableFuture;

// runAsync : jab bs run karna ho sout, return nahi
// supplyAsync : jab value deni ho
// join() : to wait
// allof : bahut k liye wait
// thenApply : jab simple value operation ho
// thenCompose : jab completable future dusra use ho lambda me
// thenCombine : jab combine karna ho 2 future ko
//.exceptionally() : to handle exception better than try catch
// .orTimeout()
// compelteonTimeout bhi hota hai but utna useful nahi
public class CompletableFut {

    static void main() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {return 44;});
        future.thenApply(x -> x + 33)
                .thenAccept(System.out::println);


        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> System.out.printf("hello1 "));
        CompletableFuture<Void> f2 = CompletableFuture.runAsync(() -> System.out.println("hello2 "));
        CompletableFuture<Void> f3 = CompletableFuture.runAsync(() -> System.out.println("hello3"));

        CompletableFuture.allOf(f1,f2,f3).join();


        CompletableFuture<Integer> fut = CompletableFuture.supplyAsync(() -> {return 2;});
        fut.thenCompose(res -> CompletableFuture.supplyAsync(() -> res + 2))
                .thenApply(res -> {
                    System.out.println(res);
                    return res;
                });
        // isme bs return type completable<completable<>> ho jaata
        // fut.thenApply(res -> CompletableFuture.supplyAsync(() -> res + 2));



        // then combine : ye tab jab 2 completable future ko hi combine karna ho
        CompletableFuture<Integer> f4 = CompletableFuture.supplyAsync(() -> {return 3;});
        CompletableFuture<Integer> f5 = CompletableFuture.supplyAsync(() -> {return 4;});
        CompletableFuture<Integer> f6 =       f4.thenCombine(f5, (res1, res2) -> {
            System.out.println(res1 + " .. " +  res2);
            return res1 + res2;
        });

        f6.join();


// timeout k liye
//        CompletableFuture<String> apiCall =
//                CompletableFuture.supplyAsync(() -> callExternalAPI())
//                        .orTimeout(2, TimeUnit.SECONDS);









        fut.join();

    }
}
