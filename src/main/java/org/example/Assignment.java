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
public class Assignment {

}
