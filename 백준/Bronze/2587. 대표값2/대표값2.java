import java.io.*;
import java.util.Arrays;

public class Main {
    private static BufferedReader br;
    private static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        init();
        int sum = 0;
        int[] arr = new int[5];
        for(int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);
        bw.write(sum / 5 + "\n");
        bw.write(arr[2] + "");
        close();
    }
    private static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
    private static void close() throws IOException {
        bw.flush();
        bw.close();
        br.close();
    }
}