import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        float[] arr = new float[n];
        arr[0] = Integer.parseInt(st.nextToken());
        int max = (int) arr[0];
        float sum = 0;
        for(int i = 1; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > max)
                max = (int) arr[i];
        }
        for(int i = 0; i < arr.length; i++){
            arr[i] = arr[i] * 100 / max ;
            sum += arr[i];
        }
        bw.write(sum / arr.length + "\n");
        bw.close();
    }
}