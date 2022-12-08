package day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RuckSackBadge {
    private List<DayThreeRuckSack> ruckSacks;

    public RuckSackBadge(List<DayThreeRuckSack> ruckSacks) {
        this.ruckSacks = ruckSacks;
    }

    public String getBadge(){
        return printCommonChars(ruckSacks.get(0).getInput(),ruckSacks.get(1).getInput(),ruckSacks.get(2).getInput()).get(0);
    }
    private static List<String> printCommonChars(String firstString, String secondString, String thirdString)
    {
        char[] firstStringToCharArray = firstString.replaceAll("\\s+", "").toCharArray();

        char[] secondStringToCharArray = secondString.replaceAll("\\s+", "").toCharArray();

        char[] thirdStringToCharArray = thirdString.replaceAll("\\s+", "").toCharArray();

        Set<Character> firstStringSet = new TreeSet<>();

        Set<Character> secondStringSet = new TreeSet<>();

        Set<Character> thirdStringSet = new TreeSet<>();

        for (char c : firstStringToCharArray)
        {
            firstStringSet.add(c);
        }

        for (char c : secondStringToCharArray)
        {
            secondStringSet.add(c);
        }

        for (char c : thirdStringToCharArray){
            thirdStringSet.add(c);
        }

        firstStringSet.retainAll(secondStringSet);
        firstStringSet.retainAll(thirdStringSet);
        List<String> result = new ArrayList<>();
        firstStringSet.forEach(character -> {
            result.add(character.toString());
        });
        return result;
    }
}
