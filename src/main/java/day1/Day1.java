package day1;

import day.Day;
import util.AdventUtil;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Day1 extends Day {
    private List<DayOneElf> elves;
    private List<Integer> calories;

    public Day1() throws IOException {
        super.setInput(AdventUtil.readFile("src/main/resources/day1.txt"));
        elves = new ArrayList<>();
        calories = new ArrayList<>();
    }

    public void calculate(int part) {
        String[] fields = super.getInput().split("\n");
        for (int i = 0; i < fields.length; i++) {
            boolean skip = fields[i].isEmpty();
            if (skip) {
                elves.add(new DayOneElf(
                        calories,
                        calories.stream().reduce(0, Integer::sum)));
                calories.clear();
            } else {
                calories.add(Integer.parseInt(fields[i]));
            }
        }
        switch (part) {
            case 1:
                System.out.printf("Day one (part one): %d\n",partOne());
                ; break;
            case 2:
                System.out.printf("Day one (part two): %d\n",partTwo());;break;
            default:
                System.out.println("Wrong part");;
        }
    }

    private Integer partOne() {
        return elves.stream().max((Comparator.comparingInt(DayOneElf::getSum))).isPresent()
                ? elves.stream().max((Comparator.comparingInt(DayOneElf::getSum))).get().getSum()
                : 0;
    }

    private Integer partTwo() {
        List<Integer> sums = elves.stream()
                .sorted(Comparator.comparing(DayOneElf::getSum))
                .map(DayOneElf::getSum)
                .collect(Collectors.toList());
        Collections.sort(sums, Collections.reverseOrder());
        return sums.get(0)+sums.get(1)+sums.get(2);
    }

    public String getInput() {
        return super.getInput();
    }
}
