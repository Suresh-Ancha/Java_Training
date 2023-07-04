package timeAndSpaceComplexity;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Set_InsertionAndDeletion {
	public static void main(String[] args) {

		Set<Integer> hashSet = new HashSet<>();
		Set<Integer> treeSet = new TreeSet<>();

		// Declare startTime and endTime variables

		long startTime;
		long endTime;

		// Verify hashSet insertion time
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			hashSet.add(i);
		}
		endTime = System.nanoTime();
		System.out.println("HashSet insertion time " + (endTime - startTime) + " ns");

		// Verify TreeSet insertion time
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			treeSet.add(i);
		}
		endTime = System.nanoTime();
		System.out.println("TreeSet insertion time " + (endTime - startTime) + " ns");
		
		// Verify HashSet access time
		startTime = System.nanoTime();
		hashSet.remove(99999);
		endTime = System.nanoTime();
		System.out.println("HashSet deletion time " + (endTime - startTime) + " ns");
		
		// Verify TreeSet access time
		startTime = System.nanoTime();
		treeSet.remove(99999);
		endTime = System.nanoTime();
		System.out.println("TreeSet deletion time " + (endTime - startTime) + " ns");
	}

}
