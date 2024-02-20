import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        IO.init();

        String input = IO.read();
        int n = Integer.parseInt(input);

        for(int i = 0; i < n; i++) {
            input = IO.read();
            if(validateBracket(input)) {
                IO.write("YES\n");
                continue;
            }
            IO.write("NO\n");
        }

        IO.close();
    }

    private static boolean validateBracket(String bracket) {
        char[] brackets = bracket.toCharArray();
        int n = 0;

        for(char c : brackets) {
            if(c == '(') {
                n++;
                continue;
            }

            if(n == 0)
                return false;

            n--;
        }

        if(n > 0)
            return false;

        return true;
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