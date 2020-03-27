package be.ifosup.entities;

public class Dish {

    //champs

    private int id;
    private String title;
    private String description;
    private float price;
    private int catid;

    //Constructeurs

    public Dish(String title, String description, float price) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.catid = catid;
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

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }
}
