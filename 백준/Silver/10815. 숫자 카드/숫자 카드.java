import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        IO.init();

        String[] input = IO.read().split(" ");
        int n = Integer.parseInt(input[0]);

        input = IO.read().split(" ");
        Set<Integer> arr = new HashSet<>();

        for(int i = 0; i < n; i++)
            arr.add(Integer.valueOf(input[i]));

        input = IO.read().split(" ");
        int m = Integer.parseInt(input[0]);

        input = IO.read().split(" ");

        for(int i = 0; i < m; i++) {
            if(arr.contains(Integer.parseInt(input[i]))) {
                IO.write("1 ");
                continue;
            }
            IO.write("0 ");
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