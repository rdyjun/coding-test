import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        IO.init();

        String[] input = IO.read().split(" ");
        int n = Integer.parseInt(input[0]);

        int a = 1;
        int b = 2;
        int tmp;

        for(int i = 2; i < n; i++) {
            tmp = b;
            b = (a + b) % 15746;
            a = tmp;
        }

        int answer = b;

        if(n == 1)
            answer = a;

        IO.write(String.valueOf(answer));

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