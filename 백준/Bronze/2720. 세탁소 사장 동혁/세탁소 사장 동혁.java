import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[]{25, 10, 5, 1};
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int money = Integer.parseInt(br.readLine());
            for (double div : arr) {
                bw.write((int) (money / div) + " ");
                money %= div;
            }
            bw.write("\n");
        }
        bw.close();
        br.close();
    }
}
