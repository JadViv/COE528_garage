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
public interface VehicleType {
    String Owner = null;
    String Model = null;
    String Color = null;
    String Transmission = null;
    int Wheels = -1;
    boolean Status = false;
    boolean specialFeature = false;

    String getOwner();
    String getModel();
    String getColor();
    String getTransmission();
    int getWheels();
    boolean isStatus();
    boolean isspecialFeature();
    
    public void setOwner(String Owner);
    public void setModel(String Model);
    public void setColor(String Color);
    public void setTransmission(String Transmission);
    public void setWheels(int Wheels);
    public void setStatus(boolean Status);
    public void setspecialFeature(boolean specialFeature);
    
    @Override
    public String toString();

    @Override
    public boolean equals(Object obj);

    @Override
    public int hashCode();
    

}
