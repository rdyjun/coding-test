import java.io.*;

public class Main {
    static int d(int h, int w){
        if(w == 1)
            return 1;
        else if(h == 0)
            return w;

        return d(h - 1, w) + d(h, w - 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int h;
        int w;

        for(int i = 0; i < t; i++){
            h = Integer.parseInt(br.readLine());
            w = Integer.parseInt(br.readLine());
            bw.write(d(h, w) + "\n");
        }
        bw.close();
    }
}