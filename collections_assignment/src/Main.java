// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.*;
import exampleClasses.*;

public class Main {

    public static void displayArrayListOptions() {

        System.out.println("Select an option:");
        System.out.println("1. Add an item.");
        System.out.println("2. Remove an item.");
        System.out.println("3. View items in cart.");
        System.out.println("4. Checkout.");
        System.out.print("Enter the number of your choice: ");
        
    }

    public static void createStoreItem() {
        Scanner input = new Scanner(System.in);
        String name = "";
        double cost = 0.00;

        System.out.println("\n\nEnter the name of the item: ");
        name = input.nextLine().trim();


        do {
            System.out.println("Enter the cost of the item: ");

            try {
                cost = input.nextDouble();
            } catch (Exception e) {

            }

        } while(false);
    }
    public static void arrayListExample(){

        Scanner input = new Scanner(System.in);
        Cart cart = new Cart(); // cart class contains the arraylist

        int choice = 0;
        boolean checkout = false;

        do {

            displayArrayListOptions();

            try {
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input!\n");
                input.next();
                continue;
            }

            switch(choice) {
                case 1:
                    displayArrayListOptions();
                case 2:

                    System.out.printf("%n%nEnter the name of the item you want to remove: ");
                    cart.removeItem(input.nextLine());
                case 3:
                    cart.displayCartItems();
                case 4:
                    System.out.printf("%n%nProceeding to checkout.%n");
                    checkout = true;
                default:
                    System.out.println("%n%nCould not find option specified.%n");
            }

        } while(!checkout);

        input.close();

    }

    public static void main(String[] args) {

        arrayListExample();
    }
}