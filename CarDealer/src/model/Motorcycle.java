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
     */
    public Motorcycle(double price, String brand, int model, double displacement, double mileage, boolean isNew, String licensePlate, Document soat, Document mechanicalTechnicalReview, int type, double gasolineCapacity){
        super(price, brand, model, displacement, mileage, isNew, licensePlate, soat, mechanicalTechnicalReview);
        this.type=type;
        this.gasolineCapacity=gasolineCapacity;
        this.gasolineConsume=calculateGasolineConsume();
        setTotalPrice(calculateTotalCost());
    }
    
    /**
     * It calculates the gasoline consume
     * @return The gasoline consume
     */
    @Override
    public double calculateGasolineConsume() {
        double gasolineConsume=gasolineCapacity*(getDisplacement()/90);
        return gasolineConsume;
    }
    
    /**
     * @return Information about the motorcycle
     */
    @Override
    public String toString() {
        String typeWord="";
        switch(type){
            case 1:
                typeWord="Standard";
                break;
            case 2:
                typeWord="Sporty";
                break;
            case 3:
                typeWord="Scooter";
                break;
            case 4:
                typeWord="Cross";
                break;
        }
        String message="Motorcycle\n"+super.toString();
        message+="    Type:"+typeWord+"\n"+"    Gasoline capacity:"+gasolineCapacity+"\n"+"    Gasoline consume:"+gasolineConsume+"\n";
        return message;
    }
    
    /**
     * It calculates the total cost of a motorcycle
     * @return The total cost
     */
    @Override
    public double calculateTotalCost() {
        double totalCost=getPrice();
        totalCost+=totalCost*0.04;
        if(getIsnew()==false){
            totalCost-=totalCost*0.02;
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