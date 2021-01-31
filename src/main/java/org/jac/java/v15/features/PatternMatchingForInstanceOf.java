package org.jac.java.v15.features;

/**
 * Enhance the Java programming language with pattern matching for the instanceof operator.
 * Pattern matching allows common logic in a program, namely the conditional extraction of components from objects,
 * to be expressed more concisely and safely. This is a preview language feature in JDK 15.
 */
public class PatternMatchingForInstanceOf {

    public static void main(String[] args) {
        Object stringObject = "Hello World";
        printIfIsString(stringObject);
        printIfIsStringWithPatternMatch(stringObject);
        Object numberObject = 2021;
        printIfIsString(numberObject);
        printIfIsStringWithPatternMatch(numberObject);
    }


    public static void printIfIsString(Object object) {
        if (object instanceof  String) {
            String str = (String) object;
            System.out.println(str);
        }
    }

    public static void printIfIsStringWithPatternMatch(Object object) {
        if (object instanceof String str) {
            System.out.println(str);
        }
    }

}

