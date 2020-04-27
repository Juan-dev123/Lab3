package model;

public class Motorcycle extends Vehicle implements GasolineConsumable{

    //Constants
    public static final int STANDARD=1;
    public static final int SPORTY=2;
    public static final int SCOOTER=3;
    public static final int CROSS=4;

    //Attributes
    private int type;
    private double gasolineCapacity;
    private double gasolineConsume;

    //Methods
    /**
     * It creates a new object type Motorcycle
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
     * @param type The type
     * @param gasolineCapacity The gasoline capacity
     * @param gasolineConsume The gasoline consume
     */
    public Motorcycle(double price, String brand, int model, double displacement, double mileage, boolean isNew, String licensePlate, Document soat, Document mechanicalTechnicalReview, int type, double gasolineCapacity, double gasolineConsume){
        super(price, brand, model, displacement, mileage, isNew, licensePlate, soat, mechanicalTechnicalReview);
        this.type=type;
        this.gasolineCapacity=gasolineCapacity;
        this.gasolineConsume=gasolineConsume;
    }

    @Override
    public double calculateGasolineConsume() {
        // TODO Auto-generated method stub
        return 0;
    }

    //getters
    /**
     * @return The type
     */
    public int getType() {
        return type;
    }

    /**
     * @return The gasoline capacity
     */
    public double getGasolineCapacity() {
        return gasolineCapacity;
    }

    /**
     * @return The gasoline consume
     */
    public double getGasolineConsume() {
        return gasolineConsume;
    }

    //setters
    /**
     * @param type The type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @param gasolineCapacity The gasoline capacity to set
     */
    public void setGasolineCapacity(double gasolineCapacity) {
        this.gasolineCapacity = gasolineCapacity;
    }

    /**
     * @param gasolineConsume The gasoline consume to set
     */
    public void setGasolineConsume(double gasolineConsume) {
        this.gasolineConsume = gasolineConsume;
    }
}