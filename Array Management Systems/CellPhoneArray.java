import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class CellPhoneArray {
    private CellPhone[] List; //store list
    private int maxSize;      //stores max size of list
    private int length= 0;    //stores current number of instances

    //Constructor methods

    /*
    Default constructor
    Post-conditions: List = new CellPhone[20]; - loaded from premade sample instances form text file
                     maxList = 20; length = 5;
    */
    public CellPhoneArray()throws IOException {
        File readFile =new File("src/cellphones.txt");
        Scanner infile = new Scanner(readFile);
        maxSize = 20;
        List = new CellPhone[maxSize];
        for(int i=0;i<5;i++){
            List[i] = new CellPhone(Integer.parseInt(infile.nextLine()),
                    infile.nextLine(),
                    Double.parseDouble(infile.nextLine()),
                    infile.nextLine(),
                    infile.nextLine(),
                    Double.parseDouble(infile.nextLine()));
        }
        infile.close();
        length = 5;
        System.out.println("Array loaded from File....");
    }

    /*Constructor with maxSize Parameter
      CellPhone array initialized with maximum size
      Post-conditions: List = new CellPhone[maxSize];
                     maxList = listSize; length = 0;
     */
    public CellPhoneArray(int listSize){
        this.maxSize = listSize;
        this.List = new CellPhone[maxSize];
    }

    /*Method to show all current instances
     */
    public void showList(){
        if(length<1){
            System.out.println("List is empty. Please add to list first.\n");
        }
        else{

            System.out.println("List of Cell Phones stored: "+length+"      Max Limit: "+maxSize);
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.printf("%5s| %9s | %10s | %5s | %5s", "Index ", "Product #", "Name", "Price ($)", "Other Information");
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------");
            for(int i=0;i<length;i++){
                System.out.printf("%5d | %9d | %10.8s | %9.2f |", (i+1), List[i].getProductNumber(), List[i].getName(), List[i].getPrice());
                System.out.println("  Model: "+List[i].getModel()+" MAC Number: "+List[i].getMacNumber()+" Screen Size: "+List[i].getScreenSize());
            }
            System.out.println("-----------------------------------------------------------------------------------------------------");
        }
    }
    /*Method to add instance to array list
     */
    public void addList(){
        Scanner scnr = new Scanner(System.in);
        if(length>=maxSize){
            System.out.println("Sorry List is full. Max Size: "+maxSize+". Please delete some instances.\n");
        }
        else{
            System.out.print("Enter Product Number: ");
            int productNumber = scnr.nextInt();
            scnr.nextLine();
            System.out.print("Enter Cell Phone Name: ");
            String name = scnr.nextLine();
            System.out.print("Enter Cell Phone Price: ");
            double price = scnr.nextDouble();
            scnr.nextLine();
            System.out.print("Enter Cell Phone Model: ");
            String model = scnr.nextLine();
            System.out.print("Enter Cell Phone MacNumber: ");
            String macNumber = scnr.nextLine();
            System.out.print("Enter Cell Phone Screen Size: ");
            double screenSize = scnr.nextDouble();
            List[length] = new CellPhone(productNumber, name, price, model, macNumber, screenSize);
            length+=1;
        }
    }

    /*Method to remove instance from array list
    */
    public void removeList(){
        Scanner scnr = new Scanner(System.in);
        if(length<1){
            System.out.println("List is empty. Please add to the list first.\n");
        }
        else{
            System.out.print("Enter Index Number to delete (1-"+length+"): ");
            int index = scnr.nextInt()-1;
            if(index>=length||index<0){
                System.out.println("Index does not exist in list.\n");
            }
            else{
                for(int i=index;i<length-1;i++){
                    List[i]=List[i+1];
                }
                length=length -1;
            }
        }
    }
    /*Method to update an instance from array list
     */
    public void updateList(){
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter Index Number to update (1-"+length+"): ");
        int index = scnr.nextInt()-1;
        if(index>=length||index<0){
            System.out.println("Index does not exist in list.\n");
        }
        else{
            System.out.print("Enter new Product Number: ");
            List[index].setProductNumber(scnr.nextInt());
            scnr.nextLine();
            System.out.print("Enter new Cell Phone Name: ");
            List[index].setName(scnr.nextLine());
            System.out.print("Enter new Cell Phone Price: ");
            List[index].setPrice(scnr.nextDouble());
            scnr.nextLine();
            System.out.print("Enter new Cell Phone Model: ");
            List[index].setModel(scnr.nextLine());
            System.out.print("Enter new Cell Phone Mac Number: ");
            List[index].setMacNumber(scnr.nextLine());
            System.out.print("Enter new Cell Phone Screen Size: ");
            List[index].setScreenSize(scnr.nextDouble());
        }
    }
}
