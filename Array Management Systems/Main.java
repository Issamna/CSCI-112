
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
        //Creates array list to be used and loads data from text file
        CellPhoneArray list = new CellPhoneArray();

        System.out.println("Cell Phone Array Management Program");
        do{
            try{
                input = menu();
                //switch case to call methods or exit
                switch (input){
                    case 1:
                        list.addList();
                        break;
                    case 2:
                        list.removeList();
                        break;
                    case 3:
                        list.updateList();
                        break;
                    case 4:
                        list.showList();
                        break;
                    case 5:
                        quit = 5;
                        break;
                    default:
                        System.out.println("Error: Not a choice. Try again");
                        break;
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Error: Invalid Input");
                System.out.print("Try Again.\n");
                quit = 0;
            }
        }while(quit == 0);
        System.out.println("Thank you for using this program.");
    }
    /**
     * Method to display menu and get a user input
     * @return menu number the user inputted
     * @throws InputMismatchException if input is not an integer
     */
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

}
