package model;

import java.util.Calendar;

public abstract class Document {

    public static final int CURRENT_YEAR=Calendar.getInstance().get(Calendar.YEAR);

    //Atributes
    private double price;
    private int year;
    private int[][] image;
    private String code;

    //Methods
    /**
     * It creates a new object type Document
     * @param price The price
     * @param year The year
     */
    public Document(double price, int year){
        this.price=price;
        this.year=year;
        image=new int[4][4]; 
        //Initializes the image with random values
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                image[i][j]=(int)(Math.random()*49+1);
            }
        }
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
    public String getCode() {
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
    public void setCode(String code) {
        this.code = code;
    }

}