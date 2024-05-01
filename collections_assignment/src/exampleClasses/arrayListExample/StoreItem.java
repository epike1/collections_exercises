package exampleClasses.arrayListExample;

public class StoreItem {

    private String name;
    private double cost;

    public StoreItem() {
        this.name = "Item";
        this.cost = 5.00;
    }
    public StoreItem(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
