package model;

public class Soat extends Document implements Decodable{

    //Attributes
    private double moneyCovered;

    //Methods 
    /**
     * It creates a new object type Soat
     * @param price The price
     * @param year The year
     * @param moneyCovered The money covered for an accident to third parties
     */
    public Soat(double price, int year, double moneyCovered){
        super(price, year);
        this.moneyCovered=moneyCovered;
        setCode(decode());
    }

    @Override
    public int decode() {
        // TODO Auto-generated method stub
        return 0;
    }

    //getters
    /**
     * @return The money covered by an accident to third parties
     */
    public double getMoneyCovered() {
        return moneyCovered;
    }

    //setters
    /**
     * @param moneyCovered The money covered by an accident to third parties to set
     */
    public void setMoneyCovered(double moneyCovered) {
        this.moneyCovered = moneyCovered;
    }
}