import java.io.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        String number = input[0];
        String bnry = input[1];
        int answer = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            char ch = number.charAt(i);
            if (ch >= '0' && ch <= '9') {
                answer += (ch - '0') * Math.pow(Integer.parseInt(bnry), number.length() - i - 1);
                continue;
            }
            answer += (ch - 'A' + 10) * Math.pow(Integer.parseInt(bnry), number.length() - i - 1);
        }
        
        bw.write(answer + "");
        bw.close();
        br.close();
    }
}