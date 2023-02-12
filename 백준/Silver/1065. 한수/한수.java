import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(hansu(Integer.parseInt(br.readLine())) + "\n");
        bw.close();
    }
    static int hansu(int num){
        int c = 99;

        if(num < 99)
            return num;
        else
            for(int i = 100; i <= num; i++){
                int f = i / 100;
                int s = i / 10 % 10;
                int t = i % 10;

                if(f - s == s - t){
                    c++;
                }
            }

        return c;
    }
}