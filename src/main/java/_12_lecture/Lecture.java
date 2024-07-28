package _12_lecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lecture {
    private final int pass;
    private final String title;
    private final List<Integer> scores;

    public Lecture(int pass, String title) {
        this.pass = pass;
        this.title = title;
        this.scores = new ArrayList<>();
    }

    public Lecture(int pass, String title, List<Integer> scores) {
        this.pass = pass;
        this.title = title;
        this.scores = scores;
    }

    public double average() {
        return scores.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    public List<Integer> getScores() {
        return Collections.unmodifiableList(scores);
    }

    public String evaluate() {
        final long passCount = passCount();
        return String.format("Pass: %d Fail: %d", passCount, scores.size() - passCount);
    }

    public String stats() {
        return String.format("Title: %s, Evaluation Method: %s", title, this.getEvaluationMethod());
    }

    public String getEvaluationMethod() {
        return "Pass or Fail";
    }

    private long passCount() {
        return scores.stream()
                .filter(score -> score >= pass)
                .count();
    }
}
