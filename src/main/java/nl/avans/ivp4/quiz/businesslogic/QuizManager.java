package nl.avans.ivp4.quiz.businesslogic;

import java.util.*;

import nl.avans.ivp4.quiz.domain.QuizVraag;

public class QuizManager {
	private ArrayList<QuizVraag> quizVragen = new ArrayList<QuizVraag>();
	private HashSet<String> stadionNamen = new HashSet(quizVragen);
	private QuizManager manager;
	
	public QuizManager() {
		this.manager = manager;
		
		genereerData();
	}
	
	public void genereerData() {
		QuizVraag vraag_1 = new QuizVraag("Allianz Arena", "FC Bayern München");
		QuizVraag vraag_2 = new QuizVraag("Camp Nou", "FC Barcelona");
		QuizVraag vraag_3 = new QuizVraag("Estadio Vicente Calderón", "Atlético Madrid");
		QuizVraag vraag_4 = new QuizVraag("Volkswagen-Arena", "VfL Wolfsburg");
		
		addQuizVraag(vraag_1);
        addQuizVraag(vraag_2);
        addQuizVraag(vraag_3);
        addQuizVraag(vraag_4);
	}
	
	public HashSet getStadionNamen() {
		for(QuizVraag vraag: quizVragen) {
			stadionNamen.add(vraag.getStadionNaam());
		}
		
		return stadionNamen;
	}
	
	public String getRandomClubNaam() {
		String clubNaam = "";
		QuizVraag quizVraag = null;
		
		int size = quizVragen.size();
		int item = new Random().nextInt(size); // In real life, the Random object should be rather more shared than this
		int i = 0;
		for(QuizVraag obj : quizVragen)
		{
		    if (i == item)
		        quizVraag = obj;
		    i = i + 1;
		}
		
		return quizVraag.getClubNaam();
	}
	
	public String getCorrectAnswer(String clubNaam) {
		String correctAnswer = "";
		
		for(QuizVraag vraag: quizVragen) {
			if(vraag.getClubNaam().equals(clubNaam)) {
				correctAnswer = vraag.getStadionNaam();
			}
		}
		
		return correctAnswer;
	}
	
	public boolean check(String stadionNaam, String clubNaam) {
		boolean answer = false;
		
		for(QuizVraag vraag: quizVragen) {
			if(vraag.getClubNaam().equals(clubNaam)) {
				if(vraag.getStadionNaam().equals(stadionNaam)) {
					answer = true;
				}
			}
		}
		
		return answer;
	}
	
	public void addQuizVraag(QuizVraag vraag) {
		quizVragen.add(vraag);
	}
}
