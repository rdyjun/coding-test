import java.io.*;

public class Main {
    private static BufferedReader br;
    private static BufferedWriter bw;
    public static void main (String[] args) throws IOException {
        init();
        bw.write("1\n0");
        close();
    }
    private static void init () {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
    private static void close () throws IOException {
        bw.flush();
        bw.close();
        br.close();
    }
}