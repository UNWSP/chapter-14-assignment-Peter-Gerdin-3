//  Peter Gerdin, Nov 9 2022
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ButtonGroup;
public class JVacationRental extends JFrame {

    final String PARKSIDE = "600";
    final String POOLSIDE = "750";
    final String LAKESIDE = "825";

    final String ONEBED = "0";
    final String TWOBED = "75";
    final String THREEBED = "150";
    final String MEALSPRICE = "200";

    int totalPrice = 0;

    JPanel fiC = new JPanel(new BorderLayout(0, 5));
    JPanel seC = new JPanel(new BorderLayout());
    JPanel thC = new JPanel(new BorderLayout());
    JPanel foC = new JPanel(new BorderLayout());

    ButtonGroup LocationGroup = new ButtonGroup();
    JRadioButton parksideRB = new JRadioButton("Parkside $" + PARKSIDE, true);
    JRadioButton poolsideRB = new JRadioButton("Poolside $" + POOLSIDE, false);
    JRadioButton lakesideRB = new JRadioButton("Lakeside $" + LAKESIDE, false);

    ButtonGroup bedroomGroup = new ButtonGroup();
    JRadioButton oneBed = new JRadioButton("One bedroom $" + ONEBED, true);
    JRadioButton twoBed = new JRadioButton("Two bedroom $" + TWOBED, false);
    JRadioButton threeBed = new JRadioButton("Three bedroom $" + THREEBED, false);

    ButtonGroup foodGroup = new ButtonGroup();
    JRadioButton noFood = new JRadioButton("No meals $0", true);
    JRadioButton Food = new JRadioButton("Meals included $" + MEALSPRICE, false);

    JLabel directionLabel = new JLabel("\t\tChoose between the options for your room");

    JButton calculateBTN = new JButton("Calculate");

    public JVacationRental() {
        super("Vacation Price Estimator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 20));
        //setBackground(new Color(70, 60, 150));

        LocationGroup.add(parksideRB);
        LocationGroup.add(poolsideRB);
        LocationGroup.add(lakesideRB);
        bedroomGroup.add(oneBed);
        bedroomGroup.add(twoBed);
        bedroomGroup.add(threeBed);
        foodGroup.add(noFood);
        foodGroup.add(Food);
        parksideRB.setActionCommand(PARKSIDE);
        poolsideRB.setActionCommand(POOLSIDE);
        lakesideRB.setActionCommand(LAKESIDE);
        oneBed.setActionCommand(ONEBED);
        twoBed.setActionCommand(TWOBED);
        threeBed.setActionCommand(THREEBED);
        noFood.setActionCommand("0");
        Food.setActionCommand(MEALSPRICE);

        fiC.add(parksideRB, BorderLayout.BEFORE_FIRST_LINE);
        fiC.add(poolsideRB, BorderLayout.CENTER);
        fiC.add(lakesideRB, BorderLayout.AFTER_LAST_LINE);
        seC.add(oneBed, BorderLayout.BEFORE_FIRST_LINE);
        seC.add(twoBed, BorderLayout.CENTER);
        seC.add(threeBed, BorderLayout.AFTER_LAST_LINE);
        thC.add(noFood, BorderLayout.BEFORE_FIRST_LINE);
        thC.add(Food, BorderLayout.CENTER);
        foC.add(calculateBTN);

        this.add(directionLabel, BorderLayout.PAGE_START);
        this.add(fiC, BorderLayout.BEFORE_LINE_BEGINS);
        this.add(seC, BorderLayout.CENTER);
        this.add(thC, BorderLayout.AFTER_LINE_ENDS);
        this.add(foC, BorderLayout.PAGE_END);

        calculateBTN.addActionListener(e -> selectionButtonPressed());



        //this.add(parksideRB);
        //this.add(poolsideRB);
        //this.add(lakesideRB);
        //this.add(oneBed);
        //this.add(twoBed);
        //this.add(lakesideRB);
        //this.add(oneBed);
        //this.add(twoBed);
        //this.add(threeBed);
        //this.add(noFood);
        //this.add(Food);

        //this.add(calculateBTN);
    }

    public void selectionButtonPressed() {
        int selection1 = Integer.parseInt(this.LocationGroup.getSelection().getActionCommand());
        int selection2 = Integer.parseInt(this.bedroomGroup.getSelection().getActionCommand());
        int selection3 = Integer.parseInt(this.foodGroup.getSelection().getActionCommand());
        totalPrice = selection3 + selection2 + selection1;
        JOptionPane.showMessageDialog(null, "Total Price for these options: \n $"+totalPrice);
    }



    public static void main(String[] args)
    {
        JVacationRental aFrame = new JVacationRental();
        final int WIDTH = 500;
        final int HEIGHT = 200;
        aFrame.setBounds(500, 300, WIDTH, HEIGHT);
        aFrame.setVisible(true);


    }
}
