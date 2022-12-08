package day4;

import day.Day;
import util.AdventUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day4 extends Day {
    List<Day4Sequence> sequences;
    List<Day4Pairs> pairs;

    public Day4() throws IOException {
        super.setInput(AdventUtil.readFile("src/main/resources/day4.txt"));
        sequences = new ArrayList<>();
        pairs = new ArrayList<>();
        fillCombinations();
    }
    private void fillCombinations() {
        String[] fields = super.getInput().split("\n");
        for (int i = 0; i < fields.length; i++) {
            String[] sequenceFields = fields[i].split(",");
            List<Day4Sequence> pairSequences= new ArrayList<>();
            Day4Sequence firstSequence = new Day4Sequence(sequenceFields[0]);
            Day4Sequence secondSequence = new Day4Sequence(sequenceFields[1]);
            pairSequences.add(firstSequence);
            pairSequences.add(secondSequence);
            pairs.add(new Day4Pairs(pairSequences));
            sequences.add(firstSequence);
            sequences.add(secondSequence);
        }
    }

    @Override
    public void calculate(int part) {

        switch (part) {
            case 1:
                System.out.printf("Day four (part one): %d\n", partOne());
                break;
            case 2:
                System.out.printf("Day four (part two): %d\n", partTwo());
                break;
            default:
                System.out.println("Wrong part");
        }
    }

    private int partTwo() {
        int sum = 0;
        for (int i = 0; i < pairs.size(); i++) {
            if (pairs.get(i).doTheyOverlapPartial()){
                sum++;
            }
        }
        return sum;
    }

    private int partOne() {
        int sum = 0;
        for (int i = 0; i < pairs.size(); i++) {
            if (pairs.get(i).doTheyOverlapComplete()){
                sum++;
            }
        }
        return sum;
    }


}
