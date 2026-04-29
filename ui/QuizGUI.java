package ui;

import javax.swing.*;
import java.util.*;
import model.Question;
import filehandling.FileHandler;
import database.ResultDAO;

public class QuizGUI extends JFrame {

    JLabel qLabel, timerLabel;
    JRadioButton r1, r2, r3, r4;
    ButtonGroup bg;
    JButton next, submit;

    ArrayList<Question> list;
    int index = 0, score = 0;
    int time = 15; 
    javax.swing.Timer timer;

    String name;

    public QuizGUI() 
    {

        name = JOptionPane.showInputDialog("Enter your name:");

        if (name == null || name.trim().equals("")) 
        {
            JOptionPane.showMessageDialog(this, "Enter valid name!");
            return;
        }

        list = FileHandler.loadQuestions();

        if (list.size() == 0) 
        {
            JOptionPane.showMessageDialog(this, "No questions found!");
            return;
        }

        Collections.shuffle(list);

        setTitle("QUIZMATE - Quiz");
        setSize(500, 400);
        setLayout(null);

        qLabel = new JLabel();
        timerLabel = new JLabel();

        r1 = new JRadioButton();
        r2 = new JRadioButton();
        r3 = new JRadioButton();
        r4 = new JRadioButton();

        bg = new ButtonGroup();
        bg.add(r1); bg.add(r2); bg.add(r3); bg.add(r4);

        next = new JButton("Next");
        submit = new JButton("Submit");

        qLabel.setBounds(50, 50, 400, 30);
        timerLabel.setBounds(350, 10, 120, 30);

        r1.setBounds(50, 100, 300, 30);
        r2.setBounds(50, 130, 300, 30);
        r3.setBounds(50, 160, 300, 30);
        r4.setBounds(50, 190, 300, 30);

        next.setBounds(100, 250, 100, 30);
        submit.setBounds(250, 250, 100, 30);

        add(qLabel); add(timerLabel);
        add(r1); add(r2); add(r3); add(r4);
        add(next); add(submit);

        loadQuestion();
        startTimer();

        next.addActionListener(e -> nextQuestion());
        submit.addActionListener(e -> submitQuiz());

        setVisible(true);
    }

    void loadQuestion() 
    {
        Question q = list.get(index);

        qLabel.setText("Q" + (index + 1) + ": " + q.question);

        r1.setText(q.opt1);
        r2.setText(q.opt2);
        r3.setText(q.opt3);
        r4.setText(q.opt4);

        bg.clearSelection();

        time = 15; 
    }

    void startTimer() 
    {
        timer = new javax.swing.Timer(1000, e -> 
        {
            time--;
            timerLabel.setText("Time: " + time);

            if (time <= 0) 
            {
                timer.stop();
                nextQuestionAuto();
            }
        });
        timer.start();
    }

    void checkAnswer() 
    {
        Question q = list.get(index);

        if (r1.isSelected() && q.correct == 1) score++;
        if (r2.isSelected() && q.correct == 2) score++;
        if (r3.isSelected() && q.correct == 3) score++;
        if (r4.isSelected() && q.correct == 4) score++;
    }

    void nextQuestion() 
    {

        if (!r1.isSelected() && !r2.isSelected() && !r3.isSelected() && !r4.isSelected()) 
        {
            JOptionPane.showMessageDialog(this, "Select an option!");
            return;
        }

        timer.stop();
        checkAnswer();
        index++;

        if (index < list.size()) 
        {
            loadQuestion();
            startTimer();
        } else {
            submitQuiz();
        }
    }

    // AUTO MOVE when timer ends
    void nextQuestionAuto() 
    {
        index++;

        if (index < list.size()) 
        {
            loadQuestion();
            startTimer();
        } 
        else 
        {
            submitQuiz();
        }
    }

    void submitQuiz() 
    {

        timer.stop();

        int c = JOptionPane.showConfirmDialog(this, "Submit Quiz?");
        if (c == 0) {

            ResultDAO.saveResult(name, score, list.size());
            new ResultGUI(name, score, list.size());
            dispose();
        }
    }
}