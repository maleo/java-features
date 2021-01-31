package org.jac.java.v11.features;

public class Unicode10 {

    public static void main(String[] args) {
        String codepoint = "U+1F92A";   // crazy face
        System.out.println(convertCodePoints(codepoint));
    }

    static char[] convertCodePoints(String codePoint) {
        Integer i = Integer.valueOf(codePoint.substring(2), 16);
        char[] chars = Character.toChars(i);
        return chars;

    }

}
