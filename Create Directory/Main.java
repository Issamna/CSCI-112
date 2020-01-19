import java.io.*;
import java.util.Scanner;
/**
 * Create Directory Assignment
 * @author Issam Ahmed
 *         CSCI 112 Summer 2019
 *
 * Edited from: CreateDirectoriesDemo.java
 *              CSCI 112 - Spring 2014
 *              C. Herbert
 */

public class Main {
    static Scanner scnr;
    public static void main(String[] args) {

        scnr = new Scanner(System.in);
        String location = "";
        // Ask for current directory
        System.out.println("Please enter the location for the new directory (example = c:)");
        System.out.print(location);
        location = location+ scnr.nextLine();
        String newDirectory = "";
        char quit = 'a';

        //check if directory exists
        File file = new File(location);
        if(file.exists()) {
            //if directory exists prompts user for new directory name
            do {
                System.out.println("Current Directory location "+location + "/");
                System.out.println("Please enter new directory name: ");

                newDirectory = scnr.nextLine();
                location = location + "/" + newDirectory;
                //makes new directory
                new File(location).mkdir();
                //asks user if they want to add new directory to path
                System.out.println("Add another directory to path? y to enter new directory: ");
                quit = scnr.next().charAt(0);
                scnr.nextLine();
            } while (quit == 'y');
            //exit loop
            System.out.print("New Directory location: ");
            System.out.println(location);
        }
        else {//if directory does not exist
            System.out.println("Directory does not exist");
        }
        System.out.println("Program Exiting....");
    }



}
