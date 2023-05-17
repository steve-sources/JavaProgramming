package be.abis.courseadmin.test;

import be.abis.courseadmin.exception.CompanyNotFoundException;
import be.abis.courseadmin.exception.PriceException;
import be.abis.courseadmin.exception.PriceTooHighException;
import be.abis.courseadmin.exception.PriceTooLowException;
import be.abis.courseadmin.model.*;
import be.abis.courseadmin.repository.*;
import be.abis.courseadmin.service.AbisCompanyService;

import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Test {
    private static final String limit = "/*----------------------------------------------*/";

    public static void main(String[] args) throws IOException {
        Course javaTraining = new Course("Java Programming", 2, 250.0);
        /*Company companyFortis = new Company("BNP Paribas Fortis",1);
        Company companyIBM = new Company("IBM",2);
        Company companyABIS = new Company("ABIS",3);*/
        MemoryArrayCompanyRepository memoryArrayCompanyRepository = new MemoryArrayCompanyRepository();
        MemoryListCompanyRepository memoryListCompanyRepository = new MemoryListCompanyRepository();
        DecimalFormat decimalFormat = new DecimalFormat("#,00");

        /*Company companyFortis = memoryArrayCompanyRepository.findCompany(2);*/
        Company companyFortis = memoryListCompanyRepository.findCompany(2);
        Company companyIBM = null;
        Company companyABIS = null;
        try {
            companyIBM = memoryArrayCompanyRepository.findCompany("ABIS");
            companyABIS = memoryArrayCompanyRepository.findCompany("ABIS");
        } catch (CompanyNotFoundException e) {
            throw new RuntimeException(e);
        }
        ;
        /*  Company companyTOTO = memoryArrayCompanyRepository.findCompany("ABIS");*/


        Person personJohn = new Person("John", "Doe");
        Person personMary = new Person("Mary", "Jones", companyFortis);
        Person instructor = new Person("Schillebeecks", "Sandy", companyIBM);
        /* PublicSession sessionPublic = new PublicSession*/


        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate somedate = LocalDate.parse("31/12/2025", fmt);

        PublicSession sessionPublic = new PublicSession(somedate, javaTraining, companyABIS, instructor);
        CompanySession sessionCompany = new CompanySession(somedate, javaTraining, companyABIS, instructor, 5, companyIBM);
        Consultancy serviceConsultance = new Consultancy();

        Person[] personArray = {personJohn, personMary};


        javaTraining.printInfo();
        //double prixTotal = javaTraining.calculateTotalPrice();
        //System.out.println("Le prix total est :" + prixTotal);

        companyFortis.printInfo();
/*
        System.out.println("Nombre total de person :" + Person.getCounter());
        for(Person p: personArray)
        {
          p.printInfo();
        }
        personJohn.attendCourse(javaTraining);

        personJohn.addHobby("HobbyJohn1");
        personJohn.addHobby("HObbyJohn2");

        for(String h : personJohn.getHobbies()){
            if (h != null){
                System.out.println(h);
            }
        }*/

   /*     personJohn.addHobby("HobbyJohn1");
        personJohn.addHobby("HObbyJohn2");

        personMary.addHobbies("Mary hobby1","Mary hobby2","Mary hobby3");
     */


/*        for(String h2 : personMary.getHobbies()){
            if (h2 != null){
                System.out.println(h2);
            }
        }

*/
        sessionPublic.printInfo();
        sessionCompany.printInfo();
        System.out.println(limit);

        Session[] listSessions = {sessionPublic, sessionCompany};
        for (Session s : listSessions) {
            s.printInfo();
        }
        System.out.println(limit);


        Service[] listServices = {serviceConsultance, sessionPublic, sessionCompany};
        for (Service service : listServices) {
            try {
                System.out.println("The price for the " + service.getClass().getSimpleName() + " is " + decimalFormat.format(service.calculatePrice()));
            } catch (PriceTooLowException | PriceTooHighException e) {
                System.out.println(e.getMessage());
            }
            if (service instanceof Session) {
                ((Session) service).printInfo();
            }
        }

        System.out.println(limit);

        System.out.println(companyIBM);
        sessionCompany.getOrganizer();
        sessionPublic.getOrganizer();

        System.out.println(limit);

     /*   System.out.println(companyFortis);
        System.out.println(companyIBM);
        System.out.println(companyABIS);
     System.out.println(companyTOTO);*/

        try {
            System.out.println("test Decimal :" + decimalFormat.format(sessionCompany.calculatePrice()));
        } catch (PriceTooHighException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(("on passe dans le final block"));
        }


        System.out.println(limit);
        try {
            companyFortis.requestPriceOfferForCompanySession(javaTraining, 3);
        } catch (PriceException e) {
            System.out.println(e.getMessage());
/*        } catch (PriceTooLowException e){
            System.out.println(e.getMessage());*/
        }

        System.out.println(limit);
        personJohn.addHobby("HobbyJohn1");
        personJohn.addHobby("HObbyJohn2");

        personMary.addHobbies("Mary hobby1", "Mary hobby2", "Mary hobby3");

        for (String s : personJohn.getHobbies()) {
            System.out.println(s);
        }

        for (String s : personMary.getHobbies()) {
            System.out.println(s);
        }

        System.out.println(limit);
        companyFortis.printInfo();
        Company mercedes = new Company("Mercedes", 7);
        memoryListCompanyRepository.addCompany(mercedes);
        try {
            System.out.println(memoryListCompanyRepository.findCompany("Mercedes").getName());
        } catch (CompanyNotFoundException e) {
            throw new RuntimeException(e);
        }

        sessionPublic.addEnrolment(personMary);
        Person personSteve = new Person("Sva", "Steve", companyABIS);
        sessionPublic.addEnrolment(personSteve);
        sessionPublic.printParticipantList();
        System.out.println(limit);
        System.out.println("toto");

        ArrayList<Person> abisParticipants = sessionPublic.findAbisParticipants();
        for (Person p : abisParticipants) {
            p.printInfo();
        }

        System.out.println(limit);
        AbisCompanyService abisCompanyService = new AbisCompanyService(memoryListCompanyRepository);
        System.out.println(abisCompanyService.sortAllCompaniesByName());
        System.out.println(abisCompanyService.sortAllCompaniesByCompanyNumber());

        System.out.println(limit);

        FileCompanyRepository fileCompanyRepository = new FileCompanyRepository();
        ArrayList<Company> listCompany = fileCompanyRepository.getCompanyList();
        for (Company c : listCompany) {
            System.out.println(c.getName() + ":" + c.getCompanyNumber());
        }

        System.out.println(limit);

        PrintWriter out = new PrintWriter(new FileWriter("C:\\temp\\javacourses\\NewCampanyList.txt"));
        AbisCompanyService abisCompanyServiceByFile = new AbisCompanyService(fileCompanyRepository);
        for (Company c : abisCompanyService.sortAllCompaniesByName()) {
            out.println(c.getName() + ":" + c.getCompanyNumber());

        }
        out.close();


    }
}
