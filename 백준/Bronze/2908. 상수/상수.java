import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String[] numbers = str.split(" ");
        String answer = numbers[0];
        for (int i = 2; i >= 0; i--) {
            char a = numbers[0].charAt(i);
            char b = numbers[1].charAt(i);

            if (a > b) {
                answer = numbers[0];
                break;
            }
            if (a < b) {
                answer = numbers[1];
                break;
            }
        }
        for (int i = 2; i >= 0; i--)
            bw.write(answer.charAt(i) + "");
        br.close();
        bw.close();
    }
}