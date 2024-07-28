package _12_lecture;

import java.util.List;
import java.util.stream.Collectors;

public class GradeLecture extends Lecture {
    private final List<Grade> grades;

    public GradeLecture(int pass, String title, List<Integer> scores, List<Grade> grades) {
        super(pass, title, scores);
        this.grades = grades;
    }

    @Override
    public String evaluate() {
        return super.evaluate() + ", " + gradesStatistics();
    }

    @Override
    public String getEvaluationMethod() {
        return "Grade";
    }

    private String gradesStatistics() {
        return grades.stream()
                .map(this::format)
                .collect(Collectors.joining(" "));
    }

    public double average(String gradeName) {
        return grades.stream()
                .filter(each -> each.isName(gradeName))
                .findFirst()
                .map(this::gradeAverage)
                .orElse(0d);
    }

    private double gradeAverage(Grade grade) {
        return getScores().stream()
                .filter(grade::include)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    private String format(Grade grade) {
        return String.format("%s:%d", grade.name(), gradeCount(grade));
    }

    private long gradeCount(Grade grade) {
        return getScores().stream()
                .filter(grade::include)
                .count();
    }
}
