import java.io.IOException;

public class Day3 extends Advent{

    public static void main(String[] args) throws IOException {
        new Day3(3);
    }

    protected Day3(int day) throws IOException {
        super(day);
    }

    char[][] parsed;

    protected void setup() {
        parsed = new char[getInput().size()][];
        int count = 0;
        for (String i : getInput()) {
            parsed[++count] = i.toCharArray();
        }
    }

    protected Object solveFirst() {
        return null;
    }

    protected Object solveSecond() {
        return null;
    }
}

