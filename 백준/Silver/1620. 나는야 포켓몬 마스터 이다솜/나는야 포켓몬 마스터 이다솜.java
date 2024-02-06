import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        IO.init();

        String[] input = IO.read().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Map<String, Integer> Name = new HashMap<>();
        Map<Integer, String> number = new HashMap<>();

        int count = 1;

        for(int i = 0; i < n; i++) {
            input = IO.read().split(" ");

            Name.put(input[0], count);
            number.put(count, input[0]);

            count++;
        }

        int num;

        for(int i = 0; i < m; i++) {
            input = IO.read().split(" ");
            if((num = Name.getOrDefault(input[0], -1)) != -1) {
                IO.write(num + "\n");
                continue;
            }
            IO.write(number.get(Integer.parseInt(input[0])) + "\n");
        }

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