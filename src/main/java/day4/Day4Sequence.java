package day4;

public class Day4Sequence {
    private String input;
    private Integer min;
    private Integer max;

    public Day4Sequence(String input) {
        this.input = input;
        fillMinMax();
    }

    private void fillMinMax() {
        String[] fields = input.split("-");
        this.min = Integer.parseInt(fields[0]);
        this.max = Integer.parseInt(fields[1]);
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }
}
