package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Day1 {
    private String input;
    private List<Elf> elves;
    private List<Integer> calories;

    public Day1() throws IOException {
        String fileName = "src/main/resources/day1.txt";
        Path path = Paths.get(fileName);
        input = Files.readString(path);
        elves = new ArrayList<>();
        calories = new ArrayList<>();
    }

    public long calculate(int part) {
        String[] fields = input.split("\n");
        for (int i = 0; i < fields.length; i++) {
            boolean skip = fields[i].isEmpty();
            if (skip) {
                elves.add(new Elf(
                        calories,
                        calories.stream().reduce(0, Integer::sum)));
                calories.clear();
            } else {
                calories.add(Integer.parseInt(fields[i]));
            }
        }
        switch (part) {
            case 1:
                return partOne();
            case 2:
                return partTwo();
            default:
                return 0;
        }
    }

    public Integer partOne() {
        return elves.stream().max((Comparator.comparingInt(Elf::getSum))).isPresent()
                ? elves.stream().max((Comparator.comparingInt(Elf::getSum))).get().getSum()
                : 0;
    }

    public Integer partTwo() {
        List<Integer> sums = elves.stream()
                .sorted(Comparator.comparing(Elf::getSum))
                .map(Elf::getSum)
                .collect(Collectors.toList());
        Collections.sort(sums, Collections.reverseOrder());
        return sums.get(0)+sums.get(1)+sums.get(2);
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
