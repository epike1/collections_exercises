package votingSystemClasses;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public interface VotingSystem {

	public static void askForVotes(ArrayList<Candidate> candidateList) {
		
		Scanner input = new Scanner(System.in);
		int vote = 0;
		boolean invalidInput;
		
		do {
			
			invalidInput = false;
			
			System.out.println("\nPlease vote for one of the following candidates (0 to stop):");
			
			for (int i = 0 ; i < candidateList.size() ; i++) {
				System.out.printf("%d. %s%n", i + 1, candidateList.get(i).getName());
			}
			
			System.out.print("Enter a vote: ");
			
			try {
				
				vote = input.nextInt();
				
			} catch (Exception e) {
				
				System.out.println("Invalid type. Must be an integer.");
				input.next();
				invalidInput = true;
			}
			
			if(vote == 0) {
				
			} else if (vote >= 1 && vote < candidateList.size()) {
				incrementVote(candidateList.get(vote));
			} else {
				System.out.println("Unable to determine candidate.");
			}
			
		} while (vote != 0);
		
		
		input.close();
	}
	
	public static void incrementVote(Candidate candidate) {
		candidate.setVotes(candidate.getVotes() + 1);
		System.out.printf("Vote added to %s.", candidate.getName());
	}
	
	public static void determineWinner(ArrayList<Candidate> candidateList) {
		
		LinkedList<Candidate> winners = new LinkedList<Candidate>(); // linked list made to add winners to as there could be some with the same number of votes
		
		int highestVote = 0;
		
		for (Candidate i : candidateList) {
			
			if (i.getVotes() >= highestVote) {
				highestVote = i.getVotes();
				winners.add(i);
				
				for (Candidate x : winners) { // removing any below highest vote
				
					if (x.getVotes() < highestVote) {
						winners.remove(x);
					}
				}
			}
		}
		
		System.out.println("\nThe candidates are:");
		
		for (Candidate i : candidateList) {
			System.out.printf("%s: %d%n", i.getName(), i.getVotes());
		}
		
		System.out.println("\nThe winners are:");
		
		for (Candidate i : winners) {
			System.out.printf("%s%n", i.getName());
		}
		
	}
	
	public static ArrayList<Candidate> getCandidates() {
		
		
		ArrayList<Candidate> candidateList = new ArrayList<Candidate>();
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of candidates: ");
		int numOfCandidates = 0;
		
		do {
			
			try {
				numOfCandidates = input.nextInt();
			} catch (Exception e) {
				System.out.println("Invalid input. Must be an integer.");
				input.next();
				continue;
			}
			
		} while (false);
				
		input.nextLine();
		for (int i = 0 ; i < numOfCandidates ; i++) {
			
			System.out.print("Enter a name: ");
			candidateList.add(new Candidate(input.nextLine()));
			
		}
		
		input.close();
		return candidateList;
	}
}
