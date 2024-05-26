package org.example;
/*
- Fields

1. `String assignmentId`
2. `String assignmentName`
3. `double weight`
4. `int maxScore`
5. `double assignmentAverage`
6. `int[]/ArrayList<Integer> scores`
7. `static int nextId`

- Methods

1. `void calcAssignmentAvg()` // calculates the average score for one assignment
2. `void generateRandomScore()` // generates random scores for all students in an assignment, the scores are
generated with the following rule: Firstly generate a random number in range `[0, 10]`, then

   - if the number is `0`, then generate a random score in range `[0, 60)` for the student
   - if the number is `1`, `2`, then generate a random score in range `[60, 70)` for the student
   - if the number is `3`, `4`, then generate a random score in range `[70, 80)` for the student
   - if the number is `5`, `6`, `7`, `8`, then generate a random score in range `[80, 90)` for the student
   - if the number is `9`, `10`, then generate a random score in range `[90, 100]` for the student

   1. `toString` // generates a string to represent an assignment, with assignmentId, assignmentName,
   weight and maxScore
 */
import lombok.Getter;

import java.util.ArrayList;
import java.util.Random;

public class Assignment {
    private String assignmentId;
    @Getter
    private String assignmentName;
    @Getter
    private double weight;
    private int maxScore;
    private double assignmentAverage;
    @Getter
    private ArrayList<Integer> scores;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight, int maxScore) {
    }

    /**
     * calculates the average score for an assignment
     * @param scores the input scores for the assignments
     */
    public void calcAssignmentAvg(ArrayList<Integer> scores) {
        if (scores == null || scores.isEmpty()) {
            System.out.println("null");
        }

        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        System.out.println(sum/scores.size());
    }

    /**
     * generates random scores for all students in an assignment
     */
    public void generateRandomScore() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(0,11);

        if (randomNumber == 0) {
            randomNumber = rand.nextInt(0,60);
        } else if (randomNumber == 1 || randomNumber == 2) {
            randomNumber = rand.nextInt(60,70);
        } else if (randomNumber == 3 || randomNumber == 4) {
            randomNumber = rand.nextInt(70,80);
        } else if (randomNumber == 5 || randomNumber == 6 || randomNumber == 7 || randomNumber == 8) {
            randomNumber = rand.nextInt(80,90);
        } else if (randomNumber == 9 || randomNumber == 10) {
            randomNumber = rand.nextInt(90,101);
        }
    }

    @Override
    public String toString() {
        return String.format("Assignment : " +
                "\nAssignment Id : " + assignmentId +
                "\nAssignment Name : " + assignmentName +
                "\nWeight : " + weight +
                "\nMax Score : " + maxScore);
    }
}
