package main.java.com.biglee.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    static AtomicInteger i=new AtomicInteger(0);
    public static void increment(){
        i.getAndAdd(4);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] t=new Thread[10];
        for (int j = 0; j < t.length; j++) {
            t[j]=new Thread(new Add());
            t[j].start();
        }
        for (int j = 0; j < t.length; j++) {
            t[j].join();
        }
        System.out.println(i);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        executorService.submit(new Add(countDownLatch));
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(i);
        executorService.shutdown();
    }


    private static class Add implements Runnable{
        private CountDownLatch latch;
        public Add(CountDownLatch latch) {
            this.latch=latch;
        }
        public Add(){}
        @Override
        public void run() {
            try {
                for (int j = 0; j < 100; j++) {
                    increment();
                }
            } finally {
                if (null!=latch){
                    latch.countDown();
                }
            }

        }
    }
}
