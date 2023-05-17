package be.abis.courseadmin.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class PublicSession extends Session {
    ArrayList<Person> courseParticipant = new ArrayList<Person>();

    public PublicSession() {
    }

    public PublicSession(LocalDate startDate, Course course, Company location, Person instructor) {
        super(startDate, course, location, instructor);
    }

    public ArrayList<Person> getCourseParticipant() {
        return courseParticipant;
    }

    @Override
    public double calculatePrice() {
        return 800.00;
    }

    @Override
    public void getOrganizer() {
        System.out.println("retour de l'oranisateur à partir de PublicSession");
    }

    public void addEnrolment(Person person) {
        courseParticipant.add(person);
    }

    public void addEnrolments(Person... person) {
        for (Person pers : person) {
            courseParticipant.add(pers);
        }
    }

    public void cancelEnrolment(String firstname) {
        for (Person pers : courseParticipant) {
            if (pers.getFirstName().equals(firstname)) {
                courseParticipant.remove(pers);
            }

        }
    }

    public void printParticipantList() {

        for (Person p : courseParticipant) {
            /*System.out.println(p.getFirstName());*/
            p.printInfo();
        }
    }

    public ArrayList<Person> findAbisParticipants() {
        ArrayList<Person> AbisParticipant = new ArrayList<Person>();
      /* for (Person p : courseParticipant) {
            if (p.getCompany().getName().equals("ABIS")){
                AbisParticipant.add(p);

            }
        } */
        courseParticipant.stream()
                .filter(s -> s.getCompany().getName().equals("ABIS"))
                .forEach(p ->AbisParticipant.add(p));

        return AbisParticipant;
    }
}
