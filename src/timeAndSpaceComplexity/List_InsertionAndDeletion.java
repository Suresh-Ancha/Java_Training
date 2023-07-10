package timeAndSpaceComplexity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class List_InsertionAndDeletion {
	/*
	 * Verify the time complexity for Insertion and deletion
	 */
	public static void main(String[] args) {

		List<Integer> arrayList = new ArrayList<>();
		List<Integer> linkedList = new LinkedList<>();

		// Declare the startTime and endTime variables
		long startTime;
		long endTime;

		// Verify ArrayList insertion time
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			arrayList.add(i);
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList Insertion Time: " + (endTime - startTime) + " ns");

		// Verify LinkedList insertion time
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			linkedList.add(i);
		}
		endTime = System.nanoTime();
		System.out.println("Linked Insertion Time: " + (endTime - startTime) + " ns");

		// Verify ArrayList access time
		startTime = System.nanoTime();
		arrayList.get(99999);
		endTime = System.nanoTime();
		System.out.println("ArrayList access time " + (endTime - startTime) + " ns");

		// Verify LinkedList access time
		startTime = System.nanoTime();
		linkedList.get(99999);
		endTime = System.nanoTime();
		System.out.println("LinkedList access time " + (endTime - startTime) + " ns");

		// Verify ArrayList deletion time
		startTime = System.nanoTime();
		arrayList.remove(99999);
		endTime = System.nanoTime();
		System.out.println("ArrayList deletion time " + (endTime - startTime) + " ns");
		
		// Verify linkedList deletion time
		startTime = System.nanoTime();
		linkedList.remove(99999);
		endTime = System.nanoTime();
		System.out.println("LinkedList deletion time " + (endTime - startTime) + " ns");
	
	}
}
