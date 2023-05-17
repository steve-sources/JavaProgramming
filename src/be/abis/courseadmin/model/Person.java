package be.abis.courseadmin.model;

import java.util.HashSet;

public class Person {
    private String firstName;
    private String lastName;
    private Company company;
    private static int counter;
    private int personNumber;

    Course course;
    /*private String[] hobbies;*/
    HashSet<String> hobbies;

    public Company getCompany() {
        return company;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static int getCounter() {
        return counter;
    }

    public HashSet<String> getHobbies() {
        return hobbies;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        /*this.hobbies = new String[10];*/
        hobbies = new HashSet<String>(10);
        counter++;
        this.personNumber = counter;
    }

    public Person(String firstName, String lastName, Company company) {
        this(firstName,lastName);
        this.company = company;
        counter++;
        this.personNumber = counter;
    }

    public void printInfo(){

    System.out.println("Client num : " + personNumber + " " + firstName + " " + lastName + (this.company==null ? " ne travaille pas pour une compagnie":" travaille pour : " + company.getName() )) ;

    }


    public void attendCourse(Course c){
        System.out.println(this.firstName + " is attending " + c.getTitle());
    }

    public void addHobby(String hobby){
        this.hobbies.add(hobby);
    }

    public void addHobbies(String... hobbies){
        for (String h:hobbies){
            this.hobbies.add(h);
        }

    }

    @Override
    public String toString() {return firstName + " " + lastName;}

}
