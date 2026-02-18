package dsa.Revision;

public class Customer {

    int networth;
    String name;

    Customer(int networth, String name) {
        this.networth = networth;
        this.name = name;
    }

    @Override
    public String toString() {
        return networth + " " + name;
    }
}