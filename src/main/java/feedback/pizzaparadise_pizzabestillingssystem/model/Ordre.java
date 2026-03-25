package feedback.pizzaparadise_pizzabestillingssystem.model;

import java.time.LocalDateTime;

public class Ordre {

    // Variables
    private int ordreID;
    private int pizzaID;
    private double totalPrice;
    private LocalDateTime date;
    private int userID;

    // Full Constructor with ID
    public Ordre(int ordreID, int pizzaID, double totalPrice, LocalDateTime date, int userID) {
        this.ordreID = ordreID;
        this.pizzaID = pizzaID;
        this.totalPrice = totalPrice;
        this.date = date;
        this.userID = userID;
    }

    // Full Constructor without ID
    public Ordre(int pizzaID, double totalPrice, LocalDateTime date, int userID) {
        this.pizzaID = pizzaID;
        this.totalPrice = totalPrice;
        this.date = date;
        this.userID = userID;
    }

    // Empty Constructor
    public Ordre() {
    }

    // GET & SET for ID
    public int getOrdreID() {
        return ordreID;
    }
    public void setOrdreID(int ordreID) {
        this.ordreID = ordreID;
    }

    // GET & SET for PizzaID
    public int getPizzaID() {
        return pizzaID;
    }
    public void setPizzaID(int pizzaID) {
        this.pizzaID = pizzaID;
    }

    // GET & SET for TotalPrice
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    // GET & SET for Date
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }

}
