import java.io.File;
import java.util.Scanner;
/**
 * @author Issam Ahmed
 *         CSCI 112 Summer 2019
 */
public class Main {

    public static void main(String[] args)throws Exception {
        System.out.println("\nSort Methods Program");
        System.out.println("*********************");
        System.out.println("\nStarting Selection Sort");
        selectionSort();  //Selection sort method
        System.out.println("\nStarting Insertion Sort");
        insertionSort();  //Insertion sort method
        System.out.println("\nEnd of Program");
        System.out.println("*********************");
    }
    /**
     *Method to run an ascending selection sort on data from Tutorials.txt
     *Outputs a csv file (SelectionSortMethod.csv)
     */
    public static void selectionSort()throws Exception{
        System.out.println("-Load data from Tutorials.txt file");

        //Load data file from Tutorials.txt
        File readFile =new File("src/Tutorials.txt");
        Scanner infile = new Scanner(readFile);
        int i;
        TutorialWebsite[] list = new TutorialWebsite[20]; //Object Array to be used
        for(i=0;i<20;i++){
            list[i] = new TutorialWebsite(infile.nextLine(),infile.nextLine(),infile.nextLine());
        }
        //end of load

        System.out.println("-Selection Sort Method on data");

        //start of sort
        int index; //smallest in pass
        TutorialWebsite temp;  //temp for swap
        for (i = 0; i < list.length - 1; ++i) {
            index = i;
            for (int j = i + 1; j < list.length; ++j) {
                if (list[j].compareTo(list[index]) < 0) {
                    index = j;
                }
            }
            //swap data
            temp = list[i];
            list[i] = list[index];
            list[index] = temp;
        }
        //end of sort

        System.out.println("-Exporting data");

        //start of output
        java.io.File empCSV = new java.io.File("SelectionSortMethod.csv");
        java.io.PrintWriter outfile = new java.io.PrintWriter(empCSV);
        for(i=0;i<list.length;i++){
            outfile.write(list[i].toString());
        }
        outfile.close();
        System.out.println("-Data saved to SelectionSortMethod.csv");
        //end of output

    }

    /**
     *Method to run an descending insertion sort on data from Tutorials.txt
     *Outputs a csv file (InsertionSortMethod.csv)
     */
    public static void insertionSort()throws Exception{
        System.out.println("-Load data from Tutorials.txt file");

        //Load data file from Tutorials.txt
        File readFile =new File("src/Tutorials.txt");
        Scanner infile = new Scanner(readFile);
        int i;
        TutorialWebsite[] list = new TutorialWebsite[20]; //Object Array to be used
        for(i=0;i<20;i++){
            list[i] = new TutorialWebsite(infile.nextLine(),infile.nextLine(),infile.nextLine());
        }
        //end of load

        System.out.println("-Insertion Sort Method on data");

        //start of sort
        TutorialWebsite temp; //temp for swap
        int j;
        for (i = 1; i < list.length; ++i) {
            j = i;
            while (j > 0 && list[j].compareTo(list[j-1])>0) {
                temp = list[j];
                list[j] = list[j - 1];
                list[j - 1] = temp;
                j--;
            }
        }
        //end of sort

        System.out.println("-Exporting data");

        //start of output
        java.io.File empCSV = new java.io.File("InsertionSortMethod.csv");
        java.io.PrintWriter outfile = new java.io.PrintWriter(empCSV);
        for(i=0;i<list.length;i++){
            outfile.write(list[i].toString());
        }
        outfile.close();
        System.out.println("-Data saved to InsertionSortMethod.csv");
        //end of output

    }

}
