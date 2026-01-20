package src.ObjectDemo;

public class Student {
		int id;
		String name ;
		double percentage;

		public Student(int id , String name, double percentage) {
		this.id = id;
		this. name = name;
		this.percentage = percentage;
		}
		
		public boolean equals(Object o) {
			
			Student s = (Student)o;
			
			if(this.id == s.id) {
				return true;
			}
			return false;
		}
		
		public static void main(String[] args) {
			
			Student s1 = new Student(1,"Sourab", 80.0);
			Student s2 = new Student(1,"Sourab", 80.0);
			
			System.out.println(s1 == s2);
			System.out.println(s1.equals(s2));
		}
	

}
