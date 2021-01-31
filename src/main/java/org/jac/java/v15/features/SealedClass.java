package org.jac.java.v15.features;

/**
 * Sealed class gives the developer fine grained control over which class/interface can extends it.
 *
 */
public sealed class SealedClass permits NonSealedClass, SealedSubClass {
}


/**
 * If a class extends a Sealed Class, it must be decorated by any of the following keywords:
 * sealed
 * non-sealed
 * final
 */
non-sealed class NonSealedClass extends SealedClass {

}

/**
 * If a sealed class, say SealedSubClass extends another sealed class, say SealedClass,
 * then SealedSubClass must have a subclass, which also needs to be decorated by
 * sealed/non-sealed/final
 */
sealed class SealedSubClass extends SealedClass  permits FinalClass {

}


final class FinalClass extends SealedSubClass {

}

