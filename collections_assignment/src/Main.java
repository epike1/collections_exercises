// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import exampleClasses.arrayListExample.*;
import exampleClasses.linkedListExample.*;
import exampleClasses.mapExample.*;
import exampleClasses.queueExample.*;
import votingSystemClasses.*;
import java.util.ArrayList;
public class Main {

	public static void runVotingSystem() {
		
		ArrayList<Candidate> candidateList = VotingSystem.getCandidates();
		
		VotingSystem.askForVotes(candidateList);
		
		VotingSystem.determineWinner(candidateList);
	}
	
	
    public static void main(String[] args) {

        //ArrayListExample.runExample(); // examples separated into classes to improve organization
        //LinkedListsExample.runExample();
    	//QueueExample.runExample();
    	//MapExample.runExample();
    	runVotingSystem();
    }
}