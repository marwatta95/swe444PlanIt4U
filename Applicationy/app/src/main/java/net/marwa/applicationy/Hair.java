package net.marwa.applicationy;


public class Hair {
    String first,last,phone;
    double price;

    public Hair(String first,String last, String phone,double price) {
        this.first=first;
        this.last=last;
        this.phone = phone;
        this.price=price;

    }

    public Hair() {
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