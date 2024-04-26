package exampleClasses;
import java.util.*;

public class Cart {

    private ArrayList<StoreItem> storeItemList = new ArrayList<StoreItem>();
    public Cart() {

    }

    public ArrayList<StoreItem> getStoreItemList() {
        return storeItemList;
    }

    public void setStoreItemList(ArrayList<StoreItem> storeItemList) {
        this.storeItemList = storeItemList;
    }

    public void addToCart(StoreItem item) {
        storeItemList.add(item);
    }

    public void removeItem(String name) {

        name = name.trim();
        boolean foundItem = false;

        for (StoreItem i : storeItemList) {

            if (name.equalsIgnoreCase(i.getName())) {
                storeItemList.remove(i);
                foundItem = true;
            }

            break;
        }

        if (foundItem) {
            System.out.println("Item removed.");
        } else {
            System.out.println("Item could not be found in cart.");
        }
    }

    public void displayCartItems() {

        if (storeItemList.size() > 0) {
            System.out.printf("Cart Items:%n%n");

            int x = 0;

            for (StoreItem i : storeItemList) {
                x++;
                System.out.printf("%d. %s, $%.2f%n", x, i.getName(), i.getCost());
            }
        } else {
            System.out.println("No items in cart.");
        }
    }
}
