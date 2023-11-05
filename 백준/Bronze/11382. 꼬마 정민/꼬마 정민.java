import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] st = br.readLine().split(" ");
        long sum = 0;
        for (String s : st) {
            sum += Long.parseLong(s);
        }
        bw.write(String.valueOf(sum));
        bw.close();
    }
}
