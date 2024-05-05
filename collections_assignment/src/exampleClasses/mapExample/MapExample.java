package exampleClasses.mapExample;
import java.util.HashMap;
import java.util.Map;
import exampleClasses.outputFunctions;

public class MapExample {
	
	
	private static Map<Integer, Integer> quadraticMap = new HashMap<Integer, Integer>();
	private static Map<Integer, Integer> cubicMap = new HashMap<Integer, Integer>();
	private static Map<Integer, Integer> arithmeticMap = new HashMap<Integer, Integer>(); // map used when adding or subtracting
	
	public static void checkForXIntercept(Map<Integer, Integer> map) {
		
		if (map.containsValue(0)) {
			System.out.println("This function has an X-intercept while x is an element of the integers.");
		} else {
			System.out.println("This function does not have an X-intercept while X is an element of the integers.");
		}
		
		outputFunctions.delay(2000);
	}
	
	
	public static void addQuadraticPoints() {
		
		System.out.println("\nThe points of the quadratic function are:");
		outputFunctions.delay(1000);
		
		
		for (int i = -5 ; i <= 5 ; i++) {
			
			quadraticMap.put(i, ((int)Math.pow(i, 2)) + 5);
			
			System.out.printf("(%d, %d),%n", i, quadraticMap.get(i));
			outputFunctions.delay(500);
		}
		
		checkForXIntercept(quadraticMap);
		
	}
	
	
	public static void addCubicPoints() {
		
		System.out.println("\nThe points of the cubic function are:");
		outputFunctions.delay(1000);
		
		
		for (int i = -5 ; i <= 5 ; i++) {
			
			cubicMap.put(i, -1 * ((int)Math.pow(i + 3, 3)));
			
			System.out.printf("(%d, %d),%n", i, cubicMap.get(i));
			outputFunctions.delay(500);
		}
		
		checkForXIntercept(cubicMap);
	}
	
	public static void arithmeticOperations(int sign) { // sign is used to determine if adding or subtracting
		
		outputFunctions.delay(1000);

		for (int i = -5 ; i <= 5 ; i++) {
			
			arithmeticMap.put(i, quadraticMap.get(i) + sign * cubicMap.get(i));
			
			System.out.printf("(%d, %d),%n", i, arithmeticMap.get(i));
			outputFunctions.delay(500);
			
		}
	
		checkForXIntercept(arithmeticMap);
		
		arithmeticMap.clear(); // removing all entries to be reused
	}
	
	public static void runExample() {
		
		System.out.println("This exercise will display the points of two functions using the java Map class, as well as add and subtract the functions.");
		outputFunctions.delay(2000);
		System.out.println("The first function is f(x) = (x)^2 + 5 ");
		outputFunctions.delay(2000);
		System.out.println("The second function is f(x) = -(x - 3)^3");
		
		System.out.println("The domain that will be compared is [-5, 5] while X is an element of the integers.");
		
		outputFunctions.delay(5000);
		addQuadraticPoints();
		addCubicPoints();
		
		System.out.println("\nThe points of the functions added are:");
		arithmeticOperations(1);
		System.out.println("\nThe points of the functions subtracted are:");
		arithmeticOperations(-1);
	}
}
