package com.mohit.multithreading2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCallable {

    public static void main() {
        List<String> stockSymbols = Arrays.asList("ABC","DEF", "XY");
        List<Future> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for(String stockSymbol : stockSymbols) {
            StockPriceFetcher stockPriceFetcher = new StockPriceFetcher(stockSymbol);
            Future future = executorService.submit(stockPriceFetcher);
            futures.add(future);

        }

        executorService.shutdown();

        for(int i=0;i<3;i++) {
            try{
                while (! futures.get(i).isDone() ) {
                    System.out.println("waiting ...");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                System.out.println("print for stock " + stockSymbols.get(i));
                System.out.println("result is : " + futures.get(i).get());

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }



}

class StockPriceFetcher implements Callable<Double> {
    private String stockSymbol;

    public StockPriceFetcher(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    @Override
    public Double call() throws Exception {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        return Math.random() * 1000;

    }

}
