package dsa.Revision;

public class ComparingObjects {
    public static void main(String[] args) {
        Customer[] obj = new Customer[5];

        obj[0] = new Customer(100, "Soumyojit");
        obj[1] = new Customer(101, "Rahul");
        obj[2] = new Customer(101, "Ananya");
        obj[3] = new Customer(103, "Priya");
        obj[4] = new Customer(104, "Arjun");

        for (int i = 0; i < obj.length; i++) {
            for (int j = 0; j < obj.length - i - 1; j++) {
                if (obj[j].networth < obj[j + 1].networth) {
                    Customer temp = obj[j + 1];
                    obj[j + 1] = obj[j];
                    obj[j] = temp;
                } else if (obj[j].networth == obj[j + 1].networth) {
                    if (obj[j].name.compareTo(obj[j + 1].name) > 0) {
                        Customer temp = obj[j + 1];
                        obj[j + 1] = obj[j];
                        obj[j] = temp;
                    }
                }
            }
        }

        for (Customer customer : obj) {
            System.out.println(customer);
        }
    }
}