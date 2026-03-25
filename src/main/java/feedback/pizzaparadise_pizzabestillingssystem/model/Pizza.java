package feedback.pizzaparadise_pizzabestillingssystem.model;

public class Pizza {

    // Variables
    private int pizzaID;
    private String name;
    private String description;
    private double price;
    private int toppingID;

    // Full Constructor with ID
    public Pizza(int pizzaID, String name, String description, double price, int toppingID) {
        this.pizzaID = pizzaID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.toppingID = toppingID;
    }

    // Full Constructor without ID
    public Pizza(String name, String description, double price, int toppingID) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.toppingID = toppingID;
    }

    // Empty Constructor
    public Pizza() {
    }

    // GET & SET for ID
    public int getPizzaID() {
        return pizzaID;
    }
    public void setPizzaID(int pizzaID) {
        this.pizzaID = pizzaID;
    }

    // GET & SET for Name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // GET & SET for Description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // GET & SET for Price
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    // GET & SET for ToppingID
    public int getToppingID() {
        return toppingID;
    }
    public void setTopping(int toppingID) {
        this.toppingID = toppingID;
    }


}
