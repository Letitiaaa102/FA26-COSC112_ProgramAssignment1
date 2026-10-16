/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// import libraries
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author CPAL-Admin_mobile
 */
public class EmpSalaryInc {
    
    // TO DO

    public static void main(String[] args)
            throws FileNotFoundException {

        // Open the input and output files
        Scanner fin = new Scanner(
                new File("src/EmpData.txt"));

        PrintWriter fout = new PrintWriter(
                "EmpDataOutput.dat");

        // Declare variables
        String lastName, firstName;
        double salary, newSalary;
        double payIncrease;
        double increaseAmount;

        // Get data
        while (fin.hasNext()) {

            lastName = fin.next();
            firstName = fin.next();
            salary = fin.nextDouble();
            payIncrease = fin.nextDouble();

            // Calculate data
            increaseAmount = salary * (payIncrease / 100);
            newSalary = salary + increaseAmount;

            // Display data
            String employeeInfo = String.format(
                    java.util.Locale.US,
                    "Employee name: %s, %s%n" +
                            "Current salary: $%.2f%n" +
                            "%% pay rise: %s%%%n" +
                            "==== New salary amount: $%.2f",
                    lastName, firstName, salary,
                    Double.toString(payIncrease)
                            .replaceAll("\\.0$", ""),
                    newSalary);

            System.out.println(employeeInfo);

            JOptionPane.showMessageDialog(null, employeeInfo);

            // Write results to output file
            fout.println(employeeInfo);
            fout.println();
        }

        // Close files
        fin.close();
        fout.close();
    }

}
