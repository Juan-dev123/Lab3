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
     * It creates a new object type Business
     * @param name The name 
     * @param nit The NIT
     * @param totalProfits The total profits
     * @param totalSales The total sales
     */
    public Business(String name, String nit, double totalProfits, int totalSales){
        this.name=name;
        this.nit=nit;
        this.totalProfits=totalProfits;
        this.totalSales=totalSales;
        sellers=new Seller[10];
        vehicles=new ArrayList<Vehicle>();
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