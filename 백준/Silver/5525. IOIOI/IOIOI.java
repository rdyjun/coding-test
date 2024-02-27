import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        IO.init();

        StringTokenizer input = new StringTokenizer(IO.read(), " ");
        int n = Integer.parseInt(input.nextToken());

        input = new StringTokenizer(IO.read(), " ");
        int m = Integer.parseInt(input.nextToken());

        input = new StringTokenizer(IO.read(), " ");
        String s = input.nextToken();

        int answer = 0;

        for(int i = 0; i < m; i++) {
            if(s.charAt(i) == 'O')
                continue;

            int k = 0;
            while(i < m - 2) {
                if(s.charAt(i + 1) != 'O' || s.charAt(i + 2) != 'I')
                    break;

                k++;
                i += 2;
            }

            if(k == 0 || k < n)
                continue;

            answer += k - n + 1;
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