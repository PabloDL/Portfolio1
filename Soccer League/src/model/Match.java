package model;

import model.Team;

public class Match {
	private Team team1;
	private Team team2;
	
	//Constructors
	public Match(Team team1, Team team2) {
		super();
		this.team1 = team1;
		this.team2 = team2;
	}

	//Getters, Setters, ToString & Equals
	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	@Override
	public String toString() {
		return "Match [team1=" + team1 + ", team2=" + team2 + "]";
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Match other = (Match) obj;
		if (team1 == null) {
			if (other.team1 != null)
				return false;
		} else if (!team1.equals(other.team1))
			return false;
		if (team2 == null) {
			if (other.team2 != null)
				return false;
		} else if (!team2.equals(other.team2))
			return false;
		return true;
	}
	
	//General methods
	public Team bringWinner() {
		//returns null if it's a tie

		Team winner = null;	
		int t1Goals = this.getTeam1().getGoals();
		int t2Goals = this.getTeam2().getGoals();
		
		if (t1Goals > t2Goals){
			winner = this.team1;
		}
		else if (t2Goals > t1Goals){
			winner = this.team2;
		}
		
		return winner;
	}
	
	public Team bringLoser() {
		Team winner = this.bringWinner();
		Team loser = null;
		
		if(this.team1.equals(winner)){
			loser = this.team2;
		}
		else if(this.team2.equals(winner)) {
			loser = this.team1;
		}
		return loser;
	}
	

}
