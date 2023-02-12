import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int ans = -1;
        loop1:
        for(int i = 0; i <= n / 3; i++){
            for(int k = 0; k * 5 + i * 3 <= n; k++){
                if((i * 3) + (k * 5) == n) {
                    ans = i + k;
                    break loop1;
                }
            }
        }
        bw.write(ans + "");
        bw.close();
    }
}
