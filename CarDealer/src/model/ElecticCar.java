package model;

public class ElecticCar extends Car implements BatteryConsumable{

    //Constants
    public static final int NORMAL=1;
    public static final int FAST=2;

    //Attributes
    private int typeCharger;
    private double batteryDuration;
    private double batteryConsume;

    //Methods
    /**
     * It creates an object type ElectricCar
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
     */
    public ElecticCar(double price, String brand, int model,double displacement, double mileage, boolean isNew, String licensePlate, Document soat, Document mechanicalTechnicalReview, int typeOfCar, int numberOfDoors, boolean tintedWindows, int typeCharger, double batteryDuration, double batteryConsume){
        super(price, brand, model, displacement, mileage, isNew, licensePlate, soat, mechanicalTechnicalReview, typeOfCar, numberOfDoors, tintedWindows);
        this.typeCharger=typeCharger;
        this.batteryDuration=batteryDuration;
        this.batteryConsume=batteryConsume;
    }

    @Override
    public double calculateBatteryConsume() {
        // TODO Auto-generated method stub
        return 0;
    }

    //getters
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