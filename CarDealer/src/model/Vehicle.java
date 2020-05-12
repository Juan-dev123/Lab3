package model;

public abstract class Vehicle {

    //Relations
    private Document mechanicalTechnicalReview;
    private Document soat;
    private Client owner;

    //Attributes
    private double totalPrice;
    private double price;
    private String brand;
    private int model;
    private double displacement;
    private double mileage;
    private boolean isNew;
    private String licensePlate;
    private boolean sold;

    //Methods
    /**
     * It creates an object type Vehicle
     * @param price The base price
     * @param brand The brand
     * @param model The year of the model
     * @param displacement The displacement  
     * @param mileage The mileage
     * @param isNew The status. True if the car is new. False if it doesn't 
     * @param licensePlate The license plate
     * @param soat The soat
     * @param mechanicalTechnicalReview The mechanical technical review
     */
    public Vehicle(double price, String brand, int model, double displacement, double mileage, boolean isNew, String licensePlate, Document soat, Document mechanicalTechnicalReview){
        this.price=price;
        this.brand=brand;
        this.model=model;
        this.displacement=displacement;
        this.mileage=mileage;
        this.isNew=isNew;
        this.licensePlate=licensePlate;
        this.soat=soat;
        this.mechanicalTechnicalReview=mechanicalTechnicalReview;
        sold=false;
        owner=null;
    }
    
    /**
     * @return Information about the vehicle
     */
    @Override
    public String toString() {
        String status;
        String licenseP;
        String soatStatus="Up to date";
        String MTRStatus="Up to date";
        if(isNew==true){
            status="New";
        }else{
            status="Used";
        }
        if(licensePlate.equals("")){
            licenseP="It doesn't have";
        }else{
            licenseP=licensePlate;
        }
        if(soat==null){
            soatStatus="It doesn't have";
        }else if(soat.getYear()!=Document.CURRENT_YEAR){
            soatStatus="Expired";
        }
        if(mechanicalTechnicalReview==null){
            MTRStatus="It doesn't have";
        }else if(mechanicalTechnicalReview.getYear()!=Document.CURRENT_YEAR){
            MTRStatus="Expired";
        }

        String message="    Total price:"+totalPrice+"\n"+"    Price:"+price+"\n"+"    Brand:"+brand+"\n"+"    Model:"+model+"\n"+"    Displacement:"+displacement+"\n"+"    Mileage:"+mileage+"\n"+"    Status:"+status+"\n"+"    License plate:"+licenseP+"\n"+"    Soat:"+soatStatus+"\n"+"    Mechanical Technical Review:"+MTRStatus+"\n";

        return message;
    }

    /**
     * It calculates the total cost of a vehicle
     * @return The total cost
     */
    public abstract double calculateTotalCost();

    //getters
    /**
     * @return The totalPrice
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * @return The price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return The brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @return The model
     */
    public int getModel() {
        return model;
    }

    /**
     * @return The displacement
     */
    public double getDisplacement() {
        return displacement;
    }

    /**
     * @return The mileage
     */
    public double getMileage() {
        return mileage;
    }

    /**
     * @return The status. True if the car is new. False if it doesn't
     */
    public boolean getIsnew(){
        return isNew;
    }

    /**
     * @return The license plate
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * @return The soat
     */
    public Document getSoat() {
        return soat;
    }

    /**
     * @return The mechanical technical review
     */
    public Document getMechanicalTechnicalReview() {
        return mechanicalTechnicalReview;
    }
    /**
     * @return The status of the vehicle
     */
    public boolean getSold(){
        return sold;
    }

    /**
     * @return The owner
     */
    public Client getOwner() {
        return owner;
    }

    //setters
    /**
     * @param totalPrice The total price to set
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * @param price The price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @param brand The brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @param model The model to set
     */
    public void setModel(int model) {
        this.model = model;
    }

    /**
     * @param displacement The displacement to set
     */
    public void setDisplacement(double displacement) {
        this.displacement = displacement;
    }

    /**
     * @param mileage The mileage to set
     */
    public void setMileage(double mileage) {
        this.mileage = mileage;
    }
    /**
     * @param isNew The status to set. True if the car is new. False if it doesn't
     */
    public void setIsNew(boolean isNew){
        this.isNew=isNew;
    }

    /**
     * @param licensePlate The license plate to set
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    /**
     * @param soat The soat to set
     */
    public void setSoat(Document soat) {
        this.soat = soat;
    }

    /**
     * @param mechanicalTechnicalReview The mechanical technical review to set
     */
    public void setMechanicalTechnicalReview(Document mechanicalTechnicalReview) {
        this.mechanicalTechnicalReview = mechanicalTechnicalReview;
    }

    /**
     * @param sold The available to set
     */
    public void setSold(boolean sold) {
        this.sold = sold;
    }

    /**
     * @param owner The owner to set
     */
    public void setOwner(Client owner) {
        this.owner = owner;
    }
}