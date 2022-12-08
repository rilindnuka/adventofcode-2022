package day5;

import java.util.List;

public class Day5Column {
    private List<Day5Crate> crateList;

    public Day5Column(List<Day5Crate> crateList) {
        this.crateList = crateList;
    }

    public void addCrate(Day5Crate crate){
        crateList.add(crate);


    }

    public void addCrateWithCommand(Day5Crate crate){
        if (crateList.isEmpty()) {
            crateList.add(crate);
        } else {
            crateList.add(0, crate);
        }
    }

    public Day5Crate removeCrate(){
        return crateList.remove(0);
    }

    public Day5Crate getTopCrate(){
        return crateList.get(0);
    }

    @Override
    public String toString() {
        String result ="";
        for (int i = 0; i < crateList.size(); i++) {
            result += crateList.get(i).getValue()+"\n";

        }
        return result;
    }
}
