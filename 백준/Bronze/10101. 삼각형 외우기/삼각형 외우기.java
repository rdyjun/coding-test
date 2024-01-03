import java.io.*;

public class Main {
    private static BufferedReader br;
    private static BufferedWriter bw;
    public static void main (String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[3];
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        if (sum != 180) {
            bw.write("Error");
            close();
            return;
        }
        if (arr[0] == arr[1]) {
            if (arr[1] == arr[2]) {
                bw.write("Equilateral");
                close();
                return;
            }
            bw.write("Isosceles");
            close();
            return;
        }
        if (arr[0] == arr[2]) {
            bw.write("Isosceles");
            close();
            return;
        }
        if (arr[1] == arr[2]) {
            bw.write("Isosceles");
            close();
            return;
        }
        bw.write("Scalene");
        close();
    }
    private static void close () throws IOException {
        bw.flush();
        bw.close();
        br.close();
    }
}

