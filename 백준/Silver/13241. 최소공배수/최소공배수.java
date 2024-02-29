import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        IO.init();

        getLeastCommonMultiple();

        IO.close();
    }

    private static void getLeastCommonMultiple() throws IOException {
        StringTokenizer input = new StringTokenizer(IO.read());
        long a = Long.parseLong(input.nextToken());
        long b = Long.parseLong(input.nextToken());
        long min = Math.min(a, b);

        long leastCommonMultiple = 1;

        for(int divide = 2; divide <= min; divide++) {
            if(a % divide != 0 || b % divide != 0) {
                continue;
            }

            leastCommonMultiple *= divide;
            a /= divide;
            b /= divide;
            divide--;
        }

        leastCommonMultiple *= a * b;

        IO.write(leastCommonMultiple);
    }
}

class IO {
    private static BufferedReader reader;
    private static BufferedWriter writer;

    public static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() throws IOException {
        writer.flush();
        writer.close();
        reader.close();
    }

    public static String read() throws IOException {
        return reader.readLine();
    }

    public static void write(Object message) throws IOException {
        writer.write(String.valueOf(message));
    }
}
