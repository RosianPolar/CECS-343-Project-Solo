package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RentInputScreen {

    public void display() throws IOException {
        Scanner scan = new Scanner(System.in);

        int aptNo;
        do {
            System.out.print("Enter the apartment number to input rent for: ");
            aptNo = scan.nextInt();
         }while(!hasAptData(aptNo));


        System.out.print("Enter the rent paid: ");
        float rent = scan.nextFloat();
        System.out.print("What month is this rent for: ");
        int month = scan.nextInt();

        addRent(aptNo, rent, month);
    }

    public void addRent(int aptNo, float rent, int month) throws IOException {
        File myObj = new File("main/rentRecord");
        Scanner scan = new Scanner(myObj);
        scan.nextLine();
        scan.nextLine();

        String data = "", dataFiltered = "", newData = "";
        String[] rentData;
        String[] aptData = new String[12];

        while (scan.hasNextLine()){
            data = scan.nextLine();
            dataFiltered = data.replaceAll(" ", "");
            rentData = dataFiltered.split(",");


            if (Integer.parseInt(rentData[0]) == aptNo){
                aptData = rentData;
                break;
            }
        }
        scan.close();
        aptData[month] = Float.toString(rent);

        //Instantiating the File class
        String filePath = "main/rentRecord";

        //Instantiating the Scanner class to read the file
        Scanner sc = new Scanner(new File(filePath));

        //instantiating the StringBuffer class
        StringBuffer buffer = new StringBuffer();

        //Reading lines of the file and appending them to StringBuffer
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine()+System.lineSeparator());
        }
        String fileContents = buffer.toString();

        // Debug print statements
        // System.out.println("Before:\n" + fileContents);

        //closing the Scanner object
        sc.close();
        String oldLine = data;
        for(String s : aptData){
            newData += s + ",";
            for (int i = s.length(); i < 7; i++){ //Adding spaces to keep the format of rentRecord.txt
                newData += " ";
            }
        }
        newData = newData.substring(0,newData.length()-7);
        String newLine = newData;

        //Replacing the old line with new line
        fileContents = fileContents.replaceAll(oldLine, newLine);

        //instantiating the FileWriter class
        FileWriter writer = new FileWriter(filePath);
        System.out.println("");

        // Debug print statements
        // System.out.println("After:\n" + fileContents);
        writer.append(fileContents);
        writer.flush();
    }

    public boolean hasAptData(int aptNo) throws FileNotFoundException {
        File myObj = new File("main/rentRecord");
        Scanner scan = new Scanner(myObj);
        scan.nextLine();
        scan.nextLine();

        while(scan.hasNextLine()) {
            String data = scan.nextLine();
            String[] aptData = data.split(",");
            String d = aptData[0];
            if (Integer.parseInt(aptData[0].replaceAll(" ", "")) == aptNo)
                return true;
        }
        System.out.println("Apartment " + aptNo + " has no tenant. Enter another apartment number.");
        return false;
    }
}
