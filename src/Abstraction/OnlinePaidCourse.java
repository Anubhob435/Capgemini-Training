package src.Abstraction;

//Concrete class corresponding to 'OnlinePaidCourse (c)'
class OnlinePaidCourse extends OnlineCourse {
 private double courseFee;

 public OnlinePaidCourse(String name, String platformName, double platformCommission, double courseFee) {
     super(name, platformName, platformCommission);
     this.courseFee = courseFee;
 }

 @Override
 public double coursePrice() {
  
     return super.coursePrice() + courseFee;
 }

 @Override
 public void courseInfo() {
     super.courseInfo();
     System.out.println("Additional Course Fee: $" + courseFee);
 }
 public class Main {
	    public static void main(String[] args) {

	        System.out.println("--- Online Course (Free/Base) ---");
	        OnlineCourse freeCourse = new OnlineCourse("Intro to Java", "Udemy", 10.0);
	        freeCourse.courseInfo();
	        System.out.println("Total Price: $" + freeCourse.coursePrice());

	        System.out.println();

	        System.out.println("--- Online Paid Course ---");
	        OnlinePaidCourse paidCourse = new OnlinePaidCourse("Advanced Java", "Coursera", 15.0, 100.0);
	        paidCourse.courseInfo();
	        System.out.println("Total Price: $" + paidCourse.coursePrice());
	    }
	}
 
}