import java.io.IOException;
import java.util.List;

public class Day2 extends Advent{

    public static void main(String[] args) throws IOException {
        new Day2(2);
    }

    protected Day2(int day) throws IOException {
        super(day);
    }

    List<String> parsedSet;

    @Override
    protected void setup() {
        parsedSet = getInput();
    }

    @Override
    protected Object solveFirst() {
        int realCount = 0;
        for (String i: parsedSet) {
            int lowerLim = Integer.parseInt(i.split(":")[0].split("-")[0]);
            int upperLim = Integer.parseInt(i.split(":")[0].split("-")[1].split(" ")[0]);
            char required = i.split(":")[0].split(" ")[1].charAt(0);

            int count = 0;
            for (char c : i.split(" ")[2].toCharArray()) {
                if (c == required) {
                    count++;
                }
            }
            if (lowerLim <= count && count <= upperLim) {
                realCount++;
            }
        }
        return realCount;
    }

    @Override
    protected Object solveSecond() {
        int realCount = 0;
        for (String i: parsedSet) {
            int firstPlace = Integer.parseInt(i.split(":")[0].split("-")[0]);
            int secondPlace = Integer.parseInt(i.split(":")[0].split("-")[1].split(" ")[0]);
            char required = i.split(":")[0].split(" ")[1].charAt(0);

            if (i.split(" ")[2].charAt(firstPlace - 1) == required ^ i.split(" ")[2].charAt(secondPlace - 1) == required) {
                realCount++;
            }
        }
        return realCount;
    }
}
