package net.marwa.applicationy;


public class Band {
    String first,phone;
    int last;
    double price;

    public Band(String first,int last, String phone,double price) {
        this.first=first;
        this.last=last;
        this.phone = phone;
        this.price=price;

    }

    public Band() {
    }
    public String getFirst(){ return first;}
    public int getLast() {
        return last;
    }
    public double getPrice()
    {
        return price;
    }



}