import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        while (n != 0 || m != 0) {
            bw.write(print(n, m) + "\n");
            st = br.readLine().split(" ");
            n = Integer.parseInt(st[0]);
            m = Integer.parseInt(st[1]);
        }
        bw.close();
        br.close();
    }
    public static String print (int n, int m) {
        if (n % m == 0)
            return "multiple";
        if (m % n == 0)
            return "factor";
        return "neither";
    }
}
