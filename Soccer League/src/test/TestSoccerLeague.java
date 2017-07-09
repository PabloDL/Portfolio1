package test;

import java.io.*;
import java.util.Scanner;

import model.Team;
import model.Match;
import model.Championship;
import model.Score;

public class TestSoccerLeague {

	public static void main(String[] args) {
//		if (args.length == 0) {
//            System.out.println("No arguments were given.\n"
//            		+ "Please, introduce a .txt file path");
//            
//        }
//        else {
//	
			try (Scanner scan = new Scanner(new File("src/model/textfile.txt"))) {
		        Championship currentChampionship =  new Championship();
	
				while(scan.hasNextLine()){
			        String line = scan.nextLine();
			        currentChampionship.addMatch(line);
			        
			   	}
				for (Match currentMatch : currentChampionship.getLstMatches()){
					Team winner = currentMatch.bringWinner();
					Team loser= currentMatch.bringLoser();

					if(winner==null){
						currentChampionship.setPoints(currentMatch.getTeam1(), 1);
						currentChampionship.setPoints(currentMatch.getTeam2(), 1);
					}
					else{
						currentChampionship.setPoints(winner,3);
						currentChampionship.setPoints(loser, 0);
					}
				}
				
	            FileWriter fileWriter = new FileWriter("src/model/out.txt");
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	            
	            for(Score currentScore : currentChampionship.getLstScoreBoard()){
		            
		            bufferedWriter.write(currentScore.getTeamName() + ", " + currentScore.getScore() + " pt");
					bufferedWriter.newLine();
	            }

	            bufferedWriter.close();
	      
				System.out.printf("Finished! \nFile Created in \"src/model/out.txt\"");
				
			} 
			catch (Exception ex) {
				ex.printStackTrace();
			}
//		}
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		