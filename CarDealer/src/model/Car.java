package model;

public abstract class Car extends Vehicle {
    
    //Contants
    public static final int SEDAN=1;
    public static final int VAN=2;

    //Attributes
    private int typeOfCar;
    private int numberOfDoors;
    private boolean tintedWindows;

    //Methods
    /**
     * It creates a new object type Car
     * @param totalPrice The total price
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
     */
    public Car(double price, String brand, int model, double displacement, double mileage, boolean isNew, String licensePlate, Document soat, Document mechanicalTechnicalReview, int typeOfCar, int numberOfDoors, boolean tintedWindows){
        super(price, brand, model, displacement, mileage, isNew, licensePlate, soat, mechanicalTechnicalReview);
        this.typeOfCar=typeOfCar;
        this.numberOfDoors=numberOfDoors;
        this.tintedWindows=tintedWindows;
    }

    //getters
    /**
     * @return The type of car
     */
    public int getTypeOfCar() {
        return typeOfCar;
    }

    /**
     * @return The number of doors
     */
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    /**
     * @return True if the windows are tinted. False if they don't
     */
    public boolean getTintedWindows(){
        return tintedWindows;
    }

    //setters
    /**
     * @param typeOfCar The type of car to set
     */
    public void setTypeOfCar(int typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    /**
     * @param numberOfDoors The number of doors to set
     */
    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    /**
     * @param tintedWindows True if the windows are tinted. False if they don't
     */
    public void setTintedWindows(boolean tintedWindows) {
        this.tintedWindows = tintedWindows;
    }
}