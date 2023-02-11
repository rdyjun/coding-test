import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = Integer.parseInt(br.readLine());
        int c = 0;
        for(int i = 0; i < n; i++){
            if(Integer.parseInt(st.nextToken()) == result)
                c++;
        }
        bw.write(c + "\n");
        bw.close();
    }
}