import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        IO.init();

        String[] input = IO.read().split(" ");
        int n = Integer.parseInt(input[0]);
        int[] dp = new int[n];

        input = IO.read().split(" ");
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(input[i]);


        for(int i = 0; i < n; i++) {
            for(int k = 0; k < i; k++)
                if(arr[i] > arr[k] && dp[k] > dp[i])
                    dp[i] = dp[k];
            dp[i]++;
        }

        int max = 0;

        for(int i : dp)
            if(i > max)
                max = i;

        IO.write(max);
        IO.close();
    }
}

class IO {
    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() throws IOException {
        bw.flush();
        bw.close();
        br.close();
    }

    public static String read() throws IOException {
        return br.readLine();
    }

    public static void write(Object message) throws IOException {
        bw.write(String.valueOf(message));
    }
}