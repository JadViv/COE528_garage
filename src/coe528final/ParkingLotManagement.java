/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528final;

import java.util.Scanner;
import java.util.*;
/**
 * Overview: ParkingLotManagement are immutable. Consists of a Login method(main)
 * , menu method(parkingAttendantMain). Also, consists of a bookVehicle,
 * removeVehicle and, parkingLotInformation
 *
 * Abstraction Function: AF(c) = c.CarParkingLot| 0&lt;= CarParkingLot
 * &lt;= maxCapacity
 * 
 * Rep Invariant:
 * maxCapacity &lt;
 * c.CarParkingLot.size &lt;= maxCapacity
 * c.CarParkingLot.size &gt;
 */
public class ParkingLotManagement {
    private CarParkingLot parkingLot = new CarParkingLot();
    

    /**
     * Requires: An authorized user goes through main menu to gain access<br>
     * Modifies: parkingLot<br>
     * Effects: Allows the attendant to be able to book a new vehicle, remove
     * a registered vehicle, print out parking lot information and, return to 
     * the login screen.
     */
    public void parkingAttendantMain(){
        
        Scanner scanner = new Scanner(System.in);
        String s;
        System.out.println("\nLogin Successful\n" 
                + "Please type following commands:'\n"
                + "'logout' - to logout\n"
                + "'NV' - to create new vehicle\n"
                + "'RV' - to remove owner's vehicle\n"
                + "'PLI' - to view parking lot information \n "
                + "\n");
        
        s = scanner.next();
        
        while(!s.equalsIgnoreCase("logout")){
            if(s.equalsIgnoreCase("NV")){
                String VT, O, M, C, T, SPS, SSF;
                boolean PS, SF;
                int W;
                
                System.out.print ("Indicate Vehicle Type (Car, Truck, Motorcycle): ");
                VT = scanner.next();
                while ((!VT.equals("Car")) && (!VT.equals("Truck")) && (!VT.equals("Motorcycle")))
                {
                    System.out.println("Wrong Type!");
                    System.out.print ("Indicate Vehicle Type (Car, Truck, Motorcycle): ");
                    VT = scanner.next();
                }
                
                System.out.print("Indicate Owners Name: ");
                O = scanner.next();
                
                System.out.print("Indicate Model of Car: ");
                M = scanner.next();
                
                System.out.print("Indicate Color of Car: ");
                C = scanner.next();
                
                System.out.print ("Indicate Vehicle Type (Manual or Automatic): ");
                T = scanner.next();
                while ((!T.equals("Manual")) && (!T.equals("Automatic")))
                {
                    System.out.println("Wrong Transmission Type!");
                    System.out.print ("Indicate Vehicle Type (Manual or Automatic): ");
                    T = scanner.next();
                }

                do{
                    System.out.print ("Indicate Number of Wheels on Vehicle (1 - 6): ");
                    while (!scanner.hasNextInt()){
                        System.out.print("Please enter valid Integer: ");
                        scanner.next();
                    }
                    W = scanner.nextInt();
                }while (W < 0 && W > 7);

                System.out.print ("Parking Status (true or false): ");
                SPS = scanner.next();
                while ((!SPS.equals("true")) && (!SPS.equals("false")))
                {
                    System.out.println("Wrong Type!");
                    System.out.print ("Parking Status (true or false): ");
                    SPS = scanner.next();
                }
                
                if (SPS.equals("true")){
                    PS = true;
                }
                else
                    PS = false;
                

                
                System.out.print ("Special Feature existing? (true or false): ");
                SSF = scanner.next();
                while ((!SSF.equals("true")) && (!SSF.equals("false")))
                {
                    System.out.println("Wrong Type!");
                    System.out.print ("Special Feature existing? (true or false): ");
                    SSF = scanner.next();
                }
                
                if (SSF.equals("true")){
                    SF = true;
                }
                else
                    SF = false;                
                
                bookVehicle(VT, O, M, C, T, W, PS, SF);
            }
            else if(s.equalsIgnoreCase("RV")){
                String O;
                O = scanner.next();
                removeVehicle(O);
            }
            else if(s.equalsIgnoreCase("PLI")){
                parkingLotInformation();
             
            }
            
        System.out.println("\n" 
                + "Please type following commands:'\n"
                + "'logout' - to logout\n"
                + "'NV' - to create new vehicle\n"
                + "'RV' - to remove owner's vehicle\n"
                + "'PLI' - to view parking lot information \n "
                + "\n");
        
        s = scanner.next();
        }
    }
    /**
     * Requires: All parameters of the vehicle to be valid.<br>
     * Modifies: parkingLot.carParkingArray<br>
     * Effects: Creates a vehicle following the specifications provided.<br>
     * @param VT
     * @param O
     * @param M
     * @param C
     * @param WH
     * @param T
     * @param PS
     * @param SF 
     */
    public void bookVehicle(String VT, String O, String M, String C, String T,
            int WH, boolean PS, boolean SF){
        if(VT.equalsIgnoreCase("Car")){
            VehicleType AV = new Car(O, M, C, T, WH, PS, SF);
            parkingLot.addVehicle(AV);
            AV.toString();
        }
        else if (VT.equalsIgnoreCase("Truck")){
            Truck AV = new Truck(O, M, C, T, WH, PS, SF);
            parkingLot.addVehicle(AV);
        }
        else if (VT.equalsIgnoreCase("Motorcycle")){
            Motorcycle AV = new Motorcycle(O, M, C, T, WH, PS, SF);
            parkingLot.addVehicle(AV);
        }
        else System.out.println("Vehicle type not supportted");
    }
    /**
     * Requires: parkingLot is not empty and, the owners vehicle is registered
     * <br>
     * Modifies: parkingLot.carParkingArray<br>
     * Effects: Removes the owners vehicle from the parkingLot.carParkingArray
     * @param O 
     */
    public void removeVehicle(String O){
        parkingLot.removeVehicle(O);
    }
    /**
     * Effects: Prints out the information of the parking lot. Also, gives the 
     * option to print the list of cars.<br>
     */
    public void parkingLotInformation(){
        System.out.println(parkingLot);
    }
    /**
     * Effects: returns the string representation of the parkingLot and the
     * Vehicle details.
     * @return StringRepresentation
     */
    @Override
    public String toString(){
        return "The current parking lot has the following capacity"
                + parkingLot.toString()+ "and the vehicles inside are" ;
                //+ parkingLot.allVehicleDetails();
    }
    /**
     * Effects: Checks to see if the CarParkingLot to make sure it meets the 
     * rep invariant requirements.
     * @return 
     */
    public Boolean repOk(){
        return parkingLot.repOk();
    }

        /**
     * Effects: Confirms the login credentials of the attendant using preset
     * and send confirmed attendants to their menu
     * @param args 
     */ 
    public static void main(String[] args){
        ParkingLotManagement start = new ParkingLotManagement();
        String s;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the JAH Condo Residential Parking Management System");
        s = "start";
        while(!s.equals("end")){
        System.out.println("Please provide your Username and Password or type"
                + " 'end' to terminate the program");
        System.out.print("Login: ");
        s = scanner.nextLine();
            if("admin".equalsIgnoreCase(s)){
                System.out.print("Password: ");
                s = scanner.nextLine();
                if("admin".equalsIgnoreCase(s)){
                   start.parkingAttendantMain();
                }
                else System.out.println("Incorrect Password!");
            }
            else System.out.println("Incorrect Username!");
        }
    }
    
}
