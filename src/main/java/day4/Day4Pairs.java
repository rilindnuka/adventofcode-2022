package day4;

import java.util.List;

public class Day4Pairs {
    private List<Day4Sequence> sequences;
    private Integer firstMin;
    private Integer firstMax;
    private Integer secondMin;
    private Integer secondMax;

    public Day4Pairs(List<Day4Sequence> sequences) {
        this.sequences = sequences;
        this.firstMin = sequences.get(0).getMin();
        this.firstMax = sequences.get(0).getMax();
        this.secondMin = sequences.get(1).getMin();
        this.secondMax = sequences.get(1).getMax();
    }

    public boolean doTheyOverlapComplete(){
        if (firstMin<=secondMin && firstMax>=secondMax){
            return true;
        }
        if (secondMin<=firstMin && secondMax>=firstMax){
            return true;
        }
        return false;
    }

    public boolean doTheyOverlapPartial(){
        return firstMin <= secondMax && secondMin <= firstMax;
    }
}
