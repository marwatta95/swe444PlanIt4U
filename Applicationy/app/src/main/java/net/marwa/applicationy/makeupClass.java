package net.marwa.applicationy;

/**
 * Created by reems on 03/03/18.
 */

public class makeupClass {


    public String Fname;
    public String Lname;
    public String gender;
    public Object [] samples;
    public makeupClass (String fname,String lname,String gender,Object [] samples){
        Fname=fname;
        Lname=lname;
        this.gender=gender;
        this.samples=samples;
    }
}
