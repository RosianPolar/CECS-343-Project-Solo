package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExpenseInputScreen {
    public void display(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the month of this expense: ");
        int month = scan.nextInt();
        System.out.print("Enter the day of this expense: ");
        int day = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter the name of the payee: ");
        String payee = scan.next();
        System.out.print("Enter the amount due: ");
        float amount = scan.nextFloat();
        scan.nextLine();
        System.out.print("Enter the category: ");
        String category = scan.next();

        addExpense(month, day, payee, amount, category);
    }

    public void addExpense(int month, int day, String payee, float amount, String category){
        try
        {
            String[] expData = {Integer.toString(month), Integer.toString(day), payee, Float.toString(amount), category};

            int j = 0;
            for(String s : expData){
                expData[j] += ",";
                for (int i = s.length(); i < 7; i++){ //Adding spaces to keep the format of rentRecord.txt
                    expData[j] += " ";
                }
                j++;
            }
            expData[0] += "/";
            expData[0] = expData[0].replaceAll(" ", "");
            expData[4] = expData[4].replaceAll(" ", "").replaceAll(",", "");
            expData[3] = expData[3] + "    ";


            FileWriter fw = new FileWriter("main/expenseRecord",true); //the true will append the new data
            fw.write("\n" + expData[0] + expData[1] + expData[2] + expData[3] + expData[4]);//appends the string to the file
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }




    }
}
