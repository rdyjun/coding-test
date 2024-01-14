import java.io.*;

public class Main {
    private static BufferedReader br;
    private static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        init();
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        int d = Integer.parseInt(input[3]);
        int e = Integer.parseInt(input[4]);
        int f = Integer.parseInt(input[5]);
        int x, y;
        for(x = -999; x <= 999; x++) {
            int n = a * x;
            for(y = -999; y <= 999; y++) {
                int m = b * y;
                if(n + m == c && d * x + e * y == f) {
                    bw.write(x + " " + y);
                    close();
                    return;
                }
            }
        }
        close();
    }
    private static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
    private static void close() throws IOException {
        bw.flush();
        bw.close();
        br.close();
    }
}