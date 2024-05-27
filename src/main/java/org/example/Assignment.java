package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Assignment {
    private String assignmentId;
    @Getter private String assignmentName;
    @Getter private double weight;
    private int maxScore;
    private double assignmentAverage;
    @Getter private ArrayList<Integer> scores;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight, int maxScore, int studentAmount) {
        this.assignmentId = String.format("%02d", nextId++);
        this.assignmentName = Util.toTitleCase(assignmentName);
        this.weight = weight;
        this.maxScore = maxScore;

        this.scores = new ArrayList<>();
        for (int i = 0; i < studentAmount; i++) {
            scores.add(null);
        }
    }

    /**
     * calculates the average score for an assignment
     */
    public void calcAssignmentAvg() {
        double avg = 0;
        for (int score : scores) {
            avg += score;
        }
        assignmentAverage = avg / scores.size();
    }

    /**
     * generates random scores for all students in an assignment
     */
    public void generateRandomScore() {
        Random rand = new Random();

        for (int i = 0; i < scores.size(); i++) {
            int randNum = rand.nextInt(0, 11);

            int randScore = switch (randNum) {
                case 0 -> rand.nextInt(0, 61);
                case 1, 2 -> rand.nextInt(60, 71);
                case 3, 4 -> rand.nextInt(70, 81);
                case 5, 6, 7, 8 -> rand.nextInt(80, 91);
                case 9, 10 -> rand.nextInt(90, 101);
                default -> 0;
            };
            scores.set(i, randScore);
        }
        calcAssignmentAvg();
    }

    public double getWeight() {
    }

    public Calendar getScores() {
    }

    public Object getAssignmentName() {
    }

    public double getMaxScore() {
    }

    public double getAssignmentAverage() {
        return assignmentAverage;
    }
}
