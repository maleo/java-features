package org.jac.java.v9.features;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class FactoryMethodsForImmutable {

    public static void main(String[] args) {

        //Empty immutable List
        List emptyList = List.of();

        //Non-empty immutable List
        List<String> nonEmptyImmutableList = List.of("One", "Two");

        //Empty immutable Set
        Set emptySet = Set.of();

        //Non-empty immutable Set
        Set<Integer> nonEmptyImmutableSet = Set.of(1, 2, 3, 4);
        System.out.println(nonEmptyImmutableSet);

        //Empty immutable Map
        Map emptyMap = Map.of();

        //Non-empty immutable Map
        Map nonEmptyImmutableMap = Map.of(1,"one", 2, "two", 3, "three");
        System.out.println(nonEmptyImmutableMap);

    }

}
