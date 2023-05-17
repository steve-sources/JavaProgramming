package be.abis.courseadmin.model;

public class Course {
    private String title;
    private int numberOfDays;
    private double pricePerDay;

    public Course(String title,int numberOfDays,double pricePerDay){
        this.title = title;
        this.numberOfDays = numberOfDays;
        this.pricePerDay = pricePerDay;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void printInfo(){
        System.out.println("Title : " + title);
        System.out.println("Number of days : " + numberOfDays);
        System.out.println("Price per days : " + pricePerDay);
        System.out.println("Le prix total est :" + calculateTotalPrice());
    }

    private double calculateTotalPrice(){
        double total = numberOfDays * pricePerDay;
        return total;
    }

    private double calculateTotalPrice(int reduction){
        double total = numberOfDays * (pricePerDay - ((pricePerDay/100)*reduction));
        return total;
    }

    @Override
    public String toString() {return "course " + title;}
}
