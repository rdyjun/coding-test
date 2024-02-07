import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        IO.init();

        String[] input = IO.read().split(" ");
        int n = Integer.parseInt(input[0]);

        input = IO.read().split(" ");

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++)
            map.put(input[i], map.getOrDefault(input[i], 0) + 1);

        input = IO.read().split(" ");
        int m = Integer.parseInt(input[0]);

        input = IO.read().split(" ");

        for(int i = 0; i < m; i++)
            IO.write(map.getOrDefault(input[i], 0) + " ");

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