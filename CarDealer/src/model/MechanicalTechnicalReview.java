package model;

public class MechanicalTechnicalReview extends Document implements Decodable {

    //Attributes
    private double gasLevels;

    /**
     * It creates an object type MechanicalTechnicalReview
     * @param price The price
     * @param year The year
     * @param gasLevels The gas levels
     */
    public MechanicalTechnicalReview(double price, int year, double gasLevels){
        super(price, year);
        this.gasLevels=gasLevels;
        setCode(decode());
    }

    @Override
    public int decode() {
        // TODO Auto-generated method stub
        return 0;
    }

    //getters
    /**
     * @return The gas levels
     */
    public double getGasLevels() {
        return gasLevels;
    }

    //setters
    /**
     * @param gasLevels The gas levels to set
     */
    public void setGasLevels(double gasLevels) {
        this.gasLevels = gasLevels;
    }
}