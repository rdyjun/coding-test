import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        IO.init();

        int n = Integer.parseInt(IO.read());
        long m = 0L;
        for(int i = 0; i < n - 1; i++)
            for(int k = i + 1; k < n; k++)
                m++;

        IO.write(m + "\n2");
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