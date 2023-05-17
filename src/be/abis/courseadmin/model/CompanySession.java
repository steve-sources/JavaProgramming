package be.abis.courseadmin.model;

import be.abis.courseadmin.exception.PriceTooHighException;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class CompanySession extends Session {
    private int nombreDeParticipants;
    Course c;
    Company organizer;

 /*   public CompanySession(Course course,int nombreDeParticipants){
        super(course);
        this.nombreDeParticipants = nombreDeParticipants;
    }*/
    public CompanySession(LocalDate startDate, Course course, Company location, Person instructor, int nombreDeParticipants, Company organizer) {
        super(startDate, course, location, instructor);
        this.nombreDeParticipants = nombreDeParticipants;
        this.organizer = organizer;
    }

    public CompanySession(Course c, int nombreDeParticipants) {
        this.nombreDeParticipants = nombreDeParticipants;
        this.course = c;
    }


    public int getNombreDeParticipants() {
        return nombreDeParticipants;
    }

    public void setNombreDeParticipants(int nombreDeParticipants) {
        this.nombreDeParticipants = nombreDeParticipants;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("This session is offered by you by "+ this.organizer.getName() + ".There will be " + this.getNombreDeParticipants() +" participants");
    }

    @Override
    public double calculatePrice() throws PriceTooHighException {

        final double  maxPrice = 2000.00;
        double totalPrice = this.nombreDeParticipants * course.getPricePerDay() * course.getNumberOfDays();
        if (totalPrice > maxPrice) { throw new PriceTooHighException("Price " + totalPrice + " > " + maxPrice);}
        return totalPrice;
    }

    @Override
    public void getOrganizer() {
        System.out.println("retour de l'oranisateur à partir de CompanySession");
    }
    
 


}
