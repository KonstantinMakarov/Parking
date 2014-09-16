package com.epam.parking.entity;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Use for ...
 */
public class Parking {

    private ArrayList<CarPlace> carPlaces = new ArrayList<CarPlace>(5){{
        add(new CarPlace());
        add(new CarPlace());
    }};

    private static Parking parking;
    public static Parking getInstance() {
        if(parking == null){
            parking = new Parking();
            return parking;
        }
        else return parking;
    }

    public ArrayList<CarPlace> getCarPlaces() {
        return (ArrayList<CarPlace>) Collections.unmodifiableList(carPlaces);
    }

}
