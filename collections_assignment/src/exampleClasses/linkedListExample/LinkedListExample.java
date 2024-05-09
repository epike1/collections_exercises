package exampleClasses.linkedListExample;

import java.util.LinkedList;
import exampleClasses.outputFunctions;
import java.util.Collections;

public class LinkedListExample {

	public static int getRandomInteger() {
		return (int)(Math.random() * 50) + 1;
	}
	
    public static void runExample() {

        System.out.println("This program will create a linked list of random integers, sort the list, and then alternate between getting the first and last item in the list and removing them until the list is empty.");
        outputFunctions.delay(1500);
        
        LinkedList<Integer> integerList = new LinkedList<Integer>();
        
        for (int i = 0 ; i < 10 ; i++) {
        	
        	integerList.add(getRandomInteger());
        }
        
        System.out.println("Original list: " + integerList);
        outputFunctions.delay(1500);
        Collections.sort(integerList);
        System.out.println("Sorted list " + integerList);
        outputFunctions.delay(1500);
        
        do {
        	
        	System.out.println("Getting first: " + integerList.getFirst());
        	integerList.removeFirst();
        	outputFunctions.delay(250);
        	
        	if (integerList.size() <= 0) {
        		break;
        	}
        	
        	System.out.println("Getting last: " + integerList.getLast());
        	integerList.removeLast();
        	outputFunctions.delay(250);
        	
        } while (integerList.size() > 0);
        
        
        System.out.println("List is now empty.");
        
    }
}
