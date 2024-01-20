import java.io.*;
import java.util.Arrays;

public class Main {
    private static BufferedReader br;
    private static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        init();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int limit = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(input[i]);

        Arrays.sort(arr);
        bw.write(arr[n - limit] + "");
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