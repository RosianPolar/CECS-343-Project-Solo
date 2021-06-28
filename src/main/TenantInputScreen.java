package main;

import java.io.*;
import java.util.Scanner;

public class TenantInputScreen {

    public void display() throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the Tenant's full name: ");
        String name = scan.nextLine();
        System.out.print("Please enter the apartment to assign " + name + ": ");
        int aptNo = scan.nextInt();

        while(!isApartmentAvaliable(aptNo)){
            System.out.print("Sorry, that apartment is currently occupied. Please enter a new apartment number: ");
            aptNo = scan.nextInt();
        }
        System.out.println("Assigning " + name + " to aptNo: " + aptNo);
        addTenant(name, aptNo);
    }

    public boolean isApartmentAvaliable(int aptNo) throws FileNotFoundException {
        File myObj = new File("main/listOfTenants");
        Scanner scan = new Scanner(myObj);

        while(scan.hasNextLine()){
            String data = scan.nextLine();
            String[] tenants = data.split(",");
            if (Integer.parseInt(tenants[1].replaceAll(" ", "")) == aptNo)
                return false;
        }
        return true;
    }

    public void addTenant(String name, int aptNo) {
        try
        {
            FileWriter fw = new FileWriter("main/listOfTenants",true); //the true will append the new data
            fw.write("\n" + name + ", " + aptNo);
            fw.close();
        }
        catch(IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }


}
