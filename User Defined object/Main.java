/**
 * @author Issam Ahmed
 *         CSCI 112 Summer 2019
 */
public class Main {

    public static void main(String[] args) {
        //Product class default constructor and initialization constructor
        Product pencil = new Product();
        Product mouse = new Product(1234, "Mouse", 15);
        //CellPhone class default constructor and initialization constructor
        CellPhone samsungS7 = new CellPhone();
        CellPhone appleXS = new CellPhone(2233,"appleXS", 850.00, "As5ph5", "4B:66:4E:CF:92:C4", 5.8);

        //Set methods being used
        pencil.setProductNumber(1225);
        pencil.setName("Pencil");
        pencil.setPrice(1.5);
        mouse.setPrice(13);


        samsungS7.setProductNumber(9293);
        samsungS7.setName("Samsung S7");
        samsungS7.setPrice(appleXS.getPrice());
        samsungS7.setMacNumber("5B:6E:4E:2F:9C:D4");
        samsungS7.setModel("SM-G877");
        samsungS7.setScreenSize(6.3);

        //toString methods to print all objects created
        System.out.println("Objects created:\n");
        System.out.println(pencil.toString());
        System.out.println(mouse.toString());
        System.out.println(samsungS7.toString());
        System.out.println(appleXS.toString());

        System.out.println("Exiting Program....");

    }
}
