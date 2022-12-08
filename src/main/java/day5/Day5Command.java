package day5;

public class Day5Command {
    private Integer howMany;
    private Integer from;
    private Integer to;

    public Day5Command(String input){
//        move 10 from 9 to 8
        String[] fields = input.split(" ");
        howMany = Integer.parseInt(fields[1]);
        from = Integer.parseInt(fields[3]);
        to = Integer.parseInt(fields[5]);
    }

    public Integer getHowMany() {
        return howMany;
    }

    public void setHowMany(Integer howMany) {
        this.howMany = howMany;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }
}
