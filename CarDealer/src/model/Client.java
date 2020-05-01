package model;

import java.util.ArrayList;

public class Client extends Person {
    
    //Relations
    private ArrayList<Vehicle> interestingCars; 
    private ArrayList<Vehicle> boughtCars;
    //Atributes
    private String phoneNumber;
    private String email;

    //Methods
    /**
     * It creates a new object type Client
     * @param name The name
     * @param lastName The last name
     * @param id The id
     * @param phoneNumber The phone number
     * @param email The email
     */
    public Client(String name, String lastName, int id, String phoneNumber, String email){
        super(name, lastName, id);
        this.phoneNumber=phoneNumber;
        this.email=email;
        interestingCars=new ArrayList<Vehicle>();
    }

    //getters
    /**
     * @return The phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @return The email
     */
    public String getEmail() {
        return email;
    }

   /** 
    * @return The interesting cars
    */
   public ArrayList<Vehicle> getInterestingCars() {
       return interestingCars;
   }

   /**
    * @return The bought cars
    */
   public ArrayList<Vehicle> getBoughtCars() {
       return boughtCars;
   }

    //setters
    /**
     * @param phoneNumber The phone number to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @param email The email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

   /**
    * @param interestingCars The interesting cars to set
    */
   public void setInterestingCars(ArrayList<Vehicle> interestingCars) {
       this.interestingCars = interestingCars;
   }

   /**
    * @param boughtCars The bought cars to set
    */
   public void setBoughtCars(ArrayList<Vehicle> boughtCars) {
       this.boughtCars = boughtCars;
   }
}
