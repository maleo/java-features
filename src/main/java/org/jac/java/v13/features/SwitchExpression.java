package org.jac.java.v13.features;

/**
 * With JDK 13, there have been a bunch of changes to the switch expression:
 * 1. We used to use break, now it is preferrable to use yield;
 * 2. We can also use arrow;
 */
public class SwitchExpression {


    public static int traditionalSwitch(String text) {
        int result = 0;
        switch (text) {
            case "yes":
            case "ok":
                result = 1;
                break;
            case "no":
                result = -1;
                break;
            default:
                result = 0;

        }
        return result;
    }

    /**
     * Switch Expression with yield
     * @param text
     * @return
     */
    public static int switchExpressionWithYield(String text) {
        return switch (text) {
            case "yes", "ok":
                yield 1;
            case "no":
                yield -1;
            default:
                yield  0;
        };
    }

    /**
     * Switch Expression with arrow
     * @param text
     * @return
     */
    public static int switchExpressionWithArrow(String text) {
        return switch(text) {
            case "yes", "ok" -> 1;
            case "no" -> -1;
            default -> 0;
        };
    }

}

