package com.test;


public class DayOne1 {
    public static volatile long[] arr = new long[8];

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000_0000L; i++) {
                arr[0] = i;
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000_0000L; i++) {
                arr[7] = i;
            }
        });
        final long x = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long l = System.nanoTime();
        System.out.println("时间:"+(l-x)/1000_000);
    }

    }



