package exampleClasses.arrayListExample;

import java.util.Scanner;
import exampleClasses.outputFunctions;


public class ArrayListExample {
    private static void displayArrayListOptions() {

        System.out.println("Select an option:");
        System.out.println("1. Add an item.");
        System.out.println("2. Remove an item.");
        System.out.println("3. View items in cart.");
        System.out.println("4. Checkout.");
        System.out.print("Enter the number of your choice: ");

    }

    private static StoreItem createStoreItem() {

        Scanner input = new Scanner(System.in);
        StoreItem storeItem;
        String name = "";
        double cost = 0.00;

        System.out.printf("%n%nEnter the name of the item: ");

        name = input.nextLine();
        name = name.trim().toLowerCase();



        do {
        	
        	outputFunctions.delay(500);

            System.out.print("Enter the cost of the item: ");

            try {
                cost = input.nextDouble();
            } catch (Exception e) {
                System.out.println("Invalid input. Must be a number.");
                input.next();
                continue;
            }

            if (cost <= 0) {
                System.out.println("Invalid cost. Must be greater than zero.");
            } else {
                break;
            }

        } while(true);

        storeItem = new StoreItem(name, cost);
        System.out.printf("Added to cart.%n%n");
        outputFunctions.delay(500);

        return storeItem;
    }

    private static int getChoice() {

        Scanner input = new Scanner(System.in);
        int choice;

        do {
            outputFunctions.delay(500);
            displayArrayListOptions();

            try {
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input!\n");
                input.next();
                continue;
            }

            break;

        } while (true);
        return choice;
    }

    public static void removeItem(Cart cart) {
        Scanner input = new Scanner(System.in);

        System.out.printf("%n%nEnter the name of the item you want to remove: ");
        String name = input.nextLine();
        cart.removeItem(name);
        outputFunctions.delay(500);
        System.out.println();

    }

    public static void runExample(){
        Cart cart = new Cart(); // cart class contains the array list

        boolean checkout = false;

        do {
            switch(getChoice()) {
                case 1:
                    cart.addToCart(createStoreItem());
                    break;
                case 2:
                   removeItem(cart);
                   break;
                case 3:
                    cart.displayCartItems();
                    break;
                case 4:
                    System.out.printf("%n%nProceeding to checkout.%n");
                    outputFunctions.delay(1500);
                    checkout = true;
                    break;
                default:
                    System.out.println("%n%nCould not find option specified.%n");
                    break;
            }

        } while(!checkout);

        double totalCost = 0.00;

        System.out.println("\nReceipt:");
        for (StoreItem i : cart.getStoreItemList()) {
            System.out.printf("%-25s %10.2f%n", i.getName() + ":", i.getCost());

            totalCost += i.getCost();
            outputFunctions.delay(500);
        }

        System.out.printf("%n%-25s %10.2f", "Total:", totalCost);
    }

}
