package src.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorDemo {
    public static void main(String[] args) {

        // 1️ Generic ArrayList with for-each loop
        ArrayList<String> countries = new ArrayList<>();

        countries.add("India");
        countries.add("China");
        countries.add("USA");
        countries.add("Brazil");

        for (String s : countries) {
            System.out.println(s);
        }

        System.out.println("==========================");

        // 2️ Iterator with Generic ArrayList
        Iterator<String> itr = countries.iterator();
        while (itr.hasNext()) {
            String coun = itr.next();
            System.out.println(coun);
        }

        System.out.println("==========================");

        // 3️ Non-generic ArrayList
        ArrayList al1 = new ArrayList();
        al1.add("Java");
        al1.add(100);
        al1.add(100.5);
        al1.add(true);

        Iterator itr1 = al1.iterator();
        while (itr1.hasNext()) {
            Object obj1 = itr1.next();
            System.out.println(obj1);
        }

        System.out.println("=========================");

        // 4️ ListIterator (Forward & Backward)
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(100);
        list3.add(200);
        list3.add(300);

        ListIterator<Integer> itr3 = list3.listIterator();

        // Forward direction
        while (itr3.hasNext()) {
            Integer num = itr3.next();
            System.out.println(num);
        }

        System.out.println("=============================");

        // Backward direction
        while (itr3.hasPrevious()) {
            Integer num = itr3.previous();
            System.out.println(num);
        }
    }
}