import java.util.Scanner;
/**
 * @author Issam Ahmed
 *         CSCI 112 Summer 2019
 *
 *         mergeSort() methods created by C. Herbet from Into to CS textbook
 *         quickSort() methods created by C. Herbet from Into to CS textbook
 */


public class Main {

    public static void main(String[] args)throws Exception {
        System.out.println("Recursive Sorting Test");
        String input;
        int quit = 0;
        Scanner scnr = new Scanner(System.in);
        do{
            System.out.println("\nWhich test?");
            System.out.println("Reminder: Running a test will erase data in previous CSV file");
            System.out.println("1) Quick Sort method test");
            System.out.println("2) Merge Sort method test");
            System.out.println("3) Exit");
            System.out.print("INPUT: ");
            input = scnr.nextLine();
            //switch case to call methods or exit
            switch (input){
                case "1":
                    System.out.println("Running QuickSort():\n");
                    quickProgram();
                    break;
                case "2":
                    System.out.println("Running MergeSort():\n");
                    mergeProgram();
                    break;
                case "3":
                    quit = 5;
                    break;
                default:
                    System.out.println("Error: Not a choice. Try again");
                    break;
            }
        } while(quit == 0);

        System.out.println("\nExiting test program");
    }

    /**Merge sort main method
     * runs mergeSort() 100 times with 10million random 6 digit integers.
     * Returns compute time and exports to csv file. CSV is rewritten everytime this method is run
    **/
    public static void mergeProgram()throws Exception{
        java.io.File testData1 = new java.io.File("Mergesort.csv");
        java.io.PrintWriter outfile = new java.io.PrintWriter(testData1);
        for (int k = 1; k<= 100; k++)
        {
            int size = 10000000;
            int[] a = new int[size];
            int[] temp = new int[a.length];  // empty temporary array, the same size and type as a[]
            // fill the array with random integers
            for (int i = 0; i< a.length; i++) {
                a[i] = (int) (Math.random() * 100000 + 1);
            }
            // get the start time in nanoseconds
            long startTime = System.nanoTime();
            //call mergesort to sort the entire array
            mergeSort(a, temp, 0, (a.length - 1));
            // get the end time in nanoseconds
            long endTime = System.nanoTime();
            // calculate elapsed time in nanoseconds
            long duration = endTime - startTime;
            // print the elapsed time in seconds   (nanaoseconds/ 1 billion)
            System.out.printf("%12.8f %n", (double)duration/1000000000) ;
            outfile.write((double)duration/1000000000+"\n");
        }
        outfile.close();
    }


    /**mergeSort() recursive sort method
     * taken from example code in Introduction to Computer Science with Java by C. Herbert.
     **/
    public static void mergeSort(int[] a, int[] temp, int low, int high) {
        //  low is the low index of the part of the array to be sorted
        //  high is the high index of the part of the array to be sorted

        int mid;  // the middle of the array – last item in low half

        // if high > low then there is more than one item in the list to be sorted
        if (high > low) {

            // split into two halves and mergeSort each part

            // find middle (last element in low half)
            mid = (low+high)/2;
            mergeSort(a, temp, low, mid );
            mergeSort(a, temp, mid+1, high);

            // merge the two halves back together, sorting while merging
            merge(a, temp, low, mid, high);
        } // end if

        return;
    }// end mergerSort()
    /**merge()
     * taken from example code in Introduction to Computer Science with Java by C. Herbert.
     **/
    public static void merge(int[] a, int[] temp, int low, int mid, int high) {
        //  low is the low index of the part of the array to be sorted
        //  high is the high index of the part of the array to be sorted
        //  mid is the middle of the array – last item in low half

        // copy the two sets from a[] to the same locations in the temporary array
        for (int i = low; i <= high; i++) {
            temp[i] = a[i];
        }

        //set up necessary pointers
        int lowP = low;         // pointer to current item in low half
        int highP = mid + 1;    // pointer to current item in high half
        int aP = low;           // pointer to where each item will be put back in a[]

        // while the pointers have not yet reached the end of either half)
        while ((lowP <= mid) && (highP <= high)) {

            // if current item in low half <= current item in high half
            if (temp[lowP] <= temp[highP]) {
                // move item at lowP back to array a and increment low pointer
                a[aP] = temp[lowP];
                lowP++;
            } else {
                // move item at highP back to array a and increment high pointer
                a[aP] = temp[highP];
                highP++;
            } // end if..else

            // increment pointer for location in original array
            aP++;
        } // end while

        /* When the while loop is done, either the low half or the high half is done
         * We now simply move back everything in the half not yet done.
         * Remember, each half is already in order itself.
         */
        // if lowP has reached end of low half, then low half is done, move rest of high half
        if (lowP > mid)
            for (int i = highP; i <= high; i++) {
                a[aP] = temp[i];
                aP++;
            } // end for
        else // high half is done, move rest of low half

            for (int i = lowP; i <= mid; i++) {
                a[aP] = temp[i];
                aP++;
            }// end for

        return;
    } // end merge()

    /**Quick Sort main method
     * runs quickSort() 100 times with 10million random 6 digit integers.
     * Returns compute time and exports to csv file. CSV is rewritten everytime this method is run
     **/
    public static void quickProgram()throws Exception{
        java.io.File testData = new java.io.File("Quicksort.csv");
        java.io.PrintWriter outfile = new java.io.PrintWriter(testData);
        for (int k = 1; k<= 100; k++)
        {
            int size = 10000000;
            int[] a = new int[size];
            // fill the array with random integers
            for (int i = 0; i< a.length; i++) {
                a[i] = (int) (Math.random() * 100000 + 1);
            }
            // get the start time in nanoseconds
            long startTime = System.nanoTime();
            //call quicksort to sort the entire array
            quickSort(a, 0, a.length - 1);
            // get the end time in nanoseconds
            long endTime = System.nanoTime();
            // calculate elapsed time in nanoseconds
            long duration = endTime - startTime;
            // print the elapsed time in seconds   (nanaoseconds/ 1 billion)
            System.out.printf("%12.8f %n", (double)duration/1000000000) ;
            outfile.write((double)duration/1000000000+"\n");
        }

        outfile.close();

    }
    /**quickSort() recursive sort method
     * taken from example code in Introduction to Computer Science with Java by C. Herbert.
     **/
    public static void quickSort(int[] a, int startIndex, int endIndex){
        int pivotIndex; // the index of pivot returned by the quicksort partition
        // if the set has more than one element, then partition
        if (startIndex < endIndex) {
            // partition and return the pivotIndex
            pivotIndex = partition(a, startIndex, endIndex);
            // quicksort the low set
            quickSort(a, startIndex, pivotIndex - 1);
            // quiclsort the high set
            quickSort(a, pivotIndex + 1, endIndex);
        } // end if
    } // end quickSort()
    /**partition()
     * This method performs quicksort partitioning on a set of elements in an array.
     * taken from example code in Introduction to Computer Science with Java by C. Herbert.
     **/
    public static int partition(int[] a, int startIndex, int endIndex) {
        int pivotIndex; // the index of the chosen pivot element
        int pivot; // the value of the chosen pivot
        int midIndex = startIndex; // boundary element between high and low sets
        // select the center element in the set as the pivot by integer averaging
        pivotIndex = (startIndex + endIndex) / 2;
        pivot = a[pivotIndex];
        // put the pivot at the end of the set so it is out of the way
        swap(a, pivotIndex, endIndex);
        // iterate the set, up to but not including last element
        for (int i = startIndex; i < endIndex; i++) {
            // if a[i] is less than the pivot
            if (a[i] < pivot) {
                // put a[i] in the low half and increment current Index
                swap(a, i, midIndex);
                midIndex = midIndex + 1;
            } // end if
        } // end for
        // partitioning complete -- move pivot from end to middle
        swap(a, midIndex, endIndex);
        // return index of pivot
        return midIndex;
    } // end partition
    /**swap()
     * This method swaps two elements in an integer array
     * Taken from example code in Introduction to Computer Science with Java by C. Herbert.
     **/
    public static void swap(int[] a, int first, int second) {
        int c; // a catalyst variable used for the swap
        c = a[first];
        a[first] = a[second];
        a[second] = c;
    } // end Swap()
//end of program
}
