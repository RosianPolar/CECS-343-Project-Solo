package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExpenseRecord{
    public void display(){
        try {
            File myObj = new File("main/expenseRecord");
            Scanner scan = new Scanner(myObj);
            System.out.println(scan.nextLine());
            System.out.println(scan.nextLine());

            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                String[] expense = data.split(",");
                System.out.println(expense[0] + "," + expense[1] + "," + expense[2] + "," + expense[3]);
            }

            System.out.println();
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }

    public float displaySummary(){
        try {
            File myObj = new File("main/expenseRecord");
            Scanner scan = new Scanner(myObj);
            scan.nextLine();
            scan.nextLine();

            int totalExpenses = 0;
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                String[] expenses = data.split(",");
                totalExpenses += Integer.parseInt(expenses[2].replaceAll(" ", ""));
            }
            scan.close();
            // System.out.println("Total expenses: " + totalExpenses);
            // System.out.println();
            return Float.parseFloat(String.valueOf(totalExpenses));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        return 0.0f;
    }
}