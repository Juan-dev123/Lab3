package model;

public class ParkingLot {
    
    //Relations
    private Vehicle[] vehicles;

    //Atributes
    private Vehicle[][] size;

    public ParkingLot(){
        size= new Vehicle[10][5];
        vehicles= new Vehicle[50];
    }

    //getters
    /**
     * @return The size
     */
    public Vehicle[][] getSize() {
        return size;
    }

   /**
    * @return The vehicles
    */
   public Vehicle[] getVehicles() {
       return vehicles;
   }

    //setters
    /**
     * @param size The size to set
     */
    public void setSize(Vehicle[][] size) {
        this.size = size;
    }

    /**
     * @param vehicles The vehicles to set
     */
    public void setVehicles(Vehicle[] vehicles) {
        this.vehicles = vehicles;
    }
}