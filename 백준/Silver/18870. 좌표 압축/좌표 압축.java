import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        IO.init();

        String[] input = IO.read().split(" ");
        int n = Integer.parseInt(input[0]);

        input = IO.read().split(" ");
        int[] arr = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] sorted = Arrays.stream(arr)
                .distinct()
                .sorted()
                .toArray();

        Map<Integer, Integer> sequence = new HashMap<>();

        for(int i = sorted.length - 1; i >= 0; i--)
            sequence.put(sorted[i], i);

        for(int i : arr)
            IO.write(sequence.get(i) + " ");

        IO.close();
    }
}
class IO {
    private static BufferedReader br;
    private static BufferedWriter bw;
    public static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
    public static void close() throws IOException {
        bw.flush();
        bw.close();
        br.close();
    }
    public static String read() throws IOException {
        return br.readLine();
    }
    public static void write(String message) throws IOException {
        bw.write(message);
    }
}