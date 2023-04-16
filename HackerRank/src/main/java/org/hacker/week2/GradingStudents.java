package org.hacker.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GradingStudents {
    public static void main(String[] args) {
        System.out.println(Math.ceil(41 / 5.0));
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> result = new ArrayList<>(grades.size());
        for (Integer grade : grades) {
            if (grade >= 38) {
                int difference = 5 - grade % 5;
                if (difference < 3) {
                    grade = grade + difference;
                }
            }
            result.add(grade);
        }
        return result;
    }

    public static List<Integer> gradingStudents2(List<Integer> grades) {
        return grades.stream()
                .map(grade -> {
                    if (grade < 38) {
                        return grade;
                    } else {
                        int nextMultipleOf5 = (int) (5 * Math.ceil(grade / 5.0));
                        return (nextMultipleOf5 - grade < 3) ? nextMultipleOf5 : grade;
                    }
                })
                .collect(Collectors.toList());
    }

}
