package day1;

import java.util.List;

public class DayOneElf {
    private List<Integer> calories;
    private Integer sum;


    public DayOneElf(List<Integer> calories, Integer sum) {
        this.calories = calories;
        this.sum = sum;
    }

    public List<Integer> getCalories() {
        return calories;
    }

    public void setCalories(List<Integer> calories) {
        this.calories = calories;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
}
