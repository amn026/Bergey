/**
 * Name: Albert Minh Tri Nguyen
 * Date: 9/30/2016
 * Dilution calculator for lab work
 */
package io.isawesome.albert.dilution;

import java.util.Scanner;

/**
 * @author Albert Minh Tri Nguyen
 * @version 1.0
 * @date 9/30/2016
 */
public class Dilution {
    private double c1;
    private double v1;
    private double c2;
    private double v2;

    private double dilutionFactor;

    private String output;

    /**
     * No-arg constructor for Dilution
     */
    public Dilution() {

    }//End of no-arg constructor

    /**
     * Four-arg constructor for Dilution
     */
    public Dilution(double c1, double v1, double c2, double v2, double DF) {
        setC1(c1);
        setV1(v1);
        setC2(c2);
        setV2(v2);
        setDF(DF);
    }

    /**
     * Accessor to get Concentration of Stock Solution
     * @return Concentration of stock
     */
    public double getC1() {
        return this.c1;
    }

    /**
     * Mutator for Concentration of Stock Solution
     * @param c Concentration of stock solution
     */
    public void setC1(double c) {
        this.c1 = c;
    }

    /**
     * Accessor for volume of stock solution required
     * @return volume of stock needed
     */
    public double getV1() {
        return this.v1;
    }
   
    /**
     * Mutator for volume of stock needed.
     * @param v Volume of stock needed
     */
    public void setV1(double v) {
        this.v1 = v;
    }

    /**
     * Accessor for Concentration of Diluted Solution
     * @return Concentration of diluted solution
     */
    public double getC2() {
        return this.c2;
    }

    /**
     * Mutator for Concentration of Diluted Solution
     * @param c Concentration of diluted solution
     */
    public void setC2(double c) {
        this.c2 = c;
    }

    /**
     * Accessor for the Volume of Diluted Solution
     * @return Volume of diluted solution
     */
    public double getV2() {
        return this.v2;
    }

    /**
     * Mutator for Volume of Diluted Solution
     * @param v Volume of diluted solution
     */
    public void setV2(double v) {
        this.v2 = v;
    }

    /**
     * Method setOutput sets the output message.
     * @param string The new output message.
     */
    public void setOutput(String string) {
        this.output = string;
    }

    /**
     * Method getOutput will return the output message.
     * @return
     */
    public String getOutput() {
        return this.output;
    }

    /**
     * Method setDF will set the dilution factor.
     * @param df The new dilution factor
     */
    public void setDF(double df) {
        this.dilutionFactor = df;
    }

    /**
     * Method getDF will return the dilution factor.
     * @return The dilution factor
     */
    public double getDF() {
        return this.dilutionFactor;
    }

    private boolean isEmpty(double n) {
        if (n <= 0) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Method calculate does the super calculation.
     */
    public void calculate() {

        if (isEmpty(getC1()) && isEmpty(getV1()) && isEmpty(getC2()) && isEmpty(getV2())) {
            setOutput("You didn't enter anything!");
        } else if (isEmpty(getC1())) {
            c1Missing();
        } else if (isEmpty(getC2())) {
            c2Missing();
        } else if (isEmpty(getV1())) {
            v1Missing();
        } else if (isEmpty(getV2())) {
            v2Missing();
        } else if ((getC1() * getV1()) != (getC2() * getV2())) {
            setOutput("Lol you suck at math.");
        } else {
            setOutput("What the fuck do you need me for?");
        }
    }

    /**
     * Method c1Missing will calculate c1 from the other three variables.
     */
    private void c1Missing() {
        double temp;
        temp = getC2() * getV2() / getV1();
        setC1(temp);
        setOutput("The original stock solution should be " + getC1() +
                           ".");
    }

    /**
     * Method c2Missing will calculate c2 from the other three variables.
     */
    private void c2Missing() {
        double temp;
        temp = getC1() * getV1() / getV2();
        setC2(temp);
        setOutput("The final concentration of the diluted solution" +
                           "will be: " + getC2() + ".");
    }

    /**
     * Method v1Missing will calculate v1 from the other three variables.
     */
    private void v1Missing() {
        double temp;
        temp = getC2() * getV2() / getC1();
        setV1(temp);
        setOutput("Use " + getV1() + " amount of stock solution " +
                           "and add " + diluent() + " amount of diluent.");
    }

    /**
     * Method v2Missing will calculate v2 from the other three variables.
     */
    private void v2Missing() {
        double temp;
        temp = getC1() * getV1() / getC2();
        setV2(temp);
        setOutput("This is the amount of solution you will end" +
                           "up with: " + getV2() + ".");
    }

    /**
     * Method diluent tells you how much diluent to add.
     * @return the amount of diluent to add
     */
    public double diluent() {
        return getV2() - getV1();
    }   

    /**
     * Method reset sets all the variables to zero for recalculation
     */
    public void reset() {
        setC1(0);
        setV1(0);
        setC2(0);
        setV2(0);
        setOutput(null);
    } 
        
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Dilution calculator = new Dilution();

        System.out.println("Welcome to the Smith Lab's Dilution calculator!");

        while (true) {
            calculator.reset();

            System.out.println("What stock solution do you have?");

            System.out.print("Concentration (-1 if unknown): ");
            double c1 = input.nextDouble();
            if (c1 != 0) {
                calculator.setC1(c1);
            }

            System.out.print("Volume 1 (-1 if unknown): ");
            double v1 = input.nextDouble();
            if (v1 != 0) {
                calculator.setV1(v1);
            }

            System.out.println("What final solution do you need?");

            System.out.print("Concentration 2 (-1 if unknown): ");
            double c2 = input.nextDouble();
            if (c2 != 0) {
                calculator.setC2(c2);
            }

            System.out.print("Volume 2 (-1 if unknown): ");
            double v2 = input.nextDouble();
            if (v2 !=0) {
                calculator.setV2(v2);
            }

            calculator.calculate();
            
            System.out.print("Would you like to continue? (y/n): ");
            String lala = input.next();

            if (lala.equals("n")) {
                break;
            }
        }
        System.out.println("Thank you for using Albert's calculator!");
    }//end of void main
}//end of class Dilution
