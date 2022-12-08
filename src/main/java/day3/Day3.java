package day3;

import day.Day;
import util.AdventUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day3 extends Day {
    String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    List<DayThreeRuckSack> ruckSacks;

    public Day3() throws IOException {
        super.setInput(AdventUtil.readFile("src/main/resources/day3.txt"));
        this.ruckSacks = new ArrayList<>();
        fillCombinations();
    }

    private void fillCombinations() {
        String[] fields = super.getInput().split("\n");
        for (int i = 0; i < fields.length; i++) {
            ruckSacks.add(new DayThreeRuckSack(fields[i]));
        }
    }

    @Override
    public void calculate(int part) {
        switch (part) {
            case 1:
                System.out.printf("Day three (part one): %d\n", partOne());
                break;
            case 2:
                System.out.printf("Day three (part two): %d\n", partTwo());
                break;
            default:
                System.out.println("Wrong part");
        }

    }

    private int partOne(){
        int sum = 0;
        for (int i = 0; i < ruckSacks.size(); i++) {
            String commonChar = ruckSacks.get(i).commonCharacter();
            int value = alphabet.indexOf(commonChar)+1;
            sum +=  value;
        }
        return sum;
    }
    private int partTwo(){
        List<RuckSackBadge> badges = new ArrayList<>();
        batches(ruckSacks, 3).forEach(sacksBatch -> {
            badges.add(new RuckSackBadge(sacksBatch));
        });
        int sum = 0;
        for (int i = 0; i < badges.size(); i++) {
            String commonChar = badges.get(i).getBadge();
            int value = alphabet.indexOf(commonChar)+1;
            sum +=  value;

        }
        return sum;
    }

    public static <T> Stream<List<T>> batches(List<T> source, int length) {
        if (length <= 0)
            throw new IllegalArgumentException("length = " + length);
        int size = source.size();
        if (size <= 0)
            return Stream.empty();
        int fullChunks = (size - 1) / length;
        return IntStream.range(0, fullChunks + 1).mapToObj(
                n -> source.subList(n * length, n == fullChunks ? size : (n + 1) * length));
    }
}
