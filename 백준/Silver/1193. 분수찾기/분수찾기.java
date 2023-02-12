import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = Integer.parseInt(br.readLine());
        int i;
        int a;
        int b;

        for(i = 1; result > 0; i++){
            result -= i;
        }
        --i;
        result += i;

        if (i % 2 == 0){
            a = 1;
            b = i;
            for(int k = 1; k < result; k++){
                a++;
                b--;
            }
        } else {
            a = i;
            b = 1;
            for(int k = 1; k < result; k++){
                a--;
                b++;
            }
        }


        bw.write(a + "/" + b);
        bw.close();
    }
}