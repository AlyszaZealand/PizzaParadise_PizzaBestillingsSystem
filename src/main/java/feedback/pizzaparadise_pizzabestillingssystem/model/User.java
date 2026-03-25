package feedback.pizzaparadise_pizzabestillingssystem.model;

public class User {

    // Variables
    private int userID;
    private String name;
    private String email;
    private String address;
    private int bonuspoints;

    // Full Constructor with ID
    public User(int userID, String name, String email, String address, int bonuspoints) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.address = address;
        this.bonuspoints = bonuspoints;
    }

    // Full Constructor without ID
    public User(String name, String email, String address, int bonuspoints) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.bonuspoints = bonuspoints;
    }

    // Empty Constructor
    public User() {
    }

    // GET & SET for UserID
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }

    // GET & SET for Name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // GET & SET for Email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // GET & SET for Address
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    // GET & SET for Bonuspoints
    public int getBonuspoints() {
        return bonuspoints;
    }
    public void setBonuspoints(int bonuspoints) {
        this.bonuspoints = bonuspoints;
    }

}
