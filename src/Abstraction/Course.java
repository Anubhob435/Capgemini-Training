package src.Abstraction;

//Abstract class corresponding to 'Course (a)'
abstract class Course {
 protected String name;

 public Course(String name) {
     this.name = name;
 }

 // Concrete method 'courseInfo() (c)'
 public void courseInfo() {
     System.out.println("Course Name: " + name);
 }

 // Abstract method 'coursePrice (a)'
 public abstract double coursePrice();
}