package main;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface{
    public UserInterface(){

    }

    public void interact() throws IOException {
        System.out.print("""
                Welcome to the Rental management program.
                Please select an option to continue:
                1) Add a new Tenant
                2) Input an expense
                3) Input a rental payment
                4) Display the Tenant List
                5) Display the Expense Record
                6) Display the Annual Summary
                7) Display the Rent Record
                8) Quit
                """);

        Scanner in = new Scanner(System.in);
        int input = in.nextInt();

        while (input > -999){
            switch(input){
                case 1:
                    System.out.println("Adding a new Tenant");
                    TenantInputScreen tis = new TenantInputScreen();
                    tis.display();
                    break;
                case 2:
                    System.out.println("Adding a new expense");
                    ExpenseInputScreen eis = new ExpenseInputScreen();
                    eis.display();
                    break;
                case 3:
                    System.out.println("Adding a new rental payment");
                    RentInputScreen ris = new RentInputScreen();
                    ris.display();
                    break;
                case 4:
                    System.out.println("Displaying the list of tenants:");
                    TenantList tl = new TenantList();
                    tl.display();
                    break;
                case 5:
                    System.out.println("Displaying the Expense Record:");
                    ExpenseRecord er = new ExpenseRecord();
                    er.display();
                    er.displaySummary();
                    break;
                case 6:
                    System.out.println("Displaying the Annual Summary");
                    AnnualReport ar = new AnnualReport();
                    ar.display();
                    break;
                case 7:
                    System.out.println("Displaying the Rent Record");
                    RentRecord rr = new RentRecord();
                    rr.display();
                    break;
                case 8:
                    System.out.println("Thanks for using the Rental management program!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input. Please input a number 1-7");
                    break;
            }
            System.out.println(
                    """
                Please select an option to continue:
                1) Add a new Tenant
                2) Input an expense
                3) Input a rental payment
                4) Display the Tenant List
                5) Display the Expense Record
                6) Display the Annual Summary
                7) Display the Rent Record
                8) Quit
                """);
            input = in.nextInt();
        }
    }
}