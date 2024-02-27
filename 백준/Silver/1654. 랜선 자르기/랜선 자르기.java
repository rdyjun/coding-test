import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        IO.init();

        StringTokenizer input = new StringTokenizer(IO.read(), " ");
        int k = Integer.parseInt(input.nextToken());
        int n = Integer.parseInt(input.nextToken());

        int[] lines = new int[k];
        long max = 0;
        long min = 1;

        for(int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(IO.read());

            if(lines[i] > max)
                max = lines[i];
        }

        long answer = 0;
        long lanCableLength;
        while(min <= max) {
            lanCableLength = (max + min) / 2;
            int count = 0;

            for(int j = 0; j < k && count < n; j++)
                count += (int) (lines[j] / lanCableLength);

            if(count >= n) {
                min = lanCableLength + 1;

                if(lanCableLength > answer)
                    answer = lanCableLength;

                continue;
            }

            max = lanCableLength - 1;
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