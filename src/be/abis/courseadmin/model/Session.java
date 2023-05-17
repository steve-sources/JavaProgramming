package be.abis.courseadmin.model;

import be.abis.courseadmin.exception.PriceTooHighException;
import be.abis.courseadmin.exception.PriceTooLowException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Session extends Service {
    private LocalDate startDate;
    Course course;
    Company location;
    Person instructor;
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");



    public Session(){

    }

    public Session(LocalDate startDate, Course course, Company location, Person instructor) {
        this.startDate = startDate;
        this.course = course;
        this.location = location;
        this.instructor = instructor;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void printInfo(){
        System.out.println( "The " + course.getTitle() + " will start on " + this.getStartDate().format(fmt) );
        System.out.println( "It will take place at " + location.getName());
        System.out.println("Your Instructor is " + instructor.getFirstName() + " " + instructor.getLastName());
    }

    @Override
    public double calculatePrice() throws PriceTooHighException, PriceTooLowException {
        return 700.00;
    }

    public abstract void getOrganizer();
}
