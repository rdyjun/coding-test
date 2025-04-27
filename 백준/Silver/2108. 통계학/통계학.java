import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        // 산술평균
        int sum = Arrays.stream(array)
                .sum();

        bw.write(Math.round((float) sum / n) + "\n");

        // 중앙값
        int[] sorted = Arrays.stream(array)
               .sorted()
               .toArray();

        bw.write(sorted[n / 2] + "\n");

        // 최빈값
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int count = map.getOrDefault(array[i], 0) + 1;
            map.put(array[i], count);
            if (count > max) {
                max = count;
            }
        }

        int maxmax = max;

        int[] moderate = map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxmax)
                .sorted(Comparator.comparingInt(Entry::getKey))
                .mapToInt(Entry::getKey)
                .toArray();

        if (moderate.length > 1) {
            bw.write(moderate[1] + "\n");
        } else {
            bw.write(moderate[0] + "\n");
        }

        // 최댓값과 최솟값의 차이
        bw.write(sorted[n - 1] - sorted[0] + "");

        br.close();
        bw.close();
    }

}
