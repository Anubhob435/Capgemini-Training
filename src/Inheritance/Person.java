package src.Inheritance;

public class Person {
    int age;
    boolean gender;

    public Person() {
        // default
    }

    public Person(int age, boolean gender) {
        this.age = age;
        this.gender = gender;
    }
    public void DisplayPerson() {
    	System.out.println(age);
    	System.out.println(gender);
    }
}
