package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AnnualReport{
    public void display(){
        //todo update annualReport.txt
        try{
            File expenseFile = new File("main/expenseRecord");
            Scanner scan = new Scanner(expenseFile);
            scan.nextLine();
            scan.nextLine();

            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                String[] expense = data.split(",");

                //todo You need to write and update the file



            }




            File annualFile = new File("main/annualReport");
            scan = new Scanner(annualFile);
            System.out.println(scan.nextLine());
            System.out.println(scan.nextLine());

            String data = scan.nextLine();
            String[] expense = data.split(",");
            int income = Integer.parseInt(expense[1].replaceAll(" ", ""));

            while (scan.hasNextLine()) {
                data = scan.nextLine();
                expense = data.split(",");
                System.out.println(expense[0] + ":" + expense[1]);
            }

            float absoluteTotal = (income + new RentRecord().getSumOfRent() - new ExpenseRecord().displaySummary());
            System.out.println("\nThe total profit is: " + absoluteTotal);
            System.out.println();
            scan.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}