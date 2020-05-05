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
    
    /**
     * It decodes the image to obtain the code of the Soat
     * @return The code 
     */
    @Override
    public String decode() {
        String code="";
        //Travel in L
        for(int i=0; i<getImage().length;i++){
            if(i==getImage().length-1){
                for(int j=0; j<getImage()[i].length; j++){
                    code=code+getImage()[i][j];
                }
            }else{
                code=code+getImage()[i][0];
            }
        }
        return code;
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