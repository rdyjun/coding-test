import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());

            boolean[] array = new boolean[m + 1];
            for (int j = 2; j <= m; j++) {
                if (array[j]) {
                    continue;
                }

                for (int k = j * 2; k <= m; k += j) {
                    array[k] = true;
                }
            }

            int amount = 0;

            for (int k = 2; k <= m / 2; k++) {
                if (array[m - k] || array[k]) {
                    continue;
                }

                amount++;
            }

            answer[i] = String.valueOf(amount);
        }

        bw.write(String.join("\n", answer));

        br.close();
        bw.close();
    }

}
