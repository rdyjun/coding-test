import java.io.*;

public class Main {
    private static BufferedReader br;
    private static BufferedWriter bw;
    public static void main (String[] args) throws IOException {
        init();
        String[] input = br.readLine().split(" ");
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++)
            arr[i] = Integer.parseInt(input[i]);
        int max = getMax(arr);
        int n = arr[0] + arr[1] + arr[2] - max;
        if (n <= max)
            max -= max - n + 1;
        bw.write(n + max + "");
        close();
    }
    private static int getMax (int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (max < arr[i])
                max = arr[i];
        return max;
    }
    private static void init () {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
    private static void close () throws IOException {
        bw.flush();
        bw.close();
        br.close();
    }
}