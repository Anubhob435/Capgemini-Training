package src.WeeklyTests;

public class TreeMap {
    public static void main(String[] args) {

        TreeMap tm = new TreeMap();
        tm.put(3, "India");
        tm.put(1, "USA");
        tm.put(5, "China");
        tm.put(1, "India");
        tm.put(4, "Brazil");

        System.out.println(tm);

        System.out.println("======================================");

        TreeMap tm2 = new TreeMap();
        Person p1 = new Person(1, "Anmol", 30, null);
        Person p2 = new Person(2, "Rahul", 30, null);
        Person p3 = new Person(3, "Ram", 35, null);
        Person p4 = new Person(4, "Anmol", 30, null);

        tm2.put2(p1, "Maharashtra");
        tm2.put2(p2, "Delhi");
        tm2.put2(p3, "Bengal");
        tm2.put2(p4, "MP");

        System.out.println(tm2);
    }

	private void put(int i, String string) {
		// TODO Auto-generated method stub
		
	}
	private void put2(Person p4, String string) {
		// TODO Auto-generated method stub
		
	}
}