package exampleClasses.arrayListExample;

import java.util.Scanner;

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
        name = input.nextLine().trim();


        do {

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
        System.out.printf("Added to cart.%n");

        return storeItem;
    }
    public static void runExample(){

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
            input.nextLine();

            switch(choice) {
                case 1:
                    cart.addToCart(createStoreItem());
                    break;
                case 2:
                    System.out.printf("%n%nEnter the name of the item you want to remove: ");
                    String name = input.nextLine();
                    cart.removeItem(name);
                    break;
                case 3:
                    cart.displayCartItems();
                    break;
                case 4:
                    System.out.printf("%n%nProceeding to checkout.%n");
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
            System.out.printf("%-25s: %10.2f%n", i.getName(), i.getCost());

            totalCost += i.getCost();
        }

        System.out.printf("%n%-25s: %10.2f", "Total", totalCost);


        input.close();

    }

}
