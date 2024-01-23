import java.io.*;
import java.util.Arrays;

public class Main {
    private static BufferedReader br;
    private static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        init();
        String input = br.readLine();
        int len = input.length();
        int[] arr = new int[len];
        for(int i = 0; i < len; i++)
            arr[i] = input.charAt(i) - '0';
        Arrays.sort(arr);
        for(int i = len - 1; i >= 0; i--)
            bw.write(arr[i] + "");
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