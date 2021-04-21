package org.jac.java.v16.feature;

public class PatternMatchForInstanceOf {
    public static void main(String[] args) {
        CharSequence cs = "12324";
        //JEP 394
        if (cs instanceof  String s) {
            System.out.println(s);
        }
    }
}
