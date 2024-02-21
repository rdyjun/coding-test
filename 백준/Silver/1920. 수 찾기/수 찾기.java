import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        IO.init();

        String[] input = IO.read().split(" ");
        int n = Integer.parseInt(input[0]);
        int num;

        Set<String> set = new HashSet<>();

        input = IO.read().split(" ");
        for(int i = 0; i < n; i++)
            set.add(input[i]);

        input = IO.read().split(" ");
        int m = Integer.parseInt(input[0]);

        input = IO.read().split(" ");
        for(int i = 0; i < m; i++) {
            boolean flag = set.contains(input[i]);

            if(flag)
                IO.write("1");

            if(!flag)
                IO.write("0");

            if(i < m - 1)
                IO.write("\n");
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

    public static void write(Object message) throws IOException {
        bw.write(String.valueOf(message));
    }
}