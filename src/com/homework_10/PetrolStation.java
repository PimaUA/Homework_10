package com.homework_10;

import java.util.Random;
import java.util.concurrent.*;

public class PetrolStation {
    volatile Double amount;
    private final ExecutorService service;

    public PetrolStation(Double amount, ExecutorService service) {
        this.amount = amount;
        this.service = service;
    }

    void doRefuel(Double amountNeeded) {
        Random random = new Random();
        int low = 3;
        int high = 11;
        long refuellingTime = (random.nextInt(high - low) + low) * 1000;        /*random refuelling time*/
        Future<Double> remainedAmountCalculation = service.submit(() -> {
            try {
                Thread.sleep(refuellingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (amount) {                                                 /*remained amount calculation*/
                if (amount > amountNeeded) {
                    amount -= amountNeeded;
                } else {
                    amount = 0.0;
                }
                return amount;
            }
        });
        try {
            System.out.println("Calculated result : " + remainedAmountCalculation.get());  /*awaiting result*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}







