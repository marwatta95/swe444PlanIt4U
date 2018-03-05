package net.marwa.applicationy;


public class Dj {
    String first,last,phone;
    double price;

    public Dj(String first,String last, String phone,double price) {
        this.first=first;
        this.last=last;
        this.phone = phone;
        this.price=price;

    }

    public Dj() {
    }
    public String getFirst(){ return first;}
    public double getPrice()
    {
        return price;
    }

    public String getLast() {
        return last;
    }

}