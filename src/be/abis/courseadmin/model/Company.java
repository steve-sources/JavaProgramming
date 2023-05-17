package be.abis.courseadmin.model;

import be.abis.courseadmin.exception.*;

import java.util.Comparator;

public class Company implements Comparable<Company> {

    private String name;

    private int companyNumber;


    public Company(String name,int companyNumber) {

        this.name = name;
        this.companyNumber = companyNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(int companyNumber) {
        this.companyNumber = companyNumber;
    }

    public void printInfo(){
        System.out.println("Le nom de la compagnie est : " + name);
    }

    @Override
    public String toString() {return "compagnie " + name + " num " + companyNumber ;}

    public void requestPriceOfferForCompanySession(Course c,int nombreDeParticipants) throws PriceException {
        double minOfferPrice = 2000;
        double offerPrice;
        CompanySession sessionCompagnie = new CompanySession(c,nombreDeParticipants);
        offerPrice = sessionCompagnie.calculatePrice();

        if (offerPrice < minOfferPrice){
            throw new PriceTooHighException("Offre de " + minOfferPrice + " trop basse");
        }


    }


    @Override
    public int compareTo(Company o) {
        return (this.getName().compareTo(o.getName()));
    }

    public static class SortAllByCompanyNumbers implements Comparator<Company>{

        @Override
        public int compare(Company o1, Company o2) {
            return (o1.getCompanyNumber() < o2.getCompanyNumber() ? -1 : (o1.getCompanyNumber() < o2.getCompanyNumber() ?0 : 1));
        }
    }
}

