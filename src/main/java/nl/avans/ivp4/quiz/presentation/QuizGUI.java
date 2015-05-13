package nl.avans.ivp4.quiz.presentation;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import nl.avans.ivp4.quiz.businesslogic.QuizManager;

public class QuizGUI extends JPanel {
	private QuizManager manager;
	private JLabel questionLabel, answerLabel, responseLabel;
	private JTextField question;
	private JTextArea response;
	private JComboBox answer;
	private JButton newQuestion, checkAnswer, close;

	public QuizGUI(QuizManager manager) {
		this.manager = manager;
		
		setupFrame();
	}
	
	public void setupFrame() {
		setLayout(new BorderLayout(10, 10));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		JPanel west = new JPanel();
		JPanel center = new JPanel();
		JPanel east = new JPanel();
		JPanel south = new JPanel();

		west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		south.setLayout(new FlowLayout(FlowLayout.TRAILING));

		questionLabel = new JLabel("Hoe heet het stadion van:",
				SwingConstants.RIGHT);
		answerLabel = new JLabel("Antwoord:", SwingConstants.RIGHT);
		responseLabel = new JLabel("Feedback:", SwingConstants.RIGHT);

		west.add(Box.createVerticalStrut(5));
		west.add(questionLabel);
		west.add(Box.createVerticalStrut(30));
		west.add(answerLabel);
		west.add(Box.createVerticalStrut(30));
		west.add(responseLabel);

		add(west, BorderLayout.WEST);

		question = new JTextField(10);
		question.setEditable(false);
		question.setText(manager.getRandomClubNaam());

		HashSet<String> stadionNamen = manager.getStadionNamen();

		answer = new JComboBox();

		for (String naam : stadionNamen) {
			answer.addItem(naam);
		}

		response = new JTextArea();
		response.setPreferredSize(new Dimension(100, 60));
		response.setLineWrap(true);
		response.setWrapStyleWord(true);

		center.add(question);
		center.add(Box.createVerticalStrut(20));
		center.add(answer);
		center.add(Box.createVerticalStrut(15));
		center.add(response);

		add(center, BorderLayout.CENTER);

		newQuestion = new JButton("Nieuwe vraag");
		checkAnswer = new JButton("Controleren");

		east.add(newQuestion);
		east.add(Box.createVerticalStrut(20));
		east.add(checkAnswer);

		add(east, BorderLayout.EAST);

		close = new JButton("Sluiten");
		south.add(close);

		add(south, BorderLayout.SOUTH);

		checkAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doCheckAnswer();
			}
		});
		
		newQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshQuestion();
			}
		});
		
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void refreshQuestion() {
		question.setText("");
		question.setText(manager.getRandomClubNaam());
		response.setText("");
	}
	
	public void doCheckAnswer() {
		String stadion = (String) answer.getSelectedItem();
		String vraag = question.getText();
		boolean correct = manager.check(stadion, vraag);
		
		if(correct == false) {
			response.setText("Helaas, het antwoord is niet juist. Het juiste antwoord was:\n\n"+manager.getCorrectAnswer(vraag));
		} else if(correct == true) {
			response.setText("Gefeliciteerd, het antwoord is juist!");
		}
	}
}
