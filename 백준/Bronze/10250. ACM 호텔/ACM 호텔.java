import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int c = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int ans = 0;
        int h;
        int n;
        for(int i = 0; i < c; i++){
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            st.nextToken();
            n = Integer.parseInt(st.nextToken());

            if(n % h == 0){
                ans += h * 100;
            } else {
                ans += (n % h) * 100 + 1;
            }
            ans += n / h;

            bw.write(ans + "\n");
            ans = 0;
        }
        bw.close();
    }
}