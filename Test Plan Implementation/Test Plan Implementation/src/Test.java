import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

/**
 * @author Issam Ahmed
 *         CSCI 112 Summer 2019
 */
public class Test {
    static File testData;
    static Scanner fileInput;
    static PrintWriter writeout;
    static int failCount = 0;
    public static void main(String[] args)throws Exception{
        System.out.println("testdata.txt file loaded");
        System.out.println("Starting Tests");
        int testCount = 0;
        testData = new File("src/testdata.txt");
        fileInput = new Scanner(testData);
        writeout = new PrintWriter("Test Report.txt");
        writeout.println("--------------------------------------------------------------");
        writeout.println("|       Product Class and CellPhone Class Test Program       |");
        writeout.println("--------------------------------------------------------------");
        writeout.println("***** MOF = Meant to Fail Test *****");
        writeout.println("");
        writeout.println("Constructor Methods Tests");
        writeout.println("");
        inputTest1();
        while(testCount<2){
            inputTest2();
            testCount++;
        }
        while(testCount<4){
            inputTest3();
            testCount++;
        }
        writeout.println("--------------------------------------------------------------");
        writeout.println("Set Methods Tests");
        writeout.println("");
        while (testCount<6){
            inputTest4();
            testCount++;
        }
        while (testCount<8){
            inputTest5();
            testCount++;
        }
        while (testCount<10){
            inputTest6();
            testCount++;
        }
        while (testCount<12){
            inputTest7();
            testCount++;
        }
        while (testCount<14){
            inputTest8();
            testCount++;
        }
        while (testCount<16){
            inputTest9();
            testCount++;
        }
        writeout.println("--------------------------------------------------------------");
        writeout.println("Get Methods Tests");
        writeout.println("");
        while (testCount<18){
            outputTest1();
            testCount++;
        }
        writeout.println("--------------------------------------------------------------");
        writeout.println("compareTo Methods Tests");
        writeout.println("");
        while (testCount<22){
            correctnessTest1();
            testCount++;
        }
        while (testCount<26){
            correctnessTest2();
            testCount++;
        }
        writeout.println("--------------------------------------------------------------");
        writeout.println("equals Methods Tests");
        writeout.println("");
        while (testCount<28){
            correctnessTest3();
            testCount++;
        }
        while (testCount<30){
            correctnessTest4();
            testCount++;
        }
        writeout.println("--------------------------------------------------------------");
        writeout.println("                        End of Report                            ");
        writeout.println("               "+failCount+" Test Fails out of "+(testCount+4)+" Tests");
        writeout.println("--------------------------------------------------------------");
        writeout.close();
        System.out.println("Report Saved - Program Exiting...");
    }
    //Test Evaluator/Printer
    public static void testResult(String test, String expectedVal, String actualVal){
        writeout.println(test+" Test");
        writeout.println("   Expected: "+expectedVal);
        writeout.print("     Actual: ");
        writeout.println(actualVal);
        writeout.print("Test Result: ");
        if(actualVal.contentEquals(expectedVal)){
            writeout.println("Pass");
        }
        else{
            writeout.println("Fail");
            writeout.println("     Reason: Issue in "+test);
            failCount++;
        }
        writeout.println("");
    }
    //default constructor test
    public static void inputTest1(){
        Product testCase1 = new Product();
        Product testCase2 = new Product(1, "testfailure case", 903.0);
        CellPhone testCase3 = new CellPhone();
        CellPhone testCase4 = new CellPhone(1, "testfailure case", 903.0, "s", "s", 1);
        testResult("Product Default Constructor", "0 Unknown Product 0.00", testCase1.toString());
        testResult("Product Default Constructor(MOF)", "0 Unknown Product 0.00   0.0", testCase2.toString());
        testResult("CellPhone Default Constructor", "0 Unknown Product 0.00   0.0", testCase3.toString());
        testResult("CellPhone Default Constructor(MOF)", "0 Unknown Product 0.00   0.0", testCase4.toString());
    }
    //Product Class Initialization Test Driver
    public static void inputTest2(){
        String dataInput = fileInput.nextLine();
        String[] parts = dataInput.split(";");
        String failCondition = "";
        if(parts.length > 4 && parts[4] != null){
            failCondition = parts[4];
        }
        Product testCase = new Product(Integer.parseInt(parts[1]), parts[2], Double.parseDouble(parts[3]));
        String expectedValue = parts[1]+" "+ parts[2]+" "+String.format("%.2f", Double.parseDouble(parts[3]))+failCondition;
        testResult(parts[0], expectedValue, testCase.toString());
    }
    //CellPhone Class Initialization Test Driver
    public static void inputTest3(){
        String dataInput = fileInput.nextLine();
        String[] parts = dataInput.split(";");
        String failCondition = "";
        if(parts.length > 7 && parts[7] != null){
            failCondition = parts[7];
        }
        CellPhone testCase = new CellPhone(Integer.parseInt(parts[1]), parts[2], Double.parseDouble(parts[3]),
                parts[4], parts[5], Double.parseDouble(parts[6]));
        String expectedValue = parts[1]+" "+parts[2]+" "+String.format("%.2f", Double.parseDouble(parts[3]))+" "
                +parts[4]+" "+parts[5]+" "+Double.parseDouble(parts[6])+failCondition;
        testResult(parts[0], expectedValue, testCase.toString());
    }
    //setProduct() Test Driver
    public static void inputTest4(){
        String dataInput = fileInput.nextLine();
        String[] parts = dataInput.split(";");
        String failCondition = "";
        if(parts.length > 8 && parts[8] != null)
        {
            failCondition = parts[8];
        }
        CellPhone orginalCase = new CellPhone(Integer.parseInt(parts[1]), parts[2], Double.parseDouble(parts[3]), parts[4], parts[5], Double.parseDouble(parts[6]));
        String expectedVal = parts[7]+" "+parts[2]+" "+String.format("%.2f", Double.parseDouble(parts[3]))+" "+parts[4]+" "+parts[5]+" "+Double.parseDouble(parts[6])+failCondition;
        orginalCase.setProductNumber(Integer.parseInt(parts[7]));
        testResult(parts[0], expectedVal, orginalCase.toString());
    }
    //setName() Test Driver
    public static void inputTest5(){
        String dataInput = fileInput.nextLine();
        String[] parts = dataInput.split(";");
        String failCondition = "";
        if(parts.length > 8 && parts[8] != null)
        {
            failCondition = parts[8];
        }
        CellPhone orginalCase = new CellPhone(Integer.parseInt(parts[1]), parts[2], Double.parseDouble(parts[3]), parts[4], parts[5], Double.parseDouble(parts[6]));
        String expectedVal = parts[1]+" "+parts[7]+" "+String.format("%.2f", Double.parseDouble(parts[3]))+" "+parts[4]+" "+parts[5]+" "+Double.parseDouble(parts[6])+failCondition;
        orginalCase.setName(parts[7]);
        testResult(parts[0], expectedVal, orginalCase.toString());
    }
    //setPrice() Test Driver
    public static void inputTest6(){
        String dataInput = fileInput.nextLine();
        String[] parts = dataInput.split(";");
        String failCondition = "";
        if(parts.length > 8 && parts[8] != null)
        {
            failCondition = parts[8];
        }
        CellPhone orginalCase = new CellPhone(Integer.parseInt(parts[1]), parts[2], Double.parseDouble(parts[3]), parts[4], parts[5], Double.parseDouble(parts[6]));
        String expectedVal = parts[1]+" "+parts[2]+" "+String.format("%.2f", Double.parseDouble(parts[7]))+" "+parts[4]+" "+parts[5]+" "+Double.parseDouble(parts[6])+failCondition;
        orginalCase.setPrice(Double.parseDouble(parts[7]));
        testResult(parts[0], expectedVal, orginalCase.toString());
    }
    //setModel() Test Driver
    public static void inputTest7(){
        String dataInput = fileInput.nextLine();
        String[] parts = dataInput.split(";");
        String failCondition = "";
        if(parts.length > 8 && parts[8] != null)
        {
            failCondition = parts[8];
        }
        CellPhone orginalCase = new CellPhone(Integer.parseInt(parts[1]), parts[2], Double.parseDouble(parts[3]), parts[4], parts[5], Double.parseDouble(parts[6]));
        String expectedVal = parts[1]+" "+parts[2]+" "+String.format("%.2f", Double.parseDouble(parts[3]))+" "+parts[7]+" "+parts[5]+" "+Double.parseDouble(parts[6])+failCondition;
        orginalCase.setModel(parts[7]);
        testResult(parts[0], expectedVal, orginalCase.toString());
    }
    //setMacNumber() Test Driver
    public static void inputTest8(){
        String dataInput = fileInput.nextLine();
        String[] parts = dataInput.split(";");
        String failCondition = "";
        if(parts.length > 8 && parts[8] != null)
        {
            failCondition = parts[8];
        }
        CellPhone orginalCase = new CellPhone(Integer.parseInt(parts[1]), parts[2], Double.parseDouble(parts[3]), parts[4], parts[5], Double.parseDouble(parts[6]));
        String expectedVal = parts[1]+" "+parts[2]+" "+String.format("%.2f", Double.parseDouble(parts[3]))+" "+parts[4]+" "+parts[7]+" "+Double.parseDouble(parts[6])+failCondition;
        orginalCase.setMacNumber(parts[7]);
        testResult(parts[0], expectedVal, orginalCase.toString());
    }
    //setScreenSize() Test Driver
    public static void inputTest9(){
        String dataInput = fileInput.nextLine();
        String[] parts = dataInput.split(";");
        String failCondition = "";
        if(parts.length > 8 && parts[8] != null)
        {
            failCondition = parts[8];
        }
        CellPhone orginalCase = new CellPhone(Integer.parseInt(parts[1]), parts[2], Double.parseDouble(parts[3]), parts[4], parts[5], Double.parseDouble(parts[6]));
        String expectedVal = parts[1]+" "+parts[2]+" "+String.format("%.2f", Double.parseDouble(parts[3]))+" "+parts[4]+" "+parts[5]+" "+Double.parseDouble(parts[7])+failCondition;
        orginalCase.setScreenSize(Double.parseDouble(parts[7]));
        testResult(parts[0], expectedVal, orginalCase.toString());
    }
    //get method Test Driver
    public static void outputTest1(){
        String dataInput = fileInput.nextLine();
        String[] parts = dataInput.split(";");
        String failCondition = "";
        if(parts.length > 7 && parts[7] != null)
        {
            failCondition = parts[7];
        }
        CellPhone orginalCase = new CellPhone(Integer.parseInt(parts[1]), parts[2], Double.parseDouble(parts[3]), parts[4], parts[5], Double.parseDouble(parts[6]));
        testResult("getProduct() Method", parts[1]+failCondition, (""+orginalCase.getProductNumber()));
        testResult("getName() Method", parts[2]+failCondition, (""+orginalCase.getName()));
        testResult("getPrice() Method", parts[3]+failCondition, (""+orginalCase.getPrice()));
        testResult("getModel() Method", parts[4]+failCondition, (""+orginalCase.getModel()));
        testResult("getMacNumber() Method", parts[5]+failCondition, (""+orginalCase.getMacNumber()));
        testResult("getScreenSize() Method", Double.parseDouble(parts[6])+failCondition, (""+orginalCase.getScreenSize()));
    }
    //Product class compareTo() Test Driver
    public static void correctnessTest1(){
        String dataInput = fileInput.nextLine();
        String[] parts = dataInput.split(";");
        String failCondition = "";
        if(parts.length > 4 && parts[4] != null)
        {
            failCondition = parts[4];
        }
        Product test1 = new Product(Integer.parseInt(parts[1]), "Test", 10.0);
        Product test2 = new Product(Integer.parseInt(parts[2]), "Test", 10.0);
        testResult(parts[0],parts[3],test1.compareTo(test2)+"");
    }
    //CellPhone class compareTo() Test Driver
    public static void correctnessTest2(){
        String dataInput = fileInput.nextLine();
        String[] parts = dataInput.split(";");
        String failCondition = "";
        if(parts.length > 4 && parts[4] != null)
        {
            failCondition = parts[4];
        }
        CellPhone test1 = new CellPhone(1, "Test", 10.0, parts[1],"Test",0.0);
        CellPhone test2 = new CellPhone(2, "Test", 10.0, parts[2],"Test",0.0);
        testResult(parts[0],parts[3],test1.compareTo(test2)+"");
    }
    //Product class equals() Test Driver
    public static void correctnessTest3(){
        String dataInput = fileInput.nextLine();
        String[] parts = dataInput.split(";");
        String failCondition = "";
        Product test1 = new Product(Integer.parseInt(parts[1]),parts[2],Double.parseDouble(parts[3]));
        Product test2 = new Product(Integer.parseInt(parts[4]),parts[5],Double.parseDouble(parts[6]));
        testResult(parts[0],parts[7],test1.equals(test2)+"");
    }
    //CellPhone class equals() Test Driver
    public static void correctnessTest4(){
        String dataInput = fileInput.nextLine();
        String[] parts = dataInput.split(";");
        CellPhone test1 = new CellPhone(Integer.parseInt(parts[1]),parts[2],Double.parseDouble(parts[3]),parts[4],parts[5],Double.parseDouble(parts[6]));
        CellPhone test2 = new CellPhone(Integer.parseInt(parts[7]),parts[8],Double.parseDouble(parts[9]),parts[10],parts[11],Double.parseDouble(parts[12]));
        testResult(parts[0],parts[13],test1.equals(test2)+"");
    }
}
