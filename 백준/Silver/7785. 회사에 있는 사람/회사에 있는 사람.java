import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        IO.init();

        String[] input = IO.read().split(" ");
        int n = Integer.parseInt(input[0]);

        Map<String, Boolean> stay = new HashMap<>();

        for(int i = 0; i < n; i++) {
            input = IO.read().split(" ");

            if(input[1].equals("leave")) {
                stay.remove(input[0]);
                continue;
            }
            stay.put(input[0], true);
        }

        String[] answer = stay.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Collections.reverseOrder()))
                .map(v -> v.getKey())
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