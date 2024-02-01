import java.io.*;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        IO.init();

        String[] input = IO.read().split(" ");
        int n = Integer.parseInt(input[0]);

        int[] age = new int[n];
        String[] name = new String[n];

        for(int i = 0; i < n; i++) {
            input = IO.read().split(" ");
            age[i] = Integer.parseInt(input[0]);
            name[i] = input[1];
        }

        int[] index = IntStream.range(0, n)
                .boxed()
                .sorted(Comparator.comparingInt((Integer v) -> age[v]))
                .mapToInt(v -> v)
                .toArray();

        for(int i : index)
            IO.write(age[i] + " " + name[i] + "\n");

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