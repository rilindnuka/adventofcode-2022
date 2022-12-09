package day6;

import day.Day;
import util.AdventUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Day6 extends Day {

    public Day6() throws IOException {
        super.setInput(AdventUtil.readFile("src/main/resources/day6.txt"));
    }

    @Override
    public void calculate(int part) {
        String line = super.getInput();
        switch (part) {
            case 1:
                System.out.printf("Day six (part one): %s\n", partOne(line));
                break;
            case 2:
                System.out.printf("Day six (part two): %s\n", partTwo(line));
                break;
            default:
                System.out.println("Wrong part");
        }
    }

    private int partTwo(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (i > 13) {
                if (isUniqueMessage(line.substring(i-14,i))) {
                    return i;
                }
            }
        }
        return 0;
    }

    private int partOne(String line){

        for (int i = 0; i < line.length(); i++) {
            if (i > 3) {
                if (isUniqueStart(line.substring(i-4,i))) {
                    return i;
                }
            }
        }
        return 0;
    }

    private boolean isUniqueStart(String fourLetters) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < fourLetters.length(); i++) {
            set.add(fourLetters.charAt(i));
        }
        return set.size()==4;
    }
    private boolean isUniqueMessage(String fourteenLetters) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < fourteenLetters.length(); i++) {
            set.add(fourteenLetters.charAt(i));
        }
        return set.size()==14;
    }
}
