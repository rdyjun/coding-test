import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < 9; i++) {
            String[] score = br.readLine().split(" ");
            for (int k = 0; k < 9; k++) {
                int nowScore = Integer.parseInt(score[k]);
                if (nowScore > answer) {
                    answer = nowScore;
                    x = k;
                    y = i;
                }
            }
        }
        bw.write(answer + "\n");
        bw.write((y + 1) + " " + (x + 1));
        bw.close();
        br.close();
    }
}