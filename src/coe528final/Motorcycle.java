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
    private boolean specialFeature;

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
        this.specialFeature = specialFeature;
    }

    /**
     * 
     * @return 
     */
    public boolean isspecialFeature() {
        return specialFeature;
    }

    /**
     * 
     * @param Suspension 
     */
    @Override
    public void setspecialFeature(boolean Suspension) {
        this.specialFeature = Suspension;
    }

    @Override
    public String getOwner() {
        return Owner;
    }

    @Override
    public void setOwner(String Owner) {
        this.Owner = Owner;
    }

    @Override
    public String getModel() {
        return Model;
    }

    @Override
    public void setModel(String Model) {
        this.Model = Model;
    }

    @Override
    public String getColor() {
        return Color;
    }

    @Override
    public void setColor(String Color) {
        this.Color = Color;
    }

    @Override
    public String getTransmission() {
        return Transmission;
    }

    @Override
    public void setTransmission(String Transmission) {
        this.Transmission = Transmission;
    }

    @Override
    public int getWheels() {
        return Wheels;
    }

    @Override
    public void setWheels(int Wheels) {
        this.Wheels = Wheels;
    }

    @Override
    public boolean isStatus() {
        return Status;
    }
    
    @Override
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
                + ", # of Wheels: " + getWheels() + ", Parking Status: " + isStatus() + ", Special Feature: " + isspecialFeature());
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

