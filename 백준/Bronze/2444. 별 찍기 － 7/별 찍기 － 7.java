import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            for (int k = 0; k < n - i; k++)
                bw.write(" ");
            for (int k = 0; k < i * 2 - 1; k++)
                bw.write("*");
            bw.write("\n");
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int k = 0; k < n - i; k++)
                bw.write(" ");
            for (int k = 0; k < i * 2 - 1; k++)
                bw.write("*");
            bw.write("\n");
        }

        bw.close();
        br.close();
    }
}