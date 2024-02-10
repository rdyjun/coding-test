import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        IO.init();

        String[] input = IO.read().split(" ");
        int n = Integer.parseInt(input[0]);
        int[] arr = new int[n];

        input = IO.read().split(" ");
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(input[i]);

        for(int i = 0; i < n; i++) {
            for(int k = i + 1; k < n; k++) {
                int num = arr[k - i - 1] + arr[i];

                if(arr[k] < num)
                    arr[k] = num;
            }
        }

        IO.write(String.valueOf(arr[n - 1]));

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

    public static void write(String message) throws IOException {
        bw.write(message);
    }
}