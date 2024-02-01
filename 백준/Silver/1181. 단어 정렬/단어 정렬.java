import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        IO.init();

        String input = IO.read();
        int n = Integer.parseInt(input);

        Set<String> words = new HashSet<>();

        for(int i = 0; i < n; i++) {
            input = IO.read();
            words.add(input);
        }

        String[] answer = words.stream()
                .sorted(Comparator.comparingInt((String v) -> v.length())
                        .thenComparing(v -> v))
                .toArray(String[]::new);

        for(String word : answer)
            IO.write(word + "\n");

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