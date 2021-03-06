package model;

import java.util.ArrayList;

public class Client extends Person {
    
    //Relations
    private ArrayList<Vehicle> interestingVehicles; 
    private ArrayList<Vehicle> boughtVehicles;
    //Atributes
    private String phoneNumber;
    private String email;
    private boolean active;

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
        interestingVehicles=new ArrayList<Vehicle>();
        boughtVehicles=new ArrayList<Vehicle>();
        active=false;
    }

    /**
     * It adds a vehicle of interest to the client 
     * @param vehicle The vehicle
     */
    public void addInterestingVehicle(Vehicle vehicle){
        interestingVehicles.add(vehicle);
    }

    /**
     * It seaches a vehicle in the interested vehicles of the client
     * @param licensePlate The license plate of the vehivle
     * @return The vehicle
     */
    public Vehicle searchVehicle(String licensePlate){
        Vehicle vehicle=null;
        boolean exist=false;
        for(int i=0; i<interestingVehicles.size() && !exist;i++){
            if(interestingVehicles.get(i).getLicensePlate().equals(licensePlate)){
                vehicle=interestingVehicles.get(i);
                exist=true;
            }
        }
        return vehicle;
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
    * @return The interesting vehicles
    */
   public ArrayList<Vehicle> getInterestingVehicles() {
       return interestingVehicles;
   }

   /**
    * @return The bought vehicles
    */
   public ArrayList<Vehicle> getBoughtVehicles() {
       return boughtVehicles;
   }

   /**
    * @return The status of the client
    */
   public boolean getActive(){
       return active;
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
    * @param interestingVehicles The interesting vehicles to set
    */
   public void setInterestingVehicles(ArrayList<Vehicle> interestingVehicles) {
       this.interestingVehicles = interestingVehicles;
   }

   /**
    * @param boughtVehicles The bought vehicles to set
    */
   public void setBoughtVehicles(ArrayList<Vehicle> boughtVehicles) {
       this.boughtVehicles = boughtVehicles;
   }

   /**
    * @param active The satus of the client to set
    */
   public void setActive(boolean active) {
       this.active = active;
   }
}
