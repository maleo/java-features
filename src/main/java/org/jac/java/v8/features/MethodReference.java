package org.jac.java.v8.features;

import java.util.ArrayList;
import java.util.List;

public class MethodReference {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("Jennifer");
		names.add("Peggy");
		names.add("Julian");
		names.forEach(System.out::println);
	}
	
}
