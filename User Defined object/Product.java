/**
 * @author Issam Ahmed
 *         CSCI 112 Summer 2019
 */
public class Product implements Comparable{
    private int productNumber; //stores product number
    private String name;    //stores product name
    private double price;   //stores price
    //Constructor methods

    /*
    Default constructor
    Post-conditions: name = "Unknown Product"; price = 0.0
    */
    public Product(){
        this.productNumber = 0;
        this.name = "Unknown Product";
        this.price = 0.0;
    }

    /*Constructor with parameters
      Product is initialized with given parameters
      Post-conditions: name = name; price = price
     */
    public Product(int productNumber, String name, double price){
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
    }

    //mutator methods

    /*Method to set product number
      product number is set according to the parameter
      Post-conditions: productNumber = productNumber
     */
    public void setProductNumber(int productNumber){
        this.productNumber=productNumber;
    }

    /*Method to set name
      name is set according to the parameter
      Post-conditions: name = name
     */
    public void setName(String name){
        this.name=name;
    }

    /*Method to set price
      price is set according to the parameter
      Post-conditions: price = price
     */
    public void setPrice(double price){
        this.price=price;
    }

    //Accessor methods

    /*Method to return name
      Post-conditions: value of name is returned
     */
    public int getProductNumber(){
        return productNumber;
    }

    /*Method to return name
      Post-conditions: value of name is returned
     */
    public String getName(){
        return name;
    }

    /*Method to return price
      Post-conditions: value of price is returned
     */
    public double getPrice(){
        return price;
    }

    //other methods

    //Method to return object properties as String
    @Override
    public String toString(){
        return (productNumber+" "+name+", "+String.format("%.2f", price));
    }

    /*
    method to compare properties of two product objects
    Post-condition: Returns true if this product is equal to
                   product parameter; otherwise returns false
    */
    public boolean equals(Product c){
        if(this == c){
            return true;
        }
        if(c == null){
            return false;
        }
        if(this.getName()!=c.getName()||this.getPrice() != c.getPrice()||this.getProductNumber()!=c.getProductNumber()){
            return false;
        }
        return true;
    }

    //method compares two products product number, returns int
    @Override
    public int compareTo(Object b) {
        Product temp = (Product) b;
        int x;
        if(this.getProductNumber() == temp.getProductNumber()){
            x=0;
        }
        else if (this.getProductNumber() > temp.getProductNumber()){
            x=1;
        }
        else {
            x=-1;
        }

        return x;
    }
}