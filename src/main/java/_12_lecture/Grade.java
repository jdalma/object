package _12_lecture;

public record Grade(
        String name,
        int upper,
        int lower
) {

    public boolean isName(String name) {
        return this.name.equals(name);
    }

    public boolean include(int score) {
        return score >= lower && score <= upper;
    }
}
