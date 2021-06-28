package main;

public class Tenant{
    private String name;
    private int aptNumber;

    public Tenant(){
        name = "";
        aptNumber = 0;
    }

    public Tenant(String n, int apn ){
        name = n;
        aptNumber = apn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAptNumber() {
        return aptNumber;
    }

    public void setAptNumber(int aptNumber) {
        this.aptNumber = aptNumber;
    }
}