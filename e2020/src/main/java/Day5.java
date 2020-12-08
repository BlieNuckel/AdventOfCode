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
            double row = findColRow(i, 127, 0, 7, false);
            double col = findColRow(i, 7, 7, 10, true);
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

    private double findColRow(String i, double high, int from, int to, boolean col) {
        double low = 0;
        double num = 0;
        for (int j = from; j < to; j++) {
            if (i.charAt(j) == (col ? 'R' : 'B')) {
                if (low == high - 1) num = high;
                else low += Math.ceil((high - low)/2);
            } else if (i.charAt(j) == (col ? 'L' : 'F')) {
                if (low == high - 1) num = low;
                else high -= Math.ceil((high - low)/2);
            }
        }
        return num;
    }
}
