package timeAndSpaceComplexity;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Map_InsertionAndDeletion {

	/*
	 * Verify the time complexity for Insertion and deletion
	 */
	public static void main(String[] args) {
		Map<Integer, String> hashMap = new HashMap<>();
		Map<Integer, String> treeMap = new TreeMap<>();

		// Declare the startTime and endTime variables
		long startTime;
		long endTime;

		// Verify HashMap insertion time
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			hashMap.put(i, "i");
		}
		endTime = System.nanoTime();
		System.out.println("HashMap insertion Time " + (endTime - startTime) + " ns");

		// Verify TreeMap insertion time
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			treeMap.put(i, "i");
		}
		endTime = System.nanoTime();
		System.out.println("TreeMap insertion Time " + (endTime - startTime) + " ns");

		// Verify HashMap access time
		startTime = System.nanoTime();
		hashMap.get(100000);
		endTime = System.nanoTime();
		System.out.println("HashMap access Time " + (endTime - startTime) + " ns");

		// Verify TreeMap access time
		startTime = System.nanoTime();
		treeMap.get(100000);
		endTime = System.nanoTime();
		System.out.println("treeMap access Time " + (endTime - startTime) + " ns");

		// Verify HashMap deletion time
		startTime = System.nanoTime();
		hashMap.remove(99999);
		endTime = System.nanoTime();
		System.out.println("hashMap deletion Time " + (endTime - startTime) + " ns");
		
		// Verify treeMap deletion time
		startTime = System.nanoTime();
		treeMap.remove(99999);
		endTime = System.nanoTime();
		System.out.println("treeMap deletion Time " + (endTime - startTime) + " ns");
	}
}
