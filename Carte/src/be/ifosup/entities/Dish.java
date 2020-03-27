package be.ifosup.entities;

public class Dish {

    //champs

    private int id;
    private String title;
    private String description;
    private float price;


    //Constructeurs

    public Dish(String title, String description, float price, int id) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.id = id;
    }


    // GetSet

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
