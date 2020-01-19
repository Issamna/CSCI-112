import javax.swing.*;
/**
 * @author Issam Ahmed
 *         CSCI 112 Summer 2019
 */
public class Main {

    public static void main(String[] args)throws Exception {
        //Call Frame
        CellPhoneFrame myFrame = new CellPhoneFrame();
        //Set Frame Properties
        myFrame.setTitle("Cell Phone Inventory");
        myFrame.setLocation(200, 100);
        myFrame.pack();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }
}
