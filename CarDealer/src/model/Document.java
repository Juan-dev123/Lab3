package model;

public abstract class Document {

    //Atributes
    private double price;
    private int year;
    private int[][] image;
    private int code;

    //Methods
    public Document(double price, int year){
        this.price=price;
        this.year=year;
        image=new int[4][4]; //COMPLETEEEE
    }

    //getters
    /**
     * @return The price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return The year
     */
    public int getYear() {
        return year;
    }

    /**
     * @return The image
     */
    public int[][] getImage() {
        return image;
    }

    /**
     * @return The code
     */
    public int getCode() {
        return code;
    }

    //setters
    /**
     * @param price The price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @param year The year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @param image The image to set
     */
    public void setImage(int[][] image) {
        this.image = image;
    }

    /**
     * @param code The code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

}