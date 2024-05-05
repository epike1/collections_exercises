package exampleClasses.queueExample;
import java.util.Queue;
import java.util.LinkedList;
import exampleClasses.outputFunctions;
import java.util.Scanner;


public class QueueExample {
	
	public static int getRandomInteger() {
		return (int)(Math.random() * 20) + 1;
	}
	
	public static int getSumOfEven(Queue<Integer> numQueue) {
		
		int sum = 0;
		
		int size = numQueue.size(); // cannot be put in for loop statement as queue decreases in size over time
		
		for (int i = 0 ; i < size ; i++) {
			
			if (numQueue.peek() % 2 == 0) {
				int num = numQueue.poll(); // in this case, both poll() and remove() work, the only difference is that poll() returns null when queue is empty
				sum += num;
				System.out.printf("Added %d.%n", num);
			} else {
				System.out.printf("Removed %d.%n", numQueue.remove());
			}
			
			outputFunctions.delay(500);
		}
		
		return sum;
	}
	
	public static void runExample() {
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("This program will make a queue of random numbers, and remove every odd number from the list and output the sum of what is left.");
		outputFunctions.delay(1500);
		Queue<Integer> numQueue = new LinkedList<Integer>();
		
		boolean runAgain = true;
		
		do {
			
			for (int i = 0 ; i < 15 ; i++) {
				numQueue.add(getRandomInteger());
			}
			
			System.out.println("\nCurrent Queue: " + numQueue);
			outputFunctions.delay(1500);
			
			System.out.printf("The final sum of all even numbers in the queue is %d.%n%n", getSumOfEven(numQueue));
			outputFunctions.delay(2000);
			
			numQueue.clear();
			
			do {
				System.out.print("Create a new queue of numbers? (Y/N): ");
				String answer = input.nextLine().trim().toLowerCase();
				
				if (answer.equals("y")) {
					break;
				} else if (answer.equals("n")) {
					runAgain = false;
					break;
				} else {
					System.out.println("Invalid answer given.");
				}
				
				outputFunctions.delay(1000);
			
			} while (true);
			
		} while (runAgain == true);
		
		input.close();
	}
	
}
