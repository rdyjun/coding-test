import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int m;
        int c = 0;
        int sum = 0;
        int avg;
        int[] arr;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            arr = new int[m];
            for(int k = 0; k < m; k++){
                arr[k] = Integer.parseInt(st.nextToken());
                sum += arr[k];
            }
            avg = sum / m;
            for(int o = 0; o < m; o++){
                if(avg < arr[o])
                    c++;
            }

            bw.write(String.format("%.3f", (float)c / m * 100) + "%\n");
            sum = 0;
            c = 0;
        }


        bw.close();
    }
}