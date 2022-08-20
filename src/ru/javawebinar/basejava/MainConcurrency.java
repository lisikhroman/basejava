package ru.javawebinar.basejava;

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
    }

    private synchronized void inc() {
        counter++;
    }
}
