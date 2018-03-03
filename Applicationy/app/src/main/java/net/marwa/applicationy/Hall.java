package net.marwa.applicationy;

/**
 * Created by samar fares on 3/2/2018.
 */

public class Hall {
    String name,description,address;
    int capacity;double price;
    String imageUri;

    public Hall(String name, String description,String address,int capacity,double price, String imageUri) {
        this.name = name;this.description = description;this.address=address;this.capacity=capacity;this.price=price;
        this.imageUri = imageUri;
    }

    public Hall() {
    }

    public String getName() {
        return name;
    }
    public String getDescription(){
       return description;
    }
    public String getAddress()
    {
        return address;
    }
    public double getPrice()
    {
        return price;
    }
    public int getCapacity()
    {
        return capacity;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
}