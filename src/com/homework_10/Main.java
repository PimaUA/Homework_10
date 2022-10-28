package com.homework_10;

public class Main {

    public static void main(String[] args) {
        //TreadSafeList
        ThreadSafeList<String> list1 = new ThreadSafeList<>();

        Thread thread1 = new Thread(() -> list1.add("1")); /*add method test*/
        Thread thread2 = new Thread(() -> list1.add("2"));
        Thread thread3 = new Thread(() -> list1.add("3"));
        thread1.start();
        thread2.start();
        thread3.start();

        Thread thread4 = new Thread(() -> list1.remove("3")); /*remove method test*/
        Thread thread5 = new Thread(() -> list1.remove("2"));
        thread4.start();
        thread5.start();

        Thread thread6 = new Thread(() -> list1.get(0)); /*get method test*/
        thread6.start();

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
