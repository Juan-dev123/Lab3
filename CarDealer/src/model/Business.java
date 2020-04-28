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
        parkingLot=new ParkingLot();
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
        if(saveInParkingLot(model, isNew)){
            int freeSpace;
            message="The vehicle was registered successfully in the parking lot";
            GasolineCar vehicle=new GasolineCar(price, brand, model, displacement, mileage, isNew, licensePlate, soat, mechanicalTechnicalReview, typeOfCar, numberOfDoors, tintedWindows, tankCapacity, typeOfFuel, gasolineConsume);
            if(model==2011){
                freeSpace=lookForSpaceinParkingLot(3);
                if(freeSpace==-1){
                    freeSpace=lookForSpaceinParkingLot(4);
                    if(freeSpace==-1){
                        message="The vehicle was not registered. There is not space in the parking lot";
                    }else{
                        parkingLot.saveVehicle(freeSpace, 4, vehicle);
                    }
                }else{
                    parkingLot.saveVehicle(freeSpace, 3, vehicle);
                }
            }else if(model<2011){
                freeSpace=lookForSpaceinParkingLot(4);
                if(freeSpace==-1){
                    message="The vehicle was not registered. There is not space in the parking lot";
                }else{
                    parkingLot.saveVehicle(freeSpace, 4, vehicle);
                }
            }else{
                switch(model){
                    case 2014:
                        freeSpace=lookForSpaceinParkingLot(0);
                        if(freeSpace==-1){
                            
                            message="The vehicle was not registered. There is not space in the parking lot";
                        }else{
                            System.out.println("Im here");
                            System.out.println(freeSpace);
                            
                            parkingLot.saveVehicle(freeSpace, 0, vehicle);
                        }
                        break;
                    case 2013:
                        freeSpace=lookForSpaceinParkingLot(1);
                        if(freeSpace==-1){
                            message="The vehicle was not registered. There is not space in the parking lot";
                        }else{
                            parkingLot.saveVehicle(freeSpace, 1, vehicle);
                        }
                        break;
                    case 2012:
                        freeSpace=lookForSpaceinParkingLot(2);
                        if(freeSpace==-1){
                            message="The vehicle was not registered. There is not space in the parking lot";
                        }else{
                            parkingLot.saveVehicle(freeSpace, 2, vehicle);
                        }
                        break;
                }
            }
        }else{
            vehicles.add(new GasolineCar(price, brand, model, displacement, mileage, isNew, licensePlate, soat, mechanicalTechnicalReview, typeOfCar, numberOfDoors, tintedWindows, tankCapacity, typeOfFuel, gasolineConsume));
            message="The vehicle was registered successfully in the concessionaire";
        }
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
    public String registerVehicle(double price, String brand, int model, double displacement,double mileage, boolean isNew, String licensePlate, Document soat, Document mechanicalTechnicalReview, int typeOfCar, int numberOfDoors, boolean tintedWindows, int typeCharger, double batteryDuration, double batteryConsume){
        String message;
        if(saveInParkingLot(model, isNew)){
            int freeSpace;
            message="The vehicle was registered successfully in the parking lot";
            ElecticCar vehicle=new ElecticCar(price, brand, model, displacement, mileage, isNew, licensePlate, soat, mechanicalTechnicalReview, typeOfCar, numberOfDoors, tintedWindows, typeCharger, batteryDuration, batteryConsume);
            if(model==2011){
                freeSpace=lookForSpaceinParkingLot(3);
                if(freeSpace==-1){
                    freeSpace=lookForSpaceinParkingLot(4);
                    if(freeSpace==-1){
                        message="The vehicle was not registered. There is not space in the parking lot";
                    }else{
                        parkingLot.saveVehicle(freeSpace, 4, vehicle);
                    }
                }else{
                    parkingLot.saveVehicle(freeSpace, 3, vehicle);
                }
            }else if(model<2011){
                freeSpace=lookForSpaceinParkingLot(4);
                if(freeSpace==-1){
                    message="The vehicle was not registered. There is not space in the parking lot";
                }else{
                    parkingLot.saveVehicle(freeSpace, 4, vehicle);
                }
            }else{
                switch(model){
                    case 2014:
                        freeSpace=lookForSpaceinParkingLot(0);
                        if(freeSpace==-1){
                            
                            message="The vehicle was not registered. There is not space in the parking lot";
                        }else{
                            System.out.println("Im here");
                            System.out.println(freeSpace);
                            
                            parkingLot.saveVehicle(freeSpace, 0, vehicle);
                        }
                        break;
                    case 2013:
                        freeSpace=lookForSpaceinParkingLot(1);
                        if(freeSpace==-1){
                            message="The vehicle was not registered. There is not space in the parking lot";
                        }else{
                            parkingLot.saveVehicle(freeSpace, 1, vehicle);
                        }
                        break;
                    case 2012:
                        freeSpace=lookForSpaceinParkingLot(2);
                        if(freeSpace==-1){
                            message="The vehicle was not registered. There is not space in the parking lot";
                        }else{
                            parkingLot.saveVehicle(freeSpace, 2, vehicle);
                        }
                        break;
                }
            }
        }else{
            vehicles.add(new ElecticCar(price, brand, model, displacement,mileage, isNew, licensePlate, soat, mechanicalTechnicalReview, typeOfCar, numberOfDoors, tintedWindows, typeCharger, batteryDuration, batteryConsume));
            message="The vehicle was registered successfully";
        }
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
        if(saveInParkingLot(model, isNew)){
            int freeSpace;
            message="The vehicle was registered successfully in the parking lot";
            HybridCar vehicle=new HybridCar(price, brand, model, displacement, mileage, isNew, licensePlate, soat, mechanicalTechnicalReview, typeOfCar, numberOfDoors, tintedWindows, tankCapacity, typeOfFuel, gasolineConsume, typeCharger, batteryDuration, batteryConsume);
            if(model==2011){
                freeSpace=lookForSpaceinParkingLot(3);
                if(freeSpace==-1){
                    freeSpace=lookForSpaceinParkingLot(4);
                    if(freeSpace==-1){
                        message="The vehicle was not registered. There is not space in the parking lot";
                    }else{
                        parkingLot.saveVehicle(freeSpace, 4, vehicle);
                    }
                }else{
                    parkingLot.saveVehicle(freeSpace, 3, vehicle);
                }
            }else if(model<2011){
                freeSpace=lookForSpaceinParkingLot(4);
                if(freeSpace==-1){
                    message="The vehicle was not registered. There is not space in the parking lot";
                }else{
                    parkingLot.saveVehicle(freeSpace, 4, vehicle);
                }
            }else{
                switch(model){
                    case 2014:
                        freeSpace=lookForSpaceinParkingLot(0);
                        if(freeSpace==-1){
                            
                            message="The vehicle was not registered. There is not space in the parking lot";
                        }else{
                            System.out.println("Im here");
                            System.out.println(freeSpace);
                            
                            parkingLot.saveVehicle(freeSpace, 0, vehicle);
                        }
                        break;
                    case 2013:
                        freeSpace=lookForSpaceinParkingLot(1);
                        if(freeSpace==-1){
                            message="The vehicle was not registered. There is not space in the parking lot";
                        }else{
                            parkingLot.saveVehicle(freeSpace, 1, vehicle);
                        }
                        break;
                    case 2012:
                        freeSpace=lookForSpaceinParkingLot(2);
                        if(freeSpace==-1){
                            message="The vehicle was not registered. There is not space in the parking lot";
                        }else{
                            parkingLot.saveVehicle(freeSpace, 2, vehicle);
                        }
                        break;
                }
            }
        }else{
            vehicles.add(new HybridCar(price, brand, model, displacement, mileage, isNew, licensePlate, soat, mechanicalTechnicalReview, typeOfCar, numberOfDoors, tintedWindows, tankCapacity, typeOfFuel, gasolineConsume, typeCharger, batteryDuration, batteryConsume));
            message="The vehicle was registered successfully";
        }
        return message;
    }

    /**
     * It searches a vehicle
     * @param licensePlate The license plate
     * @return True if the vechicle exists. False if it doesn't.
     */
    public boolean searchVehicle(String licensePlate){
        boolean exist=false;
        boolean stop=false;
        for(int i=0; i<parkingLot.getVehicles().length && !stop; i++){
            if(parkingLot.getVehicles()[i]!=null){
                if(parkingLot.getVehicles()[i].getLicensePlate().equals(licensePlate)){
                    exist=true;
                    stop=true;
                }
            }else{
                stop=true;
            } 
        }
        if(!exist){
            for(int i=0; i<vehicles.size() && !exist;i++){
                if(vehicles.get(i).getLicensePlate().equals(licensePlate)){
                    exist=true;
                }
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
    /**
     * It checks if a car should go to the parking lot
     * @param model The model
     * @param isNew The status. True if the car is new. False if it doesn't 
     * @return True if the car should go to the praking lot. False if it shouldn't
     */
    public boolean saveInParkingLot(int model, boolean isNew){
        boolean toTheGarage=false;
        if(model<2015 && isNew==false){
            toTheGarage=true;
        }
        return toTheGarage;
    }

    /**
     * It searches a free space in a column of the parking lot
     * @param column The column
     * @return  The free space. If there are not space return -1
     */
    public int lookForSpaceinParkingLot(int column){
        int freeSpace=-1;
        boolean stop=false;
        Vehicle[][] parkinLot=this.parkingLot.getParkingLot();
        for(int i=0; i<parkinLot.length && !stop;i++){
            if(parkinLot[i][column]==null){
                freeSpace=i;
                stop=true;
            }
        }
        return freeSpace;
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