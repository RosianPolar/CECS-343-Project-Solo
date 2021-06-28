package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TenantList {

    public void display(){
        //Retrieving all Tenants Stored.
        try {
            File myObj = new File("main/listOfTenants");
            Scanner scan = new Scanner(myObj);
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                String[] tenant = data.split(",");
                System.out.println("Apt No:"+ tenant[1] + ", " + tenant[0]);
            }
            System.out.println();
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}