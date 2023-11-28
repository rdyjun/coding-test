import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int num = Integer.parseInt(input[0]);
        int bnry = Integer.parseInt(input[1]);
        while (num > 0) {
            int n = num % bnry;
            if (n > 9)
                sb.append((char)(n + 'A' - 10));
            if (n < 10)
                sb.append(n);
            num /= bnry;
        }
        sb.reverse();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}