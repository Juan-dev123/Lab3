package model;

public class HybridCar extends Car implements GasolineConsumable, BatteryConsumable{

    //Constants
    public static final int EXTRA=1;
    public static final int CORRIENTE=2;
    public static final int DIESEL=3;
    public static final int NORMAL=1;
    public static final int FAST=2;

    //Attributes
    private double tankCapacity;
    private int typeOfFuel;
    private double gasolineConsume;
    private int typeCharger;
    private double batteryDuration;
    private double batteryConsume;
    /**
     * It creates a new object type HybridCar
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
     * @param typeCharger The type of charger 
     * @param batteryDuration The battery duration
     */
    public HybridCar(double price, String brand, int model, double displacement, double mileage, boolean isNew, String licensePlate, Document soat, Document mechanicalTechnicalReview, int typeOfCar, int numberOfDoors, boolean tintedWindows, double tankCapacity, int typeOfFuel, int typeCharger, double batteryDuration){
        super(price, brand, model, displacement, mileage, isNew, licensePlate, soat, mechanicalTechnicalReview, typeOfCar, numberOfDoors, tintedWindows);
        this.tankCapacity=tankCapacity;
        this.typeOfFuel=typeOfFuel;
        this.gasolineConsume=calculateGasolineConsume();
        this.typeCharger=typeCharger;
        this.batteryDuration=batteryDuration;
        this.batteryConsume=calculateBatteryConsume();
        setTotalPrice(calculateTotalCost());
    }

    /**
     * It calculates the gasoline consume
     * @return The gasoline consume
     */
    @Override
    public double calculateGasolineConsume() {
        double gasolineConsume=tankCapacity*(getDisplacement()/110);
        return gasolineConsume;
    }

    /**
     * It calculates the battery consume
     * @return The battery consume
     */
    @Override
    public double calculateBatteryConsume() {
        double batteryConsume=0;
        if(typeCharger==FAST){
            batteryConsume=batteryDuration*(getDisplacement()/100);
        }else if(typeCharger==NORMAL){
            batteryConsume=(batteryDuration+5)*(getDisplacement()/100);
        }
        return batteryConsume;
    }

    @Override
    /**
     * @return Information about the hybrid car
     */
    public String toString() {
        String message="Hybrid Car\n"+super.toString();
        String typeOfFuelWord="";
        switch(typeOfFuel){
            case 1:
                typeOfFuelWord="Extra";
                break;
            case 2:
                typeOfFuelWord="Corriente";
                break;
            case 3:
                typeOfFuelWord="Diesel";
                break;
        }
        String typeOfCharge="";
        switch(typeCharger){
            case 1:
                typeOfCharge="Normal";
                break;
            case 2:
                typeOfCharge="Fast";
                break;
        }
        message+="    Tank capacity:"+tankCapacity+"\n"+"    Type of fuel:"+typeOfFuelWord+"\n"+"    Gasoline consume:"+gasolineConsume+"\n"+"    Type of charge:"+typeOfCharge+"\n"+"    Battery duration:"+batteryDuration+"\n"+"    Battery consume:"+batteryConsume+"\n";
        return message;
    }

    @Override
    /**
     * It calculates the total cost of a hybrid car
     * @return The total cost
     */
    public double calculateTotalCost() {
        double totalCost=getPrice();
        totalCost+=totalCost*0.15;
        if(getIsnew()==false){
            totalCost-=totalCost*0.1;
        }
        if(getSoat()==null || getMechanicalTechnicalReview()==null){
            totalCost+=500000;
        }else if(getSoat().getYear()!=Document.CURRENT_YEAR && getMechanicalTechnicalReview().getYear()!=Document.CURRENT_YEAR){
            totalCost+=500000;
        }
        return totalCost;
    }

    //getters
    /**
     * @return The tank capacity
     */
    public double getTankCapacity() {
        return tankCapacity;
    }

    /**
     * @return The type of fuel
     */
    public int getTypeOfFuel() {
        return typeOfFuel;
    }

    /**
     * @return The gasoline consume
     */
    public double getGasolineConsume() {
        return gasolineConsume;
    }

    /**
     * @return The type charger
     */
    public int getTypeCharger() {
        return typeCharger;
    }

    /**
     * @return The battery duration
     */
    public double getBatteryDuration() {
        return batteryDuration;
    }

    /**
     * @return The battery consume
     */
    public double getBatteryConsume() {
        return batteryConsume;
    }

    //setters
    /**
     * @param tankCapacity The tank capacity to set
     */
    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    /**
     * @param typeOfFuel The type of fuel to set
     */
    public void setTypeOfFuel(int typeOfFuel) {
        this.typeOfFuel = typeOfFuel;
    }

    /**
     * @param gasolineConsume The gasoline consume to set
     */
    public void setGasolineConsume(double gasolineConsume) {
        this.gasolineConsume = gasolineConsume;
    }

    /**
     * @param typeCharger The type charger to set
     */
    public void setTypeCharger(int typeCharger) {
        this.typeCharger = typeCharger;
    }

    /**
     * @param batteryDuration The battery duration to set
     */
    public void setBatteryDuration(double batteryDuration) {
        this.batteryDuration = batteryDuration;
    }

    /**
     * @param batteryConsume The battery consume to set
     */
    public void setBatteryConsume(double batteryConsume) {
        this.batteryConsume = batteryConsume;
    }
}