import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] b = new boolean[30];
        for(int i = 0; i < 28; i++){
            b[Integer.parseInt(br.readLine()) - 1] = true;
        }
        for(int i = 0; i < 30; i++){
            if(b[i] == false)
                bw.write(++i + "\n");
        }
        bw.close();
    }
}