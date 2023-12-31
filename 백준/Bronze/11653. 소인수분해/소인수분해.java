import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int d;
        while (n > 1) {
            d = getDivideNum(n);
            bw.write(d + "\n");
            n /= d;
        }
        bw.close();
        br.close();
    }
    private static int getDivideNum (int n) {
        for (int i = 2; i <= n; i++)
            if (n % i == 0)
                return i;
        return 1;
    }
}