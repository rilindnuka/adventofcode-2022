import day.Day;
import day1.Day1;
import day2.Day2;
import day3.Day3;
import day4.Day4;
import day5.Day5;
import day6.Day6;
import day7.Day7;

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
            System.out.println();

            Day2 day2 = new Day2();
            day2.calculate(1);
            day2.calculate(2);
            System.out.println(hashtags);
            System.out.println();

            Day3 day3 = new Day3();
            day3.calculate(1);
            day3.calculate(2);
            System.out.println(hashtags);
            System.out.println();

            Day4 day4 = new Day4();
            day4.calculate(1);
            day4.calculate(2);
            System.out.println(hashtags);
            System.out.println();

            Day5 day5partOne = new Day5();
            day5partOne.calculate(1);
            Day5 day5day5partTwo = new Day5();
            day5day5partTwo.calculate(2);
            System.out.println(hashtags);
            System.out.println();

            Day6 day6 = new Day6();
            day6.calculate(1);
            day6.calculate(2);
            System.out.println(hashtags);
            System.out.println();

            Day7 day7 =new Day7();
            day7.calculate(1);
            day7.calculate(2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
