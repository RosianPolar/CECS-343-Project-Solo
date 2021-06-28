package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RentInputScreen {

    public void display() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the apartment number to input rent for: ");
        int aptNo = scan.nextInt();
        System.out.print("\nEnter the rent paid: ");
        float rent = scan.nextFloat();
        System.out.print("\nWhat month is this rent for: ");
        int month = scan.nextInt();

        addRent(aptNo, rent, month);
    }

    public void addRent(int aptNo, float rent, int month) throws IOException {
        //Instantiating the File class
        String filePath = "main/rentRecord.txt";

        //Instantiating the Scanner class to read the file
        Scanner sc = new Scanner(new File(filePath));

        //instantiating the StringBuffer class
        StringBuffer buffer = new StringBuffer();

        //Reading lines of the file and appending them to StringBuffer
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine()+System.lineSeparator());
        }
        String fileContents = buffer.toString();
        System.out.println("Contents of the file: "+fileContents);

        //closing the Scanner object
        sc.close();
        String oldLine = "No preconditions and no impediments. Simply Easy Learning!";
        String newLine = "Enjoy the free content";

        //Replacing the old line with new line
        fileContents = fileContents.replaceAll(oldLine, newLine);

        //instantiating the FileWriter class
        FileWriter writer = new FileWriter(filePath);
        System.out.println("");
        System.out.println("new data: " + fileContents);
        writer.append(fileContents);
        writer.flush();


    }
}
