package model;

public class GasolineCar extends Car implements GasolineConsumable{
    
    //Constants
    public static final int EXTRA=1;
    public static final int CORRIENTE=2;
    public static final int DIESEL=3;

    //Attributes
    private double tankCapacity;
    private int typeOfFuel;
    private double gasolineConsume;
    /**
     * It creates an object type GasolineCar
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
     */
    public GasolineCar(double price, String brand, int model, double displacement, double mileage, boolean isNew, String licensePlate, Document soat, Document mechanicalTechnicalReview, int typeOfCar, int numberOfDoors, boolean tintedWindows, double tankCapacity, int typeOfFuel, double gasolineConsume){
        super(price, brand, model, displacement, mileage, isNew, licensePlate, soat, mechanicalTechnicalReview, typeOfCar, numberOfDoors, tintedWindows);
        this.tankCapacity=tankCapacity;
        this.typeOfFuel=typeOfFuel;
        this.gasolineConsume=gasolineConsume;
    }

    @Override
    public double calculateGasolineConsume() {
        // TODO Auto-generated method stub
        return 0;
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
}