package net.marwa.applicationy;


public class Decor {
     double price;
    String imageUri;

    public Decor(double price, String imageUri) {
      this.price=price;
        this.imageUri = imageUri;
    }

    public Decor() {
    }

    public double getPrice()
    {
        return price;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
}