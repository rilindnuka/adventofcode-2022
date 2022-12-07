package day2;

import day.Day;
import util.AdventUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2 extends Day {
    List<String> combinations;
    int rockPoint = 1;
    int paperPoint = 2;
    int scissorPoint = 3;
    int winPoint = 6;
    int drawPoint = 3;
    int losePoint = 0;

    public Day2() throws IOException {
        super.setInput(AdventUtil.readFile("src/main/resources/day2.txt"));
        this.combinations = new ArrayList<>();
    }

    @Override
    public void calculate(int part) {
        fillCombinations();
        switch (part) {
            case 1:
                System.out.printf("Day two (part one): %d\n", partOne());
                break;
            case 2:
                System.out.printf("Day two (part two): %d\n", partTwo());
                break;
            default:
                System.out.println("Wrong part");
        }
    }

    private void fillCombinations() {
        String[] fields = super.getInput().split("\n");
        for (int i = 0; i < fields.length; i++) {
            combinations.add(fields[i]);
        }
    }

    private Integer partOne() {
        int sum = 0;
        for (int i = 0; i < combinations.size(); i++) {
            sum += calculateCombinationPartOne(combinations.get(i));

        }
        return sum;
    }
    private Integer partTwo() {
        int sum = 0;
        for (int i = 0; i < combinations.size(); i++) {
            sum += calculateCombinationPartTwo(combinations.get(i));

        }
        return sum/2;
    }

    private int calculateCombinationPartTwo(String combination) {
        // A -> ROCK
        // B -> PAPER
        // C -> SCISSOR
        // X -> PAPER   -> 2 Point
        // Y -> ROCK    -> 1 Points
        // Z -> SCISSOR -> 3 Point

        switch (combination) {
            case "A Y":
                return 4;
            case "B Y":
                return 5;
            case "C Y":
                return 6;
            case "A X":
                return 3;
            case "B X":
                return 1;
            case "C X":
                return 2;
            case "A Z":
                return 8;
            case "B Z":
                return 9;
            case "C Z":
                return 7;
        }
        return 0;
    }
    private int calculateCombinationPartOne(String combination) {
        // A -> ROCK
        // B -> PAPER
        // C -> SCISSOR
        // X -> ROCK    -> 1 Point
        // Y -> PAPER   -> 2 Points
        // Z -> SCISSOR -> 3 Point
        switch (combination) {
            case "A Y":
                return paperPoint + winPoint;
            case "B Y":
                return paperPoint + drawPoint;
            case "C Y":
                return paperPoint + losePoint;
            case "A X":
                return rockPoint + drawPoint;
            case "B X":
                return rockPoint + losePoint;
            case "C X":
                return rockPoint + winPoint;
            case "A Z":
                return scissorPoint + losePoint;
            case "B Z":
                return scissorPoint + winPoint;
            case "C Z":
                return scissorPoint + drawPoint;
        }
        return 0;
    }

}
