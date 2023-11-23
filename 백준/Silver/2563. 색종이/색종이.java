import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int range = Integer.parseInt(br.readLine());
        int[][] paper = new int[100][100];
        int answer = 0;
        for (int i = 0; i < range; i++) {
            String[] n = br.readLine().split(" ");
            int x = Integer.parseInt(n[0]);
            int y = 100 - Integer.parseInt(n[1]);
            for (int j = y; j > y - 10; j--) {
                for (int k = x; k < x + 10; k++) {
                    if (paper[j][k] == 0)
                        answer++;
                    paper[j][k] = 1;
                }
            }
        }
        bw.write(answer + "");

        bw.close();
        br.close();
    }
}