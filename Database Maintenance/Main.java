import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @author Issam Ahmed
 *         CSCI 112 Summer 2019
 */
public class Main {

    public static void main(String[] args)throws Exception {
        int input;
        int quit = 0;
        // Connect to a database by  establishing a Connection object
        // Connects to localhost. Need to be edited to connected another database
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/csci112", "root", "root");
        System.out.println("Database connection established.\n");
        // Create a statement Object for this  database connection
        Statement st = conn.createStatement();
        //User menu
        System.out.println("\nStudent Database Maintenance Program");
        do{
            try{
                input = menu();
                //switch case to call methods or exit
                switch (input){
                    case 1:
                        addInstance(st);
                        break;
                    case 2:
                        removeInstance(st);
                        break;
                    case 3:
                        updateInstance(st);
                        break;
                    case 4:
                        displayAll(st);
                        break;
                    case 5:
                        quit = 5;
                        break;
                    default:
                        System.out.println("Error: Not a choice. Try again");
                        break;
                }
            }
            catch(Exception e) {
                System.out.println("Error: Invalid Input");
                System.out.print("Try Again.\n");
                quit = 0;
            }
        }while(quit == 0);
        conn.close();
        System.out.println("Thank you for using this program.");
    }
    //Method to display menu and get a user input
    public static int menu()throws InputMismatchException {
        Scanner scnr = new Scanner(System.in);
        System.out.println("\nChoose from menu options (1-5)");
        System.out.println("1 - Add Instance");
        System.out.println("2 - Remove Instance");
        System.out.println("3 - Update Instance");
        System.out.println("4 - List all Instances");
        System.out.println("5 - Exit Program");
        System.out.print("INPUT: ");
        int in = scnr.nextInt();
        return in;
    }
    //Method that adds instances into data table
    public static void addInstance(Statement s)throws SQLException, ClassNotFoundException{
        Scanner scnr = new Scanner(System.in);
        String queryString;     // a String to hold an SQL query
        //Get data form user
        System.out.println("Enter Student's ID#: ");
        String snum = scnr.nextLine();
        System.out.println("Enter Student's Last Name: ");
        String lastName = scnr.nextLine();
        System.out.println("Enter Student's First Name: ");
        String firstName = scnr.nextLine();
        System.out.println("Enter Street Address: ");
        String street = scnr.nextLine();
        System.out.println("Enter City:");
        String city = scnr.nextLine();
        System.out.println("Enter State:");
        String state = scnr.nextLine();
        System.out.println("Enter ZIP:");
        String zip = scnr.nextLine();
        System.out.println("Enter Student's Phone Number:");
        String phone = scnr.nextLine();
        System.out.println("Enter Student's Major:");
        String major = scnr.nextLine();
        System.out.println("Enter Student's GPA:");
        double gpa = scnr.nextDouble();
        //create queryString
        queryString = "INSERT INTO `student` VALUES ('"+snum+"', '"+lastName+"', '"+firstName+"', '"+street+"', '"+city+"', '"+state+"', '"+zip+"', '"+phone+"', '"+major+"', '"+gpa+"');";

        s.executeUpdate(queryString);
        System.out.println("\nStudent ID Number "+snum+" added.");
    }
    //Method that removes by ID# in data table
    public static void removeInstance(Statement s)throws SQLException, ClassNotFoundException{
        Scanner scnr = new Scanner(System.in);
        String queryString;     // a String to hold an SQL query
        System.out.println("Enter Student's ID number to remove instance: ");
        String snum = scnr.nextLine();
        queryString = "DELETE FROM `student` WHERE snum='"+snum+"';"; //create queryString
        s.executeUpdate(queryString);
        System.out.println("\nStudent ID Number "+snum+" removed.");




    }
    //Method that updates an instances in data table according to ID#
    public static void updateInstance(Statement s)throws SQLException, ClassNotFoundException{

        Scanner scnr = new Scanner(System.in);
        String queryString;     // a String to hold an SQL query

        //get data from user
        System.out.println("Enter Student's ID# to Update: ");
        String snum = scnr.nextLine();
        System.out.println("Enter Student's Last Name: ");
        String lastName = scnr.nextLine();
        System.out.println("Enter Student's First Name: ");
        String firstName = scnr.nextLine();
        System.out.println("Enter Street Address: ");
        String street = scnr.nextLine();
        System.out.println("Enter City:");
        String city = scnr.nextLine();
        System.out.println("Enter State:");
        String state = scnr.nextLine();
        System.out.println("Enter ZIP:");
        String zip = scnr.nextLine();
        System.out.println("Enter Student's Phone Number:");
        String phone = scnr.nextLine();
        System.out.println("Enter Student's Major:");
        String major = scnr.nextLine();
        System.out.println("Enter Student's GPA:");
        double gpa = scnr.nextDouble();
        //create queryString
        queryString = "UPDATE `student`"+
                " SET lastName='"+lastName+"', firstName='"+firstName+"', street='"+street+"', city='"+city+"', state='"+state+"', zip='"+zip+"', phone='"+phone+"', major='"+major+"', gpa='"+gpa+"' WHERE snum='"+snum+"';";
        s.executeUpdate(queryString);
        System.out.println("\nStudent ID Number "+snum+" updated.");

    }
    //Method that displays all instances in data table
    public static void displayAll(Statement s)throws SQLException, ClassNotFoundException{

        String queryString;     // a String to hold an SQL query
        ResultSet rs;           // the result set from an SQL query as a table
        // This sample query returns all of the data in the student table.
        queryString = "SELECT * FROM student";
        // Send a statement executing the query and saving the result set
        rs = s.executeQuery(queryString);
        // print headings for the output
        System.out.println("\n************************************************************************************************************************");
        System.out.printf("%-8s|%-10s|%-10s|%-20s|%-15s|%-6s|%-6s|%-12s|%-17s|%-6s|%n","Snum","Last", "First", "Street", "City", "State", "ZIP", "Phone", "Major", "GPA" );
        System.out.println("************************************************************************************************************************");
        // Iterate through the result set and print name, owner, and species attributes
        while (rs.next())
            System.out.printf("%-8s|%-10s|%-10s|%-20s|%-15s|%-6s|%-6s|%-12s|%-17s|%-6s|%n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDouble(10));

        System.out.println("************************************************************************************************************************");

    }
}
