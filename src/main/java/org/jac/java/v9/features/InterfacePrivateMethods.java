package org.jac.java.v9.features;

public class InterfacePrivateMethods implements InterfaceWithPrivateMethods {
}

interface InterfaceWithPrivateMethods {

    static void staticPrivateMethod() {
        System.out.println("private static method in an interface");
    }

    /**
     * It can only be declared as private
     */
    private void instancePrivateMethod() {

    }

}
