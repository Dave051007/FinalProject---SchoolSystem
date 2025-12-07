package org.dave;

import java.util.List;
import java.util.Random;

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private List<Integer> scores;

    private static int nextId = 1;

    /**
     * Calculates the average score of the assignment
     * @return the average score of the assignment
     */
    public double calcAssignmentAvg() {
        int sum = 0;

        for (Integer score : scores) {
            sum += score;
        }

        return sum / scores.size();
    }

    /**
     *  Generates random scores for all students in an assignment
     */
    public void generateRandomScore() {
        Random rand = new Random();

        for (int i = 0; i< scores.size(); i++) {
            int randomNum = rand.nextInt(0, 11);                 // generate a random num [0, 10]

            int score = 0;
            switch (randomNum) {
                case 0 -> score = rand.nextInt(0, 61);           // [0, 60]
                case 1, 2 -> score = rand.nextInt(60, 71);       // [60, 70]
                case 3, 4 -> score = rand.nextInt(70, 81);       // [70, 80]
                case 5, 6, 7, 8 -> score = rand.nextInt(80, 91); // [80, 90]
                case 9, 10 -> score = rand.nextInt(90, 101);     // [90, 100]
            }

            scores.set(i, score);
        }
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
