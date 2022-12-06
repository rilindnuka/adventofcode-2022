import day1.Day1;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try {
            String hashtags = "###########################";
            String header = hashtags+ "\n#  Advent of code - 2022  #\n"+hashtags+"\n";
            System.out.println(header);
            Day1 day1 = new Day1();
            System.out.printf("Day one (part one): %d\n",day1.calculate(1));
            System.out.printf("Day one (part two): %d\n",day1.calculate(1));
            System.out.println(hashtags);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
