/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528final;

import java.util.ArrayList;
import java.util.*;
/**
 *
 * @author Hassan
 */
/**OVERVIEW: 
 * CarParkingLots are Mutable. Consist of and ArrayList bound to 50 spots 
 containing VehicleType objects.<br>
 * A typical CarParkingLot is {AbstractVehicle1, AbstractVehicle2,... 
 * AbstactVehicle50}.<br><br>
 * Abstraction Function: AF(c) = c.carParkingArray.get(n)| 0&lt;= n &lt;= maxCapacity<br>
 * <br>
 * Rep Invariant:<br>
 * maxCapacity &lt; 0<br>
 * c.carParkingArray.size &lt;= maxCapacity<br>
 * c.carParkingArray.size &gt;=0
 */
public class CarParkingLot {
    
    //Variables
    private static final int maxCapacity = 50;
    private final ArrayList<VehicleType> carParkingArray;
    
    //Constructor
    public CarParkingLot(){
        carParkingArray = new ArrayList<>(maxCapacity);
    }
    /**
     * Effects: Subtracts the size of the carParkingArray from the maxCapacity 
     * to get the amount of available spots in the carParkingArray.<br>
     * @return numOfAvailableSpots
     */
    public int AvailableSpots(){
        return maxCapacity - carParkingArray.size();
    }
    /**
     * Effects: returns the size of the carParkingArray<br>
     * @return numOfOccupiedSpots
     */
    public int OccupiedSpots(){
        return carParkingArray.size();
    }
    /**
     * Requires: carParkingArray is not full<br>
     * Modifies: carParkingArray<br>
     * Effects: Adds the vehicle to the carParkingArray<br>
     * @param vehicle 
     */
    public void addVehicle(VehicleType vehicle){
        if(AvailableSpots() > 0){
            carParkingArray.add(vehicle);
            System.out.println("Vehicle added Parking Lot");
        }
        else{
            System.out.println("Parking lot full");
        }
    }
    
    /**
     * Requires: carParkingArray is not empty<br>
     * Modifies: carParkingArray<br>
     * Effects: removes the Owner's vehicle from the carParkingArray<br>
     * @param Owner 
     */
        
    public void removeVehicle(String Owner){
        for(VehicleType AV : carParkingArray){
                    if (Owner.equalsIgnoreCase(AV.getOwner())){
                        carParkingArray.remove(AV);
                    }
        }
    }
    /**
     * Effects: returns the maxCapacity value of the CarParkingLot
     * @return 
     */
    public int getMaxCapacity(){
        return maxCapacity;
    }

    
    /**
     * Effects: returns the string representation of the CarParkingLot<br>
     * @return StringRepresentation
     */
    @Override
    public String toString(){
        for (int i = 0 ; i < carParkingArray.size() ; i++){
            VehicleType AV = carParkingArray.get(i); 
            System.out.println("#"+ (i+1)+": " + AV);
        }
        return ("Max Capacity: " + getMaxCapacity());
    }
    /**
     * Effects: Checks values of the variables on the CarParkingLot to make sure
     * they meet the rep invariant requirements.
     * @return 
     */
    public Boolean repOk(){
        if (maxCapacity<0) return false;
        if (carParkingArray.size() > maxCapacity) return false;
        if (carParkingArray.size() < 0) return false;
        return true;
    }
    
}
