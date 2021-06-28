package main;

public class Expense{
    int month, day;
    String category, payee;
    float amount;

    public Expense(){
        month = 0;
        day = 0;
        category = null;
        payee = null;
        amount = 0.0f;
    }

    public Expense(int m, int d, String c, String p, float a){
        month = m;
        day = d;
        category = c;
        payee = p;
        amount = a;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}