package feedback.pizzaparadise_pizzabestillingssystem.model;

public class Topping {

    // Variables
    private int toppingID;
    private String name;
    private double price;

    // Full Constructor with ID
    public Topping(int toppingID, String name, double price) {
        this.toppingID = toppingID;
        this.name = name;
        this.price = price;
    }

    // Full Constructor without ID
    public Topping(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Empty Constructor
    public Topping() {
    }

    // GET & SET for ToppingID
    public int getToppingID() {
        return toppingID;
    }
    public void setToppingID(int toppingID) {
        this.toppingID = toppingID;
    }

    // GET & SET for Name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // GET & SET for Price
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

}
