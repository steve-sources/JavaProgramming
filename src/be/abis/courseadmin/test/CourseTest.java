package be.abis.courseadmin.test;

import be.abis.courseadmin.model.Course;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Course javaTraining = new Course("Java Programming",2,250.0);
    }

    @org.junit.jupiter.api.Test
    void setPricePerDay() {
      //  assertEquals((valeur,javaTraining));
    }

    @org.junit.jupiter.api.Test
    void getPricePerDay() {
    }
}