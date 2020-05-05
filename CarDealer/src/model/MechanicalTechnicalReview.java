package model;

public class MechanicalTechnicalReview extends Document implements Decodable {

    //Attributes
    private double gasLevels;

    /**
     * It creates an object type MechanicalTechnicalReview
     * @param price The price
     * @param year The year
     * @param gasLevels The gases levels
     */
    public MechanicalTechnicalReview(double price, int year, double gasLevels){
        super(price, year);
        this.gasLevels=gasLevels;
        setCode(decode());
    }

    /**
     * It decodes the image to obtain the code of the mechanical technical review
     * @return The code 
     */
    @Override
    public String decode() {
        String code="";
        int a=getImage().length-1;
        for(int i=0; i<getImage().length; i++){
            if(i==0){
                for(int j=0; j<getImage()[i].length; j++){
                    code=code+getImage()[i][j];
                }
            }else if(i>0 && i<getImage().length-1){
                code=code+getImage()[i][--a];
            }else{
                for(int j=0; j<getImage()[i].length; j++){
                    code=code+getImage()[i][j];
                }
            }  
        }
        return code;
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