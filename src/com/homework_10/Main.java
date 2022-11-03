package com.homework_10;

public class Main {

    public static void main(String[] args) {
        //TreadSafeList
        ThreadSafeList<String> list = new ThreadSafeList<>();

        Thread thread0 = new Thread(() -> list.add("1")); /*add method*/
        Thread thread1 = new Thread(() -> list.add("2"));
        Thread thread2 = new Thread(() -> list.add("3"));
        thread0.start();
        thread1.start();
        thread2.start();

        Thread thread3 = new Thread(() -> list.remove("1")); /*remove method*/
        Thread thread4 = new Thread(() -> list.remove("3"));
        thread3.start();
        thread4.start();

        Thread thread5 = new Thread(() -> list.get(0)); /*get method*/
        thread5.start();

//Petrol station
        PetrolStation station = new PetrolStation(200.0);
        station.doRefuel(20.0);
        station.doRefuel(30.0);
        station.doRefuel(30.0);
        station.doRefuel(10.0);
        station.doRefuel(20.0);
        station.doRefuel(20.0);
        station.doRefuel(10.0);
        station.doRefuel(70.0);
    }
}
