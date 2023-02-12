import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = a - Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int c = 1;
        c += (v - a) / b;
        if((v - a) % b != 0)
            c++;


        bw.write(c + "\n");
        bw.close();
    }
}