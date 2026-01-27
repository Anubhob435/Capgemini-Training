package src.WeeklyTests;

public class Person1 implements Comparable<Person> {
	int id;
	String name;
	int age;

	public Person1(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Person p) {
		if (this.id > p.id) {
			return -1;
		} else if (this.id < p.id) {
			return 1;
		}
		return 0;
	}
}