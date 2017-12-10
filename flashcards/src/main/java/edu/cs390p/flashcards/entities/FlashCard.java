package edu.cs390p.flashcards.entities;

import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class FlashCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String question;

    private String answer;

    public FlashCard() {
        this.question = "Empty question";
        this.answer = "No answer available";
    }

    public FlashCard(final String newQuestion, final String newAnswer)
                    throws IllegalArgumentException {

        if (newQuestion == null || newQuestion.isEmpty()) {
            question = "Empty question";
        } else {
            question = newQuestion;
        }
        if (newAnswer == null || newAnswer.isEmpty()) {
            answer = "No answer available";
        } else {
            answer = newAnswer;
        }
    }

    public void setId(final String newId) {
        this.id = newId;
    }

    public String getId() {
        return id;
    }

    public void setQuestion(final String newQuestion)
            throws IllegalArgumentException {
        if (newQuestion == null || newQuestion.isEmpty()) {
            throw new IllegalArgumentException("Question cannot be blank.");
        }
        this.question = newQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnswer(final String newDescription) {
        if (newDescription == null || newDescription.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be blank!");
        }
        this.answer = newDescription;
    }

    public String getAnswer() {
        return answer;
    }


    @Override
    public String toString() {
        return "FlashCard{" + "Id=" + id + ", "
                + "Question= " + question + ", Answer= "
                + answer + "}";
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || !(o instanceof FlashCard)) {
            return false;
        }
        if (this == o) {
            return true;
        }

        FlashCard flashCard = (FlashCard) o;
        return Objects.equals(id, flashCard.id)
                && Objects.equals(question, flashCard.question)
                && Objects.equals(answer, flashCard.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer);
    }
}
