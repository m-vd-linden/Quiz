package nl.avans.ivp4.quiz.main;

import javax.swing.*;

import nl.avans.ivp4.quiz.domain.QuizVraag;
import nl.avans.ivp4.quiz.businesslogic.QuizManager;
import nl.avans.ivp4.quiz.presentation.QuizGUI;

// Main class which will be called
public class Main extends JFrame {
	public static void main(String[] args) {
		QuizManager manager = new QuizManager();
		
		JFrame frame = new Main();
        frame.setSize(500, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Quiz!");
        
        JPanel paneel = new QuizGUI(manager);
        frame.setContentPane(paneel);
        frame.setVisible( true );
	}

}
