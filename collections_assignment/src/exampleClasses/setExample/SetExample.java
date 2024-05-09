package exampleClasses.setExample;
import exampleClasses.outputFunctions;
import java.util.Set;
import java.util.HashSet;

public class SetExample {
	
	public static void runExample() {
		
		System.out.println("This example will create two sets with a list of words and then compare which words are the same, which are different, and combine the words into a single set.");
		outputFunctions.delay(1000);
		
		Set<String> firstSet = new HashSet<String>();
		
		firstSet.add("Java");
		firstSet.add("Python");
		firstSet.add("C#");
		firstSet.add("C++");
		
		System.out.println("First set: " + firstSet);
		
		outputFunctions.delay(1000);
		
		Set<String> secondSet = new HashSet<String>();
		
		secondSet.add("Turtle");
		secondSet.add("Python");
		secondSet.add("Java");
		secondSet.add("Cappuccino");
		
		System.out.println("Second set: " + secondSet);
		
		outputFunctions.delay(1000);
		
		Set<String> joinedSet = new HashSet<String>();
		
		joinedSet.addAll(firstSet); // copies first set
		joinedSet.retainAll(secondSet); // only keeps what is similar
		
		System.out.println("Words that are similar: " + joinedSet);
		
		outputFunctions.delay(1000);
		joinedSet.clear(); // empties set
		
		joinedSet.addAll(firstSet); // copies first set
		joinedSet.removeAll(secondSet); // only keeps what is different
		
		System.out.println("Words that are only in the first set: " + joinedSet);
		
		outputFunctions.delay(1000);
		joinedSet.clear(); // empties set
		
		joinedSet.addAll(firstSet); // copies first set
		joinedSet.addAll(secondSet); // adds the second set elements
		
		System.out.println("All words present in both: " + joinedSet);
		
		
		
		
		
	}
}
