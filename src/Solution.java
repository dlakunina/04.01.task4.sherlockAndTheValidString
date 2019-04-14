import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the isValid function below.
    static String isValid(String s) {
        Map<Character, Integer> charFrequencies = new HashMap<Character, Integer>();
        for (char ch : s.toCharArray()) {
            charFrequencies.merge(ch, 1, Integer::sum);
        }
        Collection<Integer> frequencies = charFrequencies.values();
        TreeMap<Integer, Integer> frequeOfFreque = new TreeMap<Integer, Integer>();
        for (Integer freque : frequencies) {
            frequeOfFreque.merge(freque, 1, Integer::sum);
        }
        if (frequeOfFreque.size() <= 1) {
            return "YES";
        }
        if (frequeOfFreque.size() != 2) {
            return "NO";
        }

        if (frequeOfFreque.firstKey() == 1 && frequeOfFreque.firstEntry().getValue() == 1)
            return "YES";
        if (frequeOfFreque.lastKey() - frequeOfFreque.firstKey() == 1 && frequeOfFreque.lastEntry().getValue() == 1) {
            return "YES";
        }

        return "NO";
    }


    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
