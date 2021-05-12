package com.escaperooms.spaceodyssey;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TriviaV2 {
    private String question;
    private List<String> answers = new ArrayList<>();
    private String correctAnswer;
    private Scanner scanner = new Scanner(System.in);

    @JsonCreator
    public TriviaV2(@JsonProperty("question") String question,
                    @JsonProperty("answers") List<String> answers,
                    @JsonProperty("correctAnswer") String correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    private void askQuestion(){
        System.out.println(question);
    }
    private void giveAnswers(){
        answers.forEach(System.out::println);
    }

    private String getAnswer(){
        System.out.println("Answer -> ");
        return scanner.nextLine();
    }
    private boolean checkAnswer(String answer){
        return answer.equalsIgnoreCase(correctAnswer);
    }

    private boolean checkAnswerFight(String answer){
        List<String> correctAnswer = List.of("Rock", "Paper", "Scissors");
        Random rand = new Random();
        int n = rand.nextInt(3);
        return answer.equalsIgnoreCase(correctAnswer.get(n));
    }

    public boolean quiz(){
        return checkAnswer(SpaceGame.guiController.askTrivia(question,answers));
    }
    public boolean quizFight(){
        return checkAnswerFight(SpaceGame.guiController.fightTrivia("Rock... Paper... Scissors... SHOOT!",List.of("Rock", "Paper", "Scissors")));

        //return checkAnswer(getAnswer());
    }
}
