package model;

public class Score {
	private String teamName;
	private int score;
	
	//Constructors
	public Score(String teamName, int score) {
		super();
		this.teamName = teamName;
		this.score = score;
	}
	
	//Getters, Setters, ToString & Equals
	public String getTeamName() {
		return teamName;
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Score [teamName=" + teamName + ", score=" + score + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (score != other.score)
			return false;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		return true;
	}
		
	//General Methods
	
	
	
}
