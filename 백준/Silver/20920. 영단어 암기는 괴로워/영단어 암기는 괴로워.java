import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = getNumberArray(br);
        int n = input[0];
        int m = input[1];

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() < m) {
                continue;
            }

            int wordCount = map.getOrDefault(word, 0) + 1;

            map.put(word, wordCount);
        }

        String[] key = map.entrySet()
                .stream()
                .sorted(Entry.comparingByKey())
                .sorted((a, b) -> b.getKey().length() - a.getKey().length())
                .sorted((a, b) -> b.getValue() - a.getValue())
                .map(Entry::getKey)
                .toArray(String[]::new);


        for (int i = 0; i < key.length; i++) {
            bw.write(key[i]);
            if (i < n - 1) {
                bw.write("\n");
            }
        }

        br.close();
        bw.close();
    }

    private static int getInt(BufferedReader br) throws IOException {
        String input = br.readLine();
        return Integer.parseInt(input);
    }

    private static int[] getNumberArray(BufferedReader br) throws IOException {
        String input = br.readLine();
        String[] split = input.split(" ");
        return Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static InputMeetHumansName getInputMeetHumansName(BufferedReader br) throws IOException {
        String input = br.readLine();
        String[] split = input.split(" ");
        return new InputMeetHumansName(split[0], split[1]);
    }

    static class InputMeetHumansName {
        String first;
        String second;

        public InputMeetHumansName(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }
}
