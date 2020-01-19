import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Exception Handling Assignment
 * @author Issam Ahmed
 *         CSCI 112 Summer 2019
 */
public class Main {

    /**
     * Method to create an array with a 100 random integers between 0-100
     * @return array with random integers
     */
    public static int[] createArray() {
        int[] array=new int[100];
        for(int i=0;i<100;i++){
            array[i] = (int)(Math.random() * 100 + 1);
        }
        return array;
    }

    /**
     * Method to get a user input for an index number
     * @return index number the user inputted
     * @throws InputMismatchException if input is not an integer
     */
    public static int userInput()throws InputMismatchException{
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter index number:  ");
        int userInput = scnr.nextInt();
        return userInput;
    }

    /**
     * Method to return array element at the requested/inputted index value
     * @param userValue the user's index input
     * @param array the array to be used
     * @throws ArrayIndexOutOfBoundsException if index value is out of bounds for given array
     */
    public static void returnArrayElement(int userValue, int[] array)throws ArrayIndexOutOfBoundsException{
        int indexValue = array[userValue];
        System.out.print("Array value at index position ");
        System.out.println(userValue+": "+indexValue+"\n");

    }

    /**
     * Main Method
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int[] arr = createArray();
        int input;
        char quit = 'a';
        System.out.println("Random integer array created.");
        System.out.println("Enter an index number to retrieve array value.\n");

        do{
            try {
                input = userInput();
                quit = 'a';
                try{
                    returnArrayElement(input, arr);
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error: "+input+" is out of the array index");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Error: Invalid Input");
                System.out.print("Enter y to retry and anything else to quit: ");
                quit = scnr.next().charAt(0);
            }
        }while(quit == 'y');
        System.out.println("Programing Exiting...");
    }
}