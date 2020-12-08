import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        int count = 0;
        final HashSet<String> EYE_COLORS = new HashSet<>(List.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth"));
        final HashSet<String> REQUIRED_FIELDS = new HashSet<>(List.of("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"));
        for (Map<String, String> i : parsedId) {
            int c = 0;
            if (i.keySet().containsAll(REQUIRED_FIELDS)) {
                if (Integer.parseInt(i.get("byr")) >= 1920 && Integer.parseInt(i.get("byr")) <= 2002) {
                    c++;
                }
                if (Integer.parseInt(i.get("iyr")) >= 2010 && Integer.parseInt(i.get("iyr")) <= 2020) {
                    c++;
                }
                if (Integer.parseInt(i.get("eyr")) >= 2020 && Integer.parseInt(i.get("eyr")) <= 2030) {
                    c++;
                }
                if (i.get("hgt").startsWith("cm", i.get("hgt").length() - 2)) {
                    if (Integer.parseInt(i.get("hgt").split("[^0-9]+")[0]) >= 150 && Integer.parseInt(i.get("hgt").split("[^0-9]+")[0]) <= 193) {
                        c++;
                    }
                } else if (i.get("hgt").startsWith("in", i.get("hgt").length() - 2)) {
                    if (Integer.parseInt(i.get("hgt").split("[^0-9]+")[0]) >= 59 && Integer.parseInt(i.get("hgt").split("[^0-9]+")[0]) <= 76) {
                        c++;
                    }
                }
                if (Pattern.matches("#\\p{XDigit}{6}", i.get("hcl"))) {
                    c++;
                }
                if (EYE_COLORS.contains(i.get("ecl"))) {
                    c++;
                }
                if (Pattern.matches("\\d{9}", i.get("pid"))) {
                    c++;
                }
            }
            if (c == 7) {
                count++;
            }
        }
        return count;
    }
}
