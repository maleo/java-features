package org.jac.java.v11.features;

import java.util.function.Predicate;

/**
 *
 * Java 11 added few useful APIs to the commonly used String class
 *
 */
public class StringMethods {


    public static void main(String[] args) {

        /**
         * repeat
         * Repeat method repeats the string content
         */
        String repeatIt = "repeat it ";
        System.out.println(repeatIt.repeat(2) + " twice");

        /**
         *  strip
         *  Remove leading and trailing white spaces
         *  The difference between strip and trim:
         *  strip is aware of unicode whitespace, while trim is not.
         */
        String textWithSpaces = "\n\t  hello   \u2005";
        System.out.println(textWithSpaces.trim().equals("hello   \u2005"));
        System.out.println(textWithSpaces.strip().equals("hello"));

        /**
         * isBlank
         * returns true if the string is empty or contains only whitespace
         * difference between isBlank and isEmpty
         * isBlank is aware of unicode whitespace character.
         */
        System.out.println("\n\t\u2005  ".isBlank());
        System.out.println("\n\t\u2005  ".isEmpty());
        System.out.println("\n\t  ".isBlank());

        /**
         *
         * lines
         * returns a stream of lines extracted from the string, separated by line terminators
         *
         */
        String multilineStr = "This is\n \n a multiline\n string.";
        long lineCount = multilineStr.lines().filter(Predicate.not(String::isBlank)).count();
        System.out.println("lineCount: " + lineCount);

    }
}
