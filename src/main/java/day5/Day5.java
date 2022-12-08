package day5;

import day.Day;
import util.AdventUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day5 extends Day {
    List<Day5Command> commands;
    Integer columnSize;
    List<Day5Column> columns;

    public Day5() throws IOException {
        super.setInput(AdventUtil.readFile("src/main/resources/day5.txt"));
        commands = new ArrayList<>();
        columns = new ArrayList<>();
        fillCombinations();

    }

    private void fillCombinations() {
        String[] fields = super.getInput().split("\n");
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].startsWith("move")) {
                this.commands.add(new Day5Command(fields[i]));
            }
            if (fields[i].startsWith(" 1")) {
                this.columnSize = Integer.parseInt(String.valueOf(fields[i].charAt(fields[i].length() - 1)));
                for (int j = 0; j < columnSize; j++) {
                    columns.add(new Day5Column(new ArrayList<>()));
                }
            }

        }
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].contains("[")) {
                int count = fields[i].length() - fields[i].replace("[", "").length();
                extractCrates(fields[i], 0,count, fields[i]);
            }
        }
    }

    private void extractCrates(String line, int startAt, int occurances, String originalLine) {
        String previousString = originalLine.substring(0,startAt);
        int foundBracket = line.indexOf("]");
        Day5Crate crate = new Day5Crate(String.valueOf(line.charAt(foundBracket - 1)));
        int foundPosition = previousString.length()+foundBracket-2;
        switch (foundPosition){
            case 0: columns.get(0).addCrate(crate); break;
            case 4: columns.get(1).addCrate(crate); break;
            case 8: columns.get(2).addCrate(crate); break;
            case 12: columns.get(3).addCrate(crate); break;
            case 16: columns.get(4).addCrate(crate); break;
            case 20: columns.get(5).addCrate(crate); break;
            case 24: columns.get(6).addCrate(crate); break;
            case 28: columns.get(7).addCrate(crate); break;
            case 32: columns.get(8).addCrate(crate); break;
            case 34: columns.get(9).addCrate(crate); break;
            case 38: columns.get(10).addCrate(crate); break;
        }
        if (hasMoreCrates(line.substring(foundBracket))) {
            String choppedLine = line.substring(foundBracket + 1);
            extractCrates(choppedLine, foundBracket+1 + startAt,occurances,originalLine);
        }
    }

    private boolean hasMoreCrates(String line) {
        if (line.equals("]")) {
            return false;
        } else {
            return line.contains("]");
        }
    }

    @Override
    public void calculate(int part) {

        switch (part) {
            case 1:
                System.out.printf("Day five (part one): %s\n", partOne());
                break;
            case 2:
                System.out.printf("Day five (part two): %s\n", partTwo());
                break;
            default:
                System.out.println("Wrong part");
        }
    }

    private String partOne() {
        String result = "";
        for (int i = 0; i < commands.size(); i++) {
            doTheMovePartOne(commands.get(i));

        }
        for (int j = 0; j < columns.size(); j++) {
            result+=columns.get(j).getTopCrate().getValue();
        }
        return result;
    }

    private void doTheMovePartOne(Day5Command command){
        int from = command.getFrom()-1;
        int to = command.getTo()-1;
        for (int i=0; i< command.getHowMany();i++){
            Day5Crate crateToMove = columns.get(from).removeCrate();
            columns.get(to).addCrateWithCommand(crateToMove);
        }
    }

    private String partTwo() {
        String result = "";
        for (int i = 0; i < commands.size(); i++) {
            doTheMovePartTwo(commands.get(i));

        }
        for (int j = 0; j < columns.size(); j++) {
            result+=columns.get(j).getTopCrate().getValue();
        }
        return result;
    }
    private void doTheMovePartTwo(Day5Command command){
        int from = command.getFrom()-1;
        int to = command.getTo()-1;
        List<Day5Crate> cratesToMove = new ArrayList<>();
        for (int i=0; i< command.getHowMany();i++){
            Day5Crate crateToMove = columns.get(from).removeCrate();
            cratesToMove.add(crateToMove);
        }
        Collections.reverse(cratesToMove);
        for (int i = 0; i < cratesToMove.size(); i++) {
            Day5Crate crate = cratesToMove.get(i);
            columns.get(to).addCrateWithCommand(crate);
        }

    }
}
