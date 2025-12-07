package org.dave;

import java.util.List;

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
}
