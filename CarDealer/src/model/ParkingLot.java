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
        Vehicle vehicle1=new GasolineCar(50000, "KIA", 2014, 100, 12, false, "KLP123", new Soat(130000, 2014, 700000), new MechanicalTechnicalReview(80000, 2014, 12), 1, 4, true, 12, 1);
        Vehicle vehicle2=new GasolineCar(60000, "TOYOTA", 2013, 100, 12, false, "KLP456", new Soat(130000, 2013, 700000), new MechanicalTechnicalReview(80000, 2013, 12), 1, 4, true, 12, 1);
        Vehicle vehicle3=new GasolineCar(55000, "MERCEDES", 2012, 100, 12, false, "KLP789", new Soat(130000, 2012, 700000), new MechanicalTechnicalReview(80000, 2012, 12), 1, 4, true, 12, 1);
        Vehicle vehicle4=new GasolineCar(40000, "MERCEDES", 2011, 100, 12, false, "KLP101", new Soat(130000, 2011, 700000), new MechanicalTechnicalReview(80000, 2011, 12), 1, 4, true, 12, 1);
        Vehicle vehicle5=new GasolineCar(30000, "RENAULT", 2003, 100, 12, false, "KLP121", new Soat(130000, 2003, 700000), new MechanicalTechnicalReview(80000, 2003, 12), 1, 4, true, 12, 1);
        saveVehicle(0, 0, vehicle1);
        saveVehicle(0, 1, vehicle2);
        saveVehicle(0, 2, vehicle3);
        saveVehicle(0, 3, vehicle4);
        saveVehicle(0, 4, vehicle5);
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
     * @return The position empty. If all position are filled return -1
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

    /**
     * It removes a vehicle in the parking lot if there is in the parking lot
     * @param vehicle The vehicle
     */
    public void removeVehicle(Vehicle vehicle){
        for(int i=0; i<vehicles.length; i++){
            if(vehicles[i]!=null){
                if(vehicles[i]==vehicle){
                    vehicles[i]=null;
                }
            }
        }
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