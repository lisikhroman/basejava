package ru.javawebinar.basejava;

import ru.javawebinar.basejava.util.LazySingleton;

import java.util.ArrayList;
import java.util.List;

public class MainConcurrency {
    private static int counter;
    private static final Object lock = new Object();
    private static int THREADS_NUMBERS = 10000;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + " " + getState());
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());
            }
        }).start();
        {
        }
        ;

        final MainConcurrency mainConcurrency = new MainConcurrency();
        List<Thread> threads = new ArrayList<>(THREADS_NUMBERS);

        for (int i = 0; i < THREADS_NUMBERS; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    mainConcurrency.inc();
                }
            });
            thread.start();
            threads.add(thread);
            thread.join();
        }

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread.sleep(500);
        System.out.println(counter);

        LazySingleton.getInstance();

        final String lock1 = "lock1";
        final String lock2 = "lock2";
        deadlock(lock1, lock2);
        deadlock(lock2, lock1);
    }

    private static void deadlock(Object lock1, Object lock2) {
        new Thread(() -> {
            System.out.println("ожидаем" + lock1);
            synchronized (lock1) {
                System.out.println("захватываем" + lock1);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ожидаем" + lock2);
                synchronized (lock2) {
                    System.out.println("захватываем" + lock2);
                }
            }
        }).start();
    }

    private synchronized void inc() {
        counter++;
    }
}
