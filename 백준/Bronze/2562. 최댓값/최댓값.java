import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = Integer.parseInt(br.readLine());
        int n = 1;
        for(int i = 2; i <= 9; i++){
            int a = Integer.parseInt(br.readLine());
            if(a > max) {
                max = a;
                n = i;
            }

        }
        bw.write(max + "\n" + n);
        bw.close();
    }
}