import java.io.*;

public class Main {
    private static BufferedReader br;
    private static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        init();
        String input = br.readLine();
        int num = Integer.parseInt(input);
        int answer = 666;
        int count = 0;
        while(true) {
            if(String.valueOf(answer).contains("666"))
                count++;
            if(count == num)
                break;
            answer++;
        }
        bw.write(answer + "");
        close();
    }
    private static int isSix(int n) {
        int m = 0;
        while(n > 0) {
            if(n % 10 != 6)
                return m;
            m++;
            n /= 10;
        }
        return m;
    }
    private static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
    private static void close() throws IOException {
        bw.flush();
        bw.close();
        br.close();
    }
}