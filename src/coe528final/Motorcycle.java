/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528final;

/**
 *
 * @author Jad
 */
public class Motorcycle implements VehicleType {
    private String Owner;
    private String Model;
    private String Color;
    private String Transmission;
    private int Wheels;
    private boolean Status;
    private boolean Suspension;

    /**
     * 
     * @param Owner
     * @param Model
     * @param Color
     * @param Transmission
     * @param Wheels
     * @param Status
     * @param specialFeature 
     */
    public Motorcycle(String Owner, String Model, String Color, String Transmission, int Wheels, boolean Status, boolean specialFeature) {
        this.Owner = Owner;
        this.Model = Model;
        this.Color = Color;
        this.Transmission = Transmission;
        this.Wheels = Wheels;
        this.Status = Status;
        this.Suspension = specialFeature;
    }

    /**
     * 
     * @return 
     */
    public boolean isSuspension() {
        return Suspension;
    }

    /**
     * 
     * @param Suspension 
     */
    public void setSuspension(boolean Suspension) {
        this.Suspension = Suspension;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String Owner) {
        this.Owner = Owner;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getTransmission() {
        return Transmission;
    }

    public void setTransmission(String Transmission) {
        this.Transmission = Transmission;
    }

    public int getWheels() {
        return Wheels;
    }

    public void setWheels(int Wheels) {
        this.Wheels = Wheels;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString(){
        return ("Vehicle Type: Car, Owner: " + getOwner() + ", Model: " + getModel() 
                + ", Color: " + getColor() + ", Transmission: " + getTransmission() 
                + ", # of Wheels: " + getWheels() + ", Parking Status: " + isStatus() + ", Special Feature: " + isSuspension());
    }
    
    /**
     * Effects: Checks values of the variables on the CarParkingLot to make sure
     * they meet the rep invariant requirements.
     * @return 
     */
    public Boolean repOk(){
        if (Wheels < 0) return false;
        return true;
    }
}

