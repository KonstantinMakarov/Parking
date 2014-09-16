package com.epam.parking.main;

/**
 * Use for ...
 */
public class Car extends Thread {
    private Parking parking;

    public Car(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void run() {
        
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
