package com.homework_10;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class PetrolStation {
    private volatile Double amount;

    public PetrolStation(Double amount) {
        this.amount = amount;
    }

    public void doRefuel(Double amountNeeded) {
        Random random = new Random();
        int low = 3;
        int high = 11;
        long refuellingTime = (random.nextInt(high - low) + low) * 1000;   /*random refuelling time*/
        Semaphore sem = new Semaphore(3, true);
        Runnable r = () -> {
            try {
                sem.acquire();
                Thread.sleep(refuellingTime);
                synchronized (amount) {
                    if (amount > amountNeeded) {
                        amount -= amountNeeded;
                        System.out.println("Fuel remained " + amount + " " + Thread.currentThread().getName());
                    } else {
                        amount = 0.0;
                        System.out.println("Fuel remained " + amount + " " + Thread.currentThread().getName());
                    }
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sem.release();
        };
        Thread myThread = new Thread(r);
        myThread.start();
    }
}







