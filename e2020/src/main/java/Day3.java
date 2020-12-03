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
        return treeFind(1, 3);
    }

    protected Object solveSecond() {
        return treeFind(1, 1) * treeFind(1, 3) * treeFind(1, 5) *
                treeFind(1, 7) * treeFind(2, 1);
    }

    protected long treeFind(int verDiff, int horDiff) {
        long treeCount = 0;
        int hor = 0;
        int ver = 0;
        for (; ver < parsed.length; ver += verDiff) {
            if (hor >= parsed[ver].length) {
                hor = hor-parsed[ver].length;
            }
            if (parsed[ver][hor] == '#') treeCount++;
            hor += horDiff;
        }
        return treeCount;
    }
}

