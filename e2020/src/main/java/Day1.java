import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Day1 extends Advent{

    public static void main(String[] args) throws IOException {
        new Day1(1);
    }

    protected Day1(int day) throws IOException {
        super(day);
    }

    Set<Integer> parsedIntegers = new HashSet<>();

    @Override
    protected void setup() {
        parsedIntegers = getInput().stream().map(Integer::parseInt).collect(Collectors.toSet());
    }

    @Override
    protected Object solveFirst() {
        for (Integer i : parsedIntegers) {
            for (Integer j : parsedIntegers) {
                if (i + j == 2020) {
                    return i * j;
                }
            }
        }
        return null;
    }

    @Override
    protected Object solveSecond() {
        return null;
    }
}