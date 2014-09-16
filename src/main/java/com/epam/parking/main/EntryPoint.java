package com.epam.parking.main;

/**
 * Use for ...
 */
public class EntryPoint {
    public static void main(String[] args){
        Parking parking = Parking.getInstance();
        Car car1 = new Car(parking);
        Car car2 = new Car(parking);
        Car car3 = new Car(parking);
        car1.start();
        car2.start();
        car3.start();
        try {
            car1.join();
            car2.join();
            car3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
