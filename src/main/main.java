package main;

import java.io.FileNotFoundException;

public class main{
    public static void main(String[] args) throws FileNotFoundException {
        //Sanity Check
        System.out.println("Press Any Key To Continue...");
        new java.util.Scanner(System.in).nextLine();

        UserInterface us = new UserInterface();
        us.interact();
    }
}