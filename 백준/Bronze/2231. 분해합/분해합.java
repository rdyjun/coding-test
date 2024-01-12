import java.io.*;

public class Main {
    private static BufferedReader br;
    private static BufferedWriter bw;
    public static void main (String[] args) throws IOException {
        init();
        String input = br.readLine();
        int n = Integer.parseInt(input);
        int len = input.length();
        len = n - len * 9 - (input.charAt(0) - '0');
        int answer = 0;
        for(int i = n - 1; i >= len; i--) {
            int m = getSum(i);
            if(m == n)
                answer = i;
        }
        bw.write(answer + "");
        close();
    }
    private static int getSum(int n) {
        int sum = n;
        while(n >= 1) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    private static void init () {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
    private static void close () throws IOException {
        bw.flush();
        bw.close();
        br.close();
    }
}