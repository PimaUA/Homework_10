package com.homework_10;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

public class PetrolStation {
    private final AtomicReference<Double> amount;
    private final ExecutorService service;

    public PetrolStation(AtomicReference<Double> amount, ExecutorService service) {
        this.amount = amount;
        this.service = service;
    }

    void doRefuel(Double amountNeeded) {
        Random random = new Random();
        int low = 3;
        int high = 11;
        long refuellingTime = (random.nextInt(high - low) + low) * 1000;        /*random refuelling time*/
        try {
            Thread.sleep(refuellingTime);                                              /*refuelling in progress*/
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Runnable task = () ->
                amount.updateAndGet(totalFuel -> totalFuel > amountNeeded ? totalFuel - amountNeeded : 0);
        service.submit(task);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Calculated result: " + amount.get());                      /*awaiting result*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}







