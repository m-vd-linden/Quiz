package nl.avans.ivp4.quiz.domain;

public class QuizVraag {
	private String stadionNaam;
	private String clubNaam;
	
	public QuizVraag(String stadionNaam, String clubNaam) {
		this.stadionNaam = stadionNaam;
		this.clubNaam = clubNaam;
	}
	
	public String getStadionNaam() {
		return stadionNaam;
	}
	
	public String getClubNaam() {
		return clubNaam;
	}
}
