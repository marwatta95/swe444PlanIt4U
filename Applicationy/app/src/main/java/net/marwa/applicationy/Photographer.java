package net.marwa.applicationy;


public class Photographer {
    String first,last,phone;
    double price;

    public Photographer(String first,String last, String phone,double price) {
        this.first=first;
        this.last=last;
        this.phone = phone;
        this.price=price;

    }

    public Photographer() {
    }
    public String getFirst(){ return first;}
    public double getPrice()
    {
        return price;
    }

    public String getLast() {
        return last;
    }

    public String getPhone(String imageUri) {
        return phone;
    }
}