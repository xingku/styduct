package com.test;

public class DayOne3 {
   private static class Pa {
//        public  volatile long p1;
//        public  volatile long p2;
//        public  volatile long p3;
//        public  volatile long p4;
//        public  volatile long p5;
//        public  volatile long p6;
//        public  volatile long p7;

    }

    private static class T extends Pa{
        public  volatile long x = 0L;

    }

    public static  T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000_0000L; i++) {
                arr[0].x = i;
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000_0000L; i++) {
                arr[1].x = i;
            }
        });
        final long x = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long l = System.nanoTime();
        System.out.println("时间:" + (l - x)/1000_000);
    }

}
