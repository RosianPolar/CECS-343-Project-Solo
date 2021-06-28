package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RentRecord{
    public void display(){
        try {
            File myObj = new File("main/rentRecord");
            Scanner scan = new Scanner(myObj);
            System.out.println(scan.nextLine());
            System.out.println(scan.nextLine());

            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                String[] rent = data.split(",");
                System.out.println(rent[0] + " " + rent[1] + " " + rent[2] + " " + rent[3] +  " " +
                        rent[4] + " " + rent[5] + " " + rent[6] + " " + rent[7] + " " + rent[8] + " " + rent[9] +
                        " " + rent[10] + " " + rent[11] + " " + rent[12]);
            }
            System.out.println();
            getSumOfRent();

            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }

    public float getSumOfRent(){
        try {
            File myObj = new File("main/rentRecord");
            Scanner scan = new Scanner(myObj);
            scan.nextLine();
            scan.nextLine();

            int totalRent = 0;
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                String[] rent = data.split(",");

                int yearlyRent = Integer.parseInt(rent[0]) * -1;
                for(String s : rent){
                    yearlyRent += Integer.parseInt(s.replaceAll(" ", ""));
                }

                totalRent += yearlyRent;

                //Debug print statements
                // System.out.println("Yearly rent of AptNo: " + rent[0]
                //        + ": " + yearlyRent);

            }
            scan.close();

            //Debug print statements
            // System.out.println("Total rent: " + totalRent);
            // System.out.println();

            return Float.parseFloat(String.valueOf(totalRent));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

        return 0.0f;
    }

}