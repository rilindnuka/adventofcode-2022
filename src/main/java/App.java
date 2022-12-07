import day.Day;
import day1.Day1;
import day2.Day2;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try {
            String hashtags = "###########################";
            String header = hashtags+ "\n#  Advent of code - 2022  #\n"+hashtags+"\n";
            System.out.println(header);
            Day1 day1 = new Day1();
            day1.calculate(1);
            day1.calculate(2);
            System.out.println(hashtags);
            Day2 day2 = new Day2();
            day2.calculate(1);
            day2.calculate(2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
