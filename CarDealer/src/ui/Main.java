package ui;

import java.util.Scanner;
import model.Business;

public class Main{
    
    //Relations 
    public static Business business;
    public static Scanner read;
    
    //Methods
    public static void main(String[] args){
        int option;
        System.out.println("What do you want to do?");
        System.out.println("1 Register a vehicle");
        option=read.nextInt();
        switch(option){
            case 1:
                registerVehicle();
                break;
            default:
                System.out.println("That option doesn't exist");
                break;
        }

    }

    public static void registerVehicle(){
        System.out.println("Please give this information about the vehicle");
        System.out.println("Enter the brand");
        
    }
}
