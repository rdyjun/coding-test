import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        IO.init();

        String[] input;
        int t = Integer.parseInt(IO.read());

        for(int i = 0; i < t; i++) {
            input = IO.read().split(" ");
            long a = Integer.parseInt(input[0]);
            long b = Integer.parseInt(input[1]);
            long min = Math.min(a, b);
            long max = Math.max(a, b);

            for(int k = 1; k <= max; k++) {
                long n = min * k;
                if(n >= max && n % max == 0) {
                    IO.write(n + "\n");
                    break;
                }
            }
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