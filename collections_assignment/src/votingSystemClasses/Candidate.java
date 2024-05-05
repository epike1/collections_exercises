package votingSystemClasses;

public class Candidate {
	
	private String name;
	private int votes = 0;
	
	public Candidate(String name) {
		setName(name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setVotes(int votes) {
		this.votes = votes;
	}
	
	public int getVotes() {
		return votes;
	}
}
