import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        IO.init();

        int t = Integer.parseInt(IO.read());
        for(int i = 0; i < t; i++)
            answer();

        IO.close();
    }

    private static void answer() throws IOException {
        int k = Integer.parseInt(IO.read());
        StringTokenizer input;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i < k; i++) {
            input = new StringTokenizer(IO.read(), " ");
            String type = input.nextToken();
            int n = Integer.parseInt(input.nextToken());

            if(type.equals("I")) {
                map.put(n, map.getOrDefault(n, 0) + 1);
                continue;
            }

            if(map.size() == 0)
                continue;

            if(n == 1) {
                int m = map.lastEntry().getValue();
                if(m == 1) {
                    map.remove(map.lastKey());
                    continue;
                }
                map.put(map.lastKey(), m - 1);
            }

            if(n == -1) {
                int m = map.firstEntry().getValue();
                if(m == 1) {
                    map.remove(map.firstKey());
                    continue;
                }
                map.put(map.firstKey(), m - 1);
            }
        }

        if(map.isEmpty()) {
            IO.write("EMPTY\n");
            return;
        }

        int min = map.firstKey();
        int max = map.lastKey();

        IO.write(max + " " + min + "\n");
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

    public static void write(Object message) throws IOException {
        bw.write(String.valueOf(message));
    }
}