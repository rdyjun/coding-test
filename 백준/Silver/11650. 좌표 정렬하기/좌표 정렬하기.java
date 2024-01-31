import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        IO.init();

        String[] input = IO.read().split(" ");
        int n = Integer.parseInt(input[0]);

        int[] x = new int[n];
        int[] y = new int[n];

        for(int i = 0; i < n; i++) {
            input = IO.read().split(" ");
            x[i] = Integer.parseInt(input[0]);
            y[i] = Integer.parseInt(input[1]);
        }

        int[] answerIndex = IntStream.range(0, n)
                .boxed()
                .sorted(Comparator.comparingInt((Integer v) -> x[v])
                        .thenComparingInt(v -> y[v]))
                .mapToInt(v -> v)
                .toArray();

        for(int index : answerIndex)
            IO.write(x[index] + " " + y[index] + "\n");

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