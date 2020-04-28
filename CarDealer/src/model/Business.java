package model;

import java.util.ArrayList;

public class Business {
    //Relations
    private Seller[] sellers;
    private ArrayList<Vehicle> vehicles;
    private ParkingLot parkingLot;

    //Attributes
    private String name;
    private String nit;
    private double totalProfits;
    private int totalSales;

    //Methods
    /**
     * It creates a new object type Business and also creates 7 sellers
     * @param name The name 
     * @param nit The NIT
     * @param totalProfits The total profits
     * @param totalSales The total sales
     */
    public Business(String name, String nit){
        this.name=name;
        this.nit=nit;
        this.totalProfits=0;
        this.totalSales=0;
        sellers=new Seller[10];
        //Sellers created by default
        sellers[0]= new Seller("Michaela", "Pratt", 1234567);
        sellers[1]= new Seller("Annalise", "Keating", 2345678);
        sellers[2]= new Seller("Connor", "Walsh", 3456789);
        sellers[3]= new Seller("Asher", "Millstong", 4567890);
        sellers[4]= new Seller("Frank", "Delfino", 5678901);
        sellers[5]= new Seller("Bonnie", "Winterbottom", 6789012);
        sellers[6]= new Seller("Oliver", "Hampton", 7890123);

        vehicles=new ArrayList<Vehicle>();
    }

    /**
     * It registered a new motorcycle
     * @param price The base price
     * @param brand The brand
     * @param model The year of the model
     * @param displacement The displacement  
     * @param mileage The mileage
     * @param isNew The status. True if the car is new. False if it doesn't 
     * @param licensePlate The license plate
     * @param soat The soat
     * @param mechanicalTechnicalReview The mechanical technical review
     * @param type The type
     * @param gasolineCapacity The gasoline capacity
     * @param gasolineConsume The gasoline consume
     * @return A message informing that the vehicle was registered
     */
    public String registerVehicle(double price, String brand, int model, double displacement, double mileage, boolean isNew, String licensePlate, Document soat, Document mechanicalTechnicalReview, int type, double gasolineCapacity, double gasolineConsume){
        String message;
        vehicles.add(new Motorcycle(price, brand, model, displacement, mileage, isNew, licensePlate, soat, mechanicalTechnicalReview, type, gasolineCapacity, gasolineConsume));
        message="The vehicle was registered successfully";
        return message;
    }
    /**
     * It registered a new gasoline car
     * @param price The base price
     * @param brand The brand
     * @param model The year of the model
     * @param displacement The displacement  
     * @param mileage The mileage
     * @param isNew The status. True if the car is new. False if it doesn't 
     * @param licensePlate The license plate
     * @param soat The soat
     * @param mechanicalTechnicalReview The mechanical technical review
     * @param typeOfCar The type of car
     * @param numberOfDoors The number of doors
     * @param tintedWindows True if the windows are tinted. False if they don't
     * @param tankCapacity The tank capacity
     * @param typeOfFuel The type of fuel
     * @param gasolineConsume The gasoline consume
     * @return A message informing that the vehicle was registered
     */
    public String registerVehicle(double price, String brand, int model, double displacement, double mileage, boolean isNew, String licensePlate, Document soat, Document mechanicalTechnicalReview, int typeOfCar, int numberOfDoors, boolean tintedWindows, double tankCapacity, int typeOfFuel, double gasolineConsume){
        String message;
        vehicles.add(new GasolineCar(price, brand, model, displacement, mileage, isNew, licensePlate, soat, mechanicalTechnicalReview, typeOfCar, numberOfDoors, tintedWindows, tankCapacity, typeOfFuel, gasolineConsume));
        message="The vehicle was registered successfully";
        return message;
    }

    /**
     * It registers a new electric car
     * @param price The base price
     * @param brand The brand
     * @param model The year of the model
     * @param displacement The displacement  
     * @param mileage The mileage
     * @param isNew The status. True if the car is new. False if it doesn't 
     * @param licensePlate The license plate
     * @param soat The soat
     * @param mechanicalTechnicalReview The mechanical technical review
     * @param typeOfCar The type of car
     * @param numberOfDoors The number of doors
     * @param tintedWindows True if the windows are tinted. False if they don't
     * @param typeCharger The type of charger 
     * @param batteryDuration The battery duration
     * @param batteryConsume The battery consume
     * @return A message informing that the vehicle was registered
     */
    public String registerVehicle(double price, String brand, int model, double mileage, boolean isNew, String licensePlate, Document soat, Document mechanicalTechnicalReview, int typeOfCar, int numberOfDoors, boolean tintedWindows, int typeCharger, double batteryDuration, double batteryConsume){
        String message;
        vehicles.add(new ElecticCar(price, brand, model, mileage, isNew, licensePlate, soat, mechanicalTechnicalReview, typeOfCar, numberOfDoors, tintedWindows, typeCharger, batteryDuration, batteryConsume));
        message="The vehicle was registered successfully";
        return message;
    }

    /**
     * It registers a new hybrid car
     * @param price The base price
     * @param brand The brand
     * @param model The year of the model
     * @param displacement The displacement  
     * @param mileage The mileage
     * @param isNew The status. True if the car is new. False if it doesn't 
     * @param licensePlate The license plate
     * @param soat The soat
     * @param mechanicalTechnicalReview The mechanical technical review
     * @param typeOfCar The type of car
     * @param numberOfDoors The number of doors
     * @param tintedWindows True if the windows are tinted. False if they don't
     * @param tankCapacity The tank capacity
     * @param typeOfFuel The type of fuel
     * @param gasolineConsume The gasoline consume
     * @param typeCharger The type of charger 
     * @param batteryDuration The battery duration
     * @param batteryConsume The battery consume
     * @return A message informing that the vehicle was registered 
     */
    public String registerVehicle(double price, String brand, int model, double displacement, double mileage, boolean isNew, String licensePlate, Document soat, Document mechanicalTechnicalReview, int typeOfCar, int numberOfDoors, boolean tintedWindows, double tankCapacity, int typeOfFuel, double gasolineConsume, int typeCharger, double batteryDuration, double batteryConsume){
        String message;
        vehicles.add(new HybridCar(price, brand, model, displacement, mileage, isNew, licensePlate, soat, mechanicalTechnicalReview, typeOfCar, numberOfDoors, tintedWindows, tankCapacity, typeOfFuel, gasolineConsume, typeCharger, batteryDuration, batteryConsume));
        message="The vehicle was registered successfully";
        return message;
    }

    /**
     * It searches a vehicle
     * @param licensePlate The license plate
     * @return True if the vechicle exists. False if it doesn't.
     */
    public boolean searchVehicle(String licensePlate){
        boolean exist=false;
        for(int i=0; i<vehicles.size() && !exist;i++){
            if(vehicles.get(i).getLicensePlate().equals(licensePlate)){
                exist=true;
            }
        }
        return exist;
    }
    /**
     * It creates an object type Soat
     * @param price The price
     * @param year The year
     * @param moneyCovered The money covered for an accident to third parties
     * @return The object type Soat
     */
    public Soat createSoat(double price, int year, double moneyCovered){
        Soat soat=new Soat(price, year, moneyCovered);
        return soat;
    }

    /**
     * It creates an object type MechanicalTechnicalReview
     * @param price The price
     * @param year The year
     * @param gasLevels The gases levels
     * @return The object type MechanicalTechnicalReview
     */
    public MechanicalTechnicalReview createMTR(double price, int year, double gasLevels){
        MechanicalTechnicalReview mtr=new MechanicalTechnicalReview(price, year, gasLevels);
        return mtr;
    }

    //getters
    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @return The NIT
     */
    public String getNit() {
        return nit;
    }

    /**
     * @return The total profits
     */
    public double getTotalProfits() {
        return totalProfits;
    }

    /**
     * @return The total sales
     */
    public int getTotalSales() {
        return totalSales;
    }

    /**
     * @return The sellers
     */
    public Seller[] getSellers() {
        return sellers;
    }

    /**
     * @return The vehicles
     */
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * @return The parking lot
     */
    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    //setters
    /**
     * @param name The name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param nit The NIT to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * @param totalProfits The total profits to set
     */
    public void setTotalProfits(double totalProfits) {
        this.totalProfits = totalProfits;
    }

    /**
     * @param totalSales The total sales to set
     */
    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

    /**
     * @param sellers The sellers to set
     */
    public void setSellers(Seller[] sellers) {
        this.sellers = sellers;
    }

    /**
     * @param vehicles The vehicles to set
     */
    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * @param parkingLot The parking lot to set
     */
    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}