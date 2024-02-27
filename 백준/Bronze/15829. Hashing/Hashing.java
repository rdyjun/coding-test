import java.io.*;

public class Main {

    private static final int m = 1234567891;

    public static void main(String[] args) throws IOException {
        IO.init();

        long answer = 0L;
        int n = Integer.parseInt(IO.read());
        String s = IO.read();

        long pow = 1;

        for(int i = 0; i < n; i++) {
            answer += (s.charAt(i) - 'a' + 1) * pow;
            pow = (pow * 31) % m;
        }

        IO.write(answer % m);
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