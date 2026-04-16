package GradeCalculator.Util;

import java.util.ArrayList;

public interface GradeCalculator {
    double calculateAverage(ArrayList<Integer> grades);
    String determinePerformance(double average);
}