package model;

import java.util.ArrayList;
import java.util.List;

import model.Team;
import model.Match;

public class Championship {
	private List <Match> lstMatches;
	private List <Score> scoreboard;
	
	
	//Constructors
	public Championship() {
		super();
		this.setLstMatches();
		this.setLstScoreboard();
	}

	//Setters, Getters, ToString & Equals
	public List<Match> getLstMatches() {
		return lstMatches;
	}

	public void setLstMatches() {
		this.lstMatches = new ArrayList<Match>();
	}

	public List<Score> getLstScoreBoard() {			 
		return scoreboard;
	}

	public void setLstScoreboard() {
		this.scoreboard = new ArrayList<Score>();
	}
	
	@Override
	public String toString() {
		return "Championship [lstMatches=" + lstMatches + ", lstScoreboard=" + scoreboard + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Championship other = (Championship) obj;
		if (lstMatches == null) {
			if (other.lstMatches != null)
				return false;
		} else if (!lstMatches.equals(other.lstMatches))
			return false;
		if (scoreboard == null) {
			if (other.scoreboard != null)
				return false;
		} else if (!scoreboard.equals(other.scoreboard))
			return false;
		return true;
	}
	
	//General methods
	public boolean addTeamToScoreboard(String teamName) {
		return this.scoreboard.add(new Score(teamName, 0));		
	}
	
	public boolean addMatch(String line) {
		Match currentMatch = this.parseMatch(line);
		return this.lstMatches.add(currentMatch);
	}
	
	public Match parseMatch(String line) {	
		//lineExample = ["+Lions 3, Snakes 3"]

		Team team1;
		Team team2;
		
		String[] partLine = line.split(","); 
		//partLineExample 	=	["+Lions 3"] , [" Snakes 3"]

		String[] teamPart = partLine[0].split("(?<=\\D)(?=\\d)");
		//	[["+Lions "] , ["3"]]	, [[" Snakes "] , ["3"]]
		
		team1 = new Team(teamPart[0].trim().substring(1),Integer.parseInt(teamPart[1]));		
		
		
		teamPart= partLine[1].split("(?<=\\D)(?=\\d)");
		team2 = new Team(teamPart[0].trim(), Integer.parseInt(teamPart[1]));
		
		return new Match(team1, team2);
	}
	
	public void setPoints(Team currentTeam,int points) {
		
			String nameTeam = currentTeam.getName();
			int indexTeam = this.bringIndex(nameTeam);	
			//index of the previous score of the team or the index to store a new entry if it doens't exist
			
			int lastScore = findScore (indexTeam);

			Score newScore = new Score(nameTeam, lastScore + points );
			
			this.scoreboard.set(indexTeam, newScore);
		
	}
	
	public int findScore(int teamIndex) {
		int score;
		
		if (teamIndex == this.scoreboard.size()){	//if true last score doesn't exist
			 score = 0;
		}
		else{
			score = this.scoreboard.get(teamIndex).getScore();
		}
		
		return score;	
	}
			
	public int bringIndex(String teamName) {
		boolean founded= false;
		int index = 0;
		
		while (!founded && index<this.scoreboard.size()){
			Score currentTeamScore = this.scoreboard.get(index);
			if (currentTeamScore.getTeamName().contentEquals(teamName)){
				founded = true;
				break;
			}
			index++;
		}
		if(founded == false){
			index = this.scoreboard.size();
			this.addTeamToScoreboard(teamName);
		}
		return index;
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	