import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.NumberFormat;
/**
 * @author Issam Ahmed
 *         CSCI 112 Summer 2019
 */
public class CellPhoneFrame extends JFrame {

    //Text fields to be used
    private JFormattedTextField  pdNumberField;
    private JTextField  pdNameField;
    private JFormattedTextField   pdPriceField;
    private JTextField  pdMACNumberField;
    private JFormattedTextField   pdScreenSizeField;
    private JTextField  pdModelField;
    private JLabel enterStatus;


    //Frame class
    public CellPhoneFrame(){
            //Labels names
        JLabel title = new JLabel("Enter Cell Phone Products Details:");
        JLabel pdNumber = new JLabel("Product Number:");
        JLabel pdName = new JLabel("Cell Phone Name:");
        JLabel pdPrice = new JLabel("Price:");
        JLabel pdModel = new JLabel("Model:");
        JLabel pdMACNumber = new JLabel("MAC Number:");
        JLabel pdScreenSize = new JLabel("Screen Size:");
        enterStatus = new JLabel("      ");

        //Defining Fields
        pdNumberField = new JFormattedTextField(NumberFormat.getIntegerInstance());
        pdNumberField.setEditable(true);
        pdNumberField.setColumns(15);
        pdNumberField.setToolTipText("Enter Integer value here.");

        pdNameField = new JTextField(15);
        pdNameField.setEditable(true);
        pdNameField.setToolTipText("Enter Cell Phone name here.");

        NumberFormat priceFormat = NumberFormat.getNumberInstance();
        priceFormat.setMinimumFractionDigits(2);
        pdPriceField = new JFormattedTextField(priceFormat);
        pdPriceField.setEditable(true);
        pdPriceField.setColumns(15);
        pdPriceField.setToolTipText("Enter price here. (ex: 39.03)");

        pdMACNumberField = new JTextField(15);
        pdMACNumberField.setEditable(true);
        pdMACNumberField.setToolTipText("Enter MAC Number here. (ex: 00-14-22-01-23-45)");

        pdModelField = new JTextField(15);
        pdModelField.setEditable(true);
        pdModelField.setToolTipText("Enter Model information here.");

        pdScreenSizeField = new JFormattedTextField(NumberFormat.getNumberInstance());
        pdScreenSizeField.setEditable(true);
        pdScreenSizeField.setColumns(15);
        pdScreenSizeField.setToolTipText("Enter screen size here.");

        //Setting frame
        setLayout(new GridBagLayout());
        GridBagConstraints layoutConst = new GridBagConstraints();

        //Title Label Row: 0
        layoutConst.insets = new Insets(30, 30, 10, 10);
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        add(title, layoutConst);

        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        //Product number Label Row: 1
        layoutConst.insets = new Insets(10, 30, 10, 10);
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        add(pdNumber, layoutConst);
        //Product number Field Row: 1
        layoutConst.insets = new Insets(10, 0, 10, 30);
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        add(pdNumberField, layoutConst);

        //Product Name Label Row: 2
        layoutConst.insets = new Insets(10, 30, 10, 10);
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        add(pdName, layoutConst);
        //Product Name Field Row: 2
        layoutConst.insets = new Insets(10, 0, 10, 30);
        layoutConst.gridx = 1;
        layoutConst.gridy = 2;
        add(pdNameField, layoutConst);

        //Product Price Label Row: 3
        layoutConst.insets = new Insets(10, 30, 10, 10);
        layoutConst.gridx = 0;
        layoutConst.gridy = 3;
        add(pdPrice, layoutConst);
        //Product Price Field Row: 3
        layoutConst.insets = new Insets(10, 0, 10, 30);
        layoutConst.gridx = 1;
        layoutConst.gridy = 3;
        add(pdPriceField, layoutConst);

        //Product Model Label Row: 4
        layoutConst.insets = new Insets(10, 30, 10, 10);
        layoutConst.gridx = 0;
        layoutConst.gridy = 4;
        add(pdModel, layoutConst);
        //Product Model Field Row: 4
        layoutConst.insets = new Insets(10, 0, 10, 30);
        layoutConst.gridx = 1;
        layoutConst.gridy = 4;
        add(pdModelField, layoutConst);

        //Product MacNumber Label Row: 5
        layoutConst.insets = new Insets(10, 30, 10, 10);
        layoutConst.gridx = 0;
        layoutConst.gridy = 5;
        add(pdMACNumber, layoutConst);
        //Product MacNumber Field Row: 5
        layoutConst.insets = new Insets(10, 0, 10, 30);
        layoutConst.gridx = 1;
        layoutConst.gridy = 5;
        add(pdMACNumberField, layoutConst);

        //Product Screen Size Label Row: 6
        layoutConst.insets = new Insets(10, 30, 10, 10);
        layoutConst.gridx = 0;
        layoutConst.gridy = 6;
        add(pdScreenSize, layoutConst);
        //Product Screen Size Field Row: 6
        layoutConst.insets = new Insets(10, 0, 10, 30);
        layoutConst.gridx = 1;
        layoutConst.gridy = 6;
        add(pdScreenSizeField, layoutConst);

        layoutConst.insets = new Insets(20, 30, 10, 10);
        layoutConst.gridx = 0;
        layoutConst.gridy = 7;
        add(enterStatus, layoutConst);

        //buttons
        JButton  enterButton = new JButton("Enter");
        enterButton.setToolTipText("Enter Data into file.");
        EnterListener EnterListener = new EnterListener();
        enterButton.addActionListener(EnterListener);

        JButton clearButton = new JButton("Clear");
        clearButton.setToolTipText("Clear fields.");
        ClearListener ClearListener = new ClearListener();
        clearButton.addActionListener(ClearListener);

        layoutConst.fill = GridBagConstraints.NONE;
        //Product Screen Size Label Row: 6
        layoutConst.insets = new Insets(30, 20, 30, 10);
        layoutConst.gridx = 0;
        layoutConst.gridy = 8;
        add(enterButton, layoutConst);
        //Product Screen Size Field Row: 6
        layoutConst.insets = new Insets(30, 0, 30, 30);
        layoutConst.gridx = 1;
        layoutConst.gridy = 8;
        add(clearButton, layoutConst);
    }
    /* Event Listener for the Enter button
       Enters data into a CVS file
     */
    class EnterListener implements ActionListener  {
        public void actionPerformed(ActionEvent a){
            try{
                //Get values from fields
                int productNumber = ((Number) pdNumberField.getValue()).intValue();
                String name = pdNameField.getText();
                double price = ((Number) pdPriceField.getValue()).doubleValue();
                String model = pdModelField.getText();
                String macNumber = pdMACNumberField.getText();
                double screenSize = ((Number) pdScreenSizeField.getValue()).doubleValue();
                //Create Cell Phone object
                CellPhone toEnter = new CellPhone(productNumber,name,price,model,macNumber,screenSize);
                //Print to CSV file
                FileWriter writeFile = new FileWriter("CellPhones.csv",true);
                PrintWriter outfile = new PrintWriter(writeFile);
                outfile.write(toEnter.toString());
                outfile.close();
                //Status update
                System.out.println("Data Entered");
                enterStatus.setText("Data Entered");
            }
            catch (Exception e){
                //Error popup
                JOptionPane.showMessageDialog(null,"Check fields for missing or improper values.","Input Error", JOptionPane.ERROR_MESSAGE);
                enterStatus.setText("Error: Check Input Fields");
            }


        }
    }
    /* Event Listener for the Clear button
       Clears data in fields
    */
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Clearing Fields.");
            enterStatus.setText("Fields Cleared");
            pdNumberField.setValue(null);
            pdNameField.setText("");
            pdPriceField.setText(null);
            pdMACNumberField.setText("");
            pdModelField.setText("");
            pdScreenSizeField.setText(null);

        }
    }

}
