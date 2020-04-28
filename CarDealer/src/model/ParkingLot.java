package model;

public class ParkingLot {
    
    //Relations
    private Vehicle[] vehicles;

    //Atributes
    private Vehicle[][] parkingLot;

    /**
     * It creates a new object type ParkingLot
     */
    public ParkingLot(){
        parkingLot= new Vehicle[10][5];
        vehicles= new Vehicle[50];
    }

    /**
     * It saves a vehicle in the parking lot
     * @param column The column
     * @param row The row
     * @param vehicle The vehicle
     */
    public void saveVehicle(int row, int column, Vehicle vehicle){
        parkingLot[row][column]=vehicle;
        vehicles[getPositionEmpty()]=vehicle;
        
    }
    /**
     * It searches an empty position in the array vehicles
     * @return The position empty
     */
    public int getPositionEmpty(){
        int position=-1;
        boolean stop=false;
        for(int i=0;i<this.vehicles.length && !stop; i++){
            if(vehicles[i]==null){
                position=i;
                stop=true;
            }
        }
        return position;
    }

    //getters
    /**
     * @return The parking lot
     */
    public Vehicle[][] getParkingLot() {
        return parkingLot;
    }

   /**
    * @return The vehicles
    */
   public Vehicle[] getVehicles() {
       return vehicles;
   }

    //setters
    /**
     * @param parkingLot The parking lot to set
     */
    public void setParkingLot(Vehicle[][] parkingLot) {
        this.parkingLot = parkingLot;
    }

    /**
     * @param vehicles The vehicles to set
     */
    public void setVehicles(Vehicle[] vehicles) {
        this.vehicles = vehicles;
    }
}