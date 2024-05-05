package exampleClasses;

import java.util.concurrent.TimeUnit;

public interface outputFunctions {
	
	public static void delay(int time) {
		
		try {
			TimeUnit.MILLISECONDS.sleep(time);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
	}

}
