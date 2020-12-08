import java.io.IOException;
import java.util.HashSet;

public class Day5 extends Advent{

    public static void main(String[] args) throws IOException {
        new Day5(5);
    }

    protected Day5(int day) throws IOException {
        super(day);
    }

    HashSet<Double> parsed;

    @Override
    protected void setup() {
        parsed = new HashSet<>();
        HashSet<String> tempSet = new HashSet<>(getInput());
        for (String i : tempSet) {
            double rowLow = 0;
            double rowHigh = 127;
            double row = 0;
            for (int j = 0; j < 7; j++) {
                if (i.charAt(j) == 'B') {
                    if (rowLow == rowHigh - 1) row = rowHigh;
                    else rowLow += Math.ceil((rowHigh - rowLow)/2);
                } else if (i.charAt(j) == 'F') {
                    if (rowLow == rowHigh - 1) row = rowLow;
                    else rowHigh -= Math.ceil((rowHigh - rowLow)/2);
                }
            }
            double colLow = 0;
            double colHigh = 7;
            double col = 0;
            for (int j = 7; j < 10; j++) {
                if (i.charAt(j) == 'R') {
                    if (colLow == colHigh - 1) col = colHigh;
                    else colLow += Math.ceil((colHigh - colLow)/2);
                } else if (i.charAt(j) == 'L') {
                    if (colLow == colHigh - 1) col = colLow;
                    else colHigh -= Math.ceil((colHigh - colLow)/2);
                }
            }
            parsed.add(row * 8 + col);
        }
    }

    @Override
    protected Object solveFirst() {
        double highest = 0;
        for (Double i : parsed) {
            if (i > highest) highest = i;
        }
        return highest;
    }

    @Override
    protected Object solveSecond() {
        double num = 0;
        for (double i = 0; i < 996; i++) {
            if (!parsed.contains(i)) {
                num = i;
            }
        }
        return num;
    }
}
