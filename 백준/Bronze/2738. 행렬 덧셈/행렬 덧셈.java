import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] answer = new int[n][m];
        for (int i = 0; i < n * 2; i++) {
            String[] value = br.readLine().split(" ");
            for (int k = 0; k < m; k++) {
                answer[i % n][k] += Integer.parseInt(value[k]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                bw.write(answer[i][k] + " ");
            }
            bw.write("\n");
        }
        bw.close();
        br.close();
    }
}