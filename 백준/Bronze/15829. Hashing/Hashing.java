import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        IO.init();

        long answer = 0;

        StringTokenizer input = new StringTokenizer(IO.read(), " ");
        int n = Integer.parseInt(input.nextToken());

        input = new StringTokenizer(IO.read(), " ");
        String s = input.nextToken();

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int num = c - 'a' + 1;

            answer += (num * Math.pow(31, i));
            answer %= 1234567891;
        }

        IO.write(answer);
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