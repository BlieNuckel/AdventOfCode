import java.io.IOException;
import java.util.*;

public class Day4 extends Advent{

    protected Day4(int day) throws IOException {
        super(day);
    }

    public static void main(String[] args) throws IOException {
        new Day4(4);
    }

    HashSet<Map<String, String>> parsedId;

    // 212 < x < 241
    @Override
    protected void setup() {
        List<String> tempList = getInput();
        tempList.add("");
        parsedId = new HashSet<>();
        HashMap<String, String> idMap = new HashMap<>();
        for (String i : tempList) {
            if (i.equals("")) {
                parsedId.add(idMap);
                idMap = new HashMap<>();
            } else {
                for (String j : i.strip().split(" ")) {
                    idMap.put(j.split(":")[0], j.split(":")[1]);
                }
            }
        }

    }

    @Override
    protected Object solveFirst() {
        final HashSet<String> REQUIRED_FIELDS = new HashSet<>(List.of("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));
        int count = 0;
        for (Map<String, String> i : parsedId) {
            if (i.keySet().containsAll(REQUIRED_FIELDS)) {
                count++;
            }
        }
        return count;
    }

    @Override
    protected Object solveSecond() {
        return null;
    }
}
