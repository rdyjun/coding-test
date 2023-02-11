import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = Integer.parseInt(br.readLine());
        int c;
        int n = result;
        int sum = n % 10 + n / 10;
        n = (n > 9 ? n % 10 : n) * 10 + (sum > 9 ? sum % 10 : sum);
        for(c = 1; n != result; c++){
            sum = n % 10 + n / 10;
            n = (n > 9 ? n % 10 : n) * 10 + (sum > 9 ? sum % 10 : sum);
        }
        bw.write(c + "\n");
        bw.close();
    }
}