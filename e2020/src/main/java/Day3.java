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
        int count = -1;
        for (String i : getInput()) {
            parsed[++count] = i.toCharArray();
        }
    }

    protected Object solveFirst() {
        //0.0, 1.3, 2.6
        int treeCount = 0;
        int hor = 0;
        int ver = 0;
        for (; ver < parsed.length; ver++) {
            if (hor >= parsed[ver].length) {
                hor = hor-parsed[ver].length;
            }
            if (parsed[ver][hor] == '#') treeCount++;
            hor += 3;
        }

        return treeCount;
    }

    protected Object solveSecond() {
        return null;
    }
}

