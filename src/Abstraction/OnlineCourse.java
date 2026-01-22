package src.Abstraction;

//Concrete class corresponding to 'OnlineCourse (c)'
class OnlineCourse extends Course {
 protected String platformName;
 protected double platformCommission; // Added to support the 'PlatformComm' logic

 public OnlineCourse(String name, String platformName, double platformCommission) {
     super(name);
     this.platformName = platformName;
     this.platformCommission = platformCommission;
 }

 // Implementation of 'coursePrice() (c)'
 // Logic from board: returns PlatformComm
 @Override
 public double coursePrice() {
     return platformCommission;
 }
 
 @Override
 public void courseInfo() {
     super.courseInfo();
     System.out.println("Platform: " + platformName);
 }
}