package org.example;

public class Main {
    public static void main(String[] args) {
        Course chemistry = new Course("Sciences", "Chemistry 101", 3,
                new Department("Sciences"));
        Course history = new Course("History", "History 101", 2,
                new Department("Sociology"));

        chemistry.addAssignment("Fireworks", 3.0, 100);
        chemistry.addAssignment("Fire", 1.0, 100);
        history.addAssignment("Ancient Egypt", 2.5, 100);

//        Student Emily = new Student("AB002", "Emily", Gender.FEMALE, new Address(5,
//                "-", "-", "-", "h3x3r7", "-"), "Sciences");
//        Student Jarry = new Student("AB001", "Jarry", Gender.MALE, new Address(5,
//                "-", "-", "-", "h3x3r7", "-"), "History");
//        System.out.println(Emily);

    }
}
