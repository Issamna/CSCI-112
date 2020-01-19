/**
 * @author Issam Ahmed
 *         CSCI 112 Summer 2019
 */
public class CellPhone extends Product {
    private String model;       //stores model
    private String macNumber;   //stores MAC number
    private double screenSize;  //stores screen size

    //Constructor methods

    /*
    Default constructor
    Post-conditions: name = "Unknown Product"; price = 0.0; macNumber = ""; screenSize = 0.0; model=""
    */
    public CellPhone(){
        super();
        this.macNumber = "";
        this.screenSize=0.0;
        this.model="";
    }

    /*Constructor with all parameters
      CellPhone Product is initialized with given parameters
      Post-conditions: productNumber = productNumber; name = name; price = price; macNumber = macNumber; screenSize = screenSize; model= model
     */
    public CellPhone(int productNumber, String name, double price, String model, String macNumber, double screenSize){
        super(productNumber, name, price);
        this.macNumber = macNumber;
        this.screenSize=screenSize;
        this.model=model;
    }


    //mutator methods

    /*Method to set model
      model is set according to the parameter
      Post-conditions: model = model
     */
    public void setModel(String model){
        this.model=model;
    }

    /*Method to set macNumber
      macNumber is set according to the parameter
      Post-conditions: macNumber = macNumber
     */
    public void setMacNumber(String macNumber){
        this.macNumber = macNumber;
    }

    /*Method to set screenSize
      screenSize is set according to the parameter
      Post-conditions: screenSize = screenSize
     */
    public void setScreenSize(double screenSize){
        this.screenSize=screenSize;
    }

    //accessor methods

    /*Method to return model
      Post-conditions: value of model is returned
     */
    public String getModel(){
        return model;
    }

    /*Method to return MAC number
      Post-conditions: value of macNumber is returned
     */
    public String getMacNumber(){
        return macNumber;
    }

    /*Method to return screen size
      Post-conditions: value of screenSize is returned
     */
    public double getScreenSize(){
        return screenSize;
    }

    //other methods

    //Method to return object properties as String
    @Override
    public String toString(){
        String x = super.toString();
        x=x+(", "+model+", "+macNumber+", "+screenSize);
        return x;
    }
    /*
    method to compare properties of two cellphone objects
    Post-condition: Returns true if this cellphone is equal to
                   cellphone parameter; otherwise returns false
    */
    public boolean equals(CellPhone c){
        if (! super.equals(c)){
            return false;
        }
        if(this.getModel()!=c.getModel() || this.getMacNumber() != c.getMacNumber()||this.getScreenSize() != c.getScreenSize()){
            return false;
        }
         return true;
    }
    //method compares two cellphones models, returns int
    @Override
    public int compareTo(Object b) {
        CellPhone temp = (CellPhone) b;
        int x;
        x = this.model.compareTo(temp.model);
        return x;
    }

}