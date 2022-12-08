package day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DayThreeRuckSack {
    private String input;

    public DayThreeRuckSack(String input) {
        this.input = input;
    }

    public String commonCharacter(){
        int half = input.length() % 2 == 0 ? input.length()/2 : input.length()/2 + 1;
        String first = input.substring(0, half);
        String second = input.substring(half);
        return printCommonChars(first,second).get(0);
    }

    private static List<String> printCommonChars(String firstString, String secondString)
    {
        char[] firstStringToCharArray = firstString.replaceAll("\\s+", "").toCharArray();

        char[] secondStringToCharArray = secondString.replaceAll("\\s+", "").toCharArray();

        Set<Character> firstStringSet = new TreeSet<>();

        Set<Character> secondStringSet = new TreeSet<>();

        for (char c : firstStringToCharArray)
        {
            firstStringSet.add(c);
        }

        for (char c : secondStringToCharArray)
        {
            secondStringSet.add(c);
        }

        firstStringSet.retainAll(secondStringSet);
        List<String> result = new ArrayList<>();
        firstStringSet.forEach(character -> {
            result.add(character.toString());
        });
        return result;
    }
    private  String commonChars(String str1, String str2) {
        StringBuilder commonChars = new StringBuilder();

        if (str1.length() > 0 & str2.length() > 0) {
            // We should iterate the smallest string in length.
            String toBeIterated = (str1.length() > str2.length() ? str2 : str1);
            // Once string to be iterated is finalized, get string to be checked
            String toBeChecked = toBeIterated.equals(str1) ? str2 : str1;

            // Iterating a string char by char
            for (int i = 0; i < toBeIterated.length(); i++) {
                // Check for common char
                if (toBeChecked.contains(Character.toString(toBeIterated.charAt(i)))) {
                    // If contains append it to resultant string
                    commonChars.append(Character.toString(toBeIterated.charAt(i)));
                }
            }
            return commonChars.toString();
        } else
            return "";
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
