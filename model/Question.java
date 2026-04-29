package model;

public class Question {

    public String question, opt1, opt2, opt3, opt4;
    public int correct;

    public Question(String q, String o1, String o2, String o3, String o4, int c) 
    {
        this.question = q;
        this.opt1 = o1;
        this.opt2 = o2;
        this.opt3 = o3;
        this.opt4 = o4;
        this.correct = c;
    }
}