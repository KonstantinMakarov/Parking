package com.epam.parking.entity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Use for ...
 */
public class Car extends Thread {
    private Parking parking;
    private Lock lock = new ReentrantLock();

    public Car(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            if(lock.tryLock()) {
                try {
                    CarPlace carPlace = park();
                    sleep(1000);
                    leaveParking(carPlace);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    lock.unlock();
                }
            }
        }
    }

    private CarPlace park(){
        for(CarPlace currentCarPlace : parking.getCarPlaces()){
            if(currentCarPlace.isFree()){
                currentCarPlace.setIsFree(false);
                return currentCarPlace;
            }
        }
        return null;
    }

    public void leaveParking(CarPlace carPlace){
        if(carPlace != null){
            carPlace.setIsFree(true);
        }
    }
}
