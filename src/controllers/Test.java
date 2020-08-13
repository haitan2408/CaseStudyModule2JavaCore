package controllers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test {
    public static void main(String[] args)
    {
        // creating an Set
        Set<String> arr = new HashSet<>();

        // using add() to initialize values
        // [1, 2, 3, 4]
        arr.add("hai");
        arr.add(new String("hai"));
        arr.add("hai");
        arr.add("hoa");
        arr.add("huy");
        arr.add("Huy");
        arr.add("Hai");

        // print Set
        System.out.println("Set: " + arr);

        // Get the hashCode value
        // using hashCode() value
        System.out.println("HashCode value: " + arr.hashCode());
        Iterator<String> it = arr.iterator();
        while(it.hasNext()) {
            String value = it.next();
            System.out.println(value.hashCode());
        }
    }
    }
