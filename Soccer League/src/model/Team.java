package model;

public class Team {
	private String name;
	private int goals;
	
	//Constructors
	public Team(String name, int goals) {
		super();
		this.name = name;
		this.goals = goals;
	}

	//Getters, Setters, ToString & Equals 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	@Override
	public String toString() {
		return "Team [name=" + name + ", goals=" + goals + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	//General methods
	
	
	
	
}
