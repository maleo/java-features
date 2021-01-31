package org.jac.java.v15.features;

import java.io.Serializable;
import java.util.Arrays;

/**
 * A record class is a shallowly immutable, transparent carrier for a fixed set of values, called the record components.
 * The Java™ language provides concise syntax for declaring record classes, whereby the record components are declared
 * in the record header. The list of record components declared in the record header form the record descriptor.
 *
 */
public class Records {

    public static void main(String[] args) {
        Point p1 = new Point(1,2);
        //toString
        System.out.println("p1.toString(): " + p1);

        //Equality
        Point p2 = new Point(1, 2);
        System.out.println("p1 == p2: " + (p1 == p2));
        System.out.println("p1.equals(p2): " + p1.equals(p2));

        //Invoking self-defined instance method
        System.out.println(p2.toJson());
        System.out.println(p1.toJson());

        //Introspection
        //1. java.lang.class.isRecord method;
        System.out.println("p1.getClass().isRecord(): " + p1.getClass().isRecord());
        System.out.println("Record components:");
        //2. java.lang.class.getRecordComponents()
        Arrays.asList(Point.class.getRecordComponents()).forEach(System.out::println);
    }
}

record Point(int x, int y) implements Serializable {
    //You can't define instance field in record
    //int z;


    //You can define instance method in record
    public String toJson() {
        return "{x:" + x + ",y:" + y +"}";
    }
}