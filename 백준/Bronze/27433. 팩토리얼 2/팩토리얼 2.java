import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(
                br.readLine());

        long answer = n;
        for (int i = n - 1; i >= 1; i--) {
            answer *= i;
        }

        if (answer == 0) {
            bw.write("1");
        } else {
            bw.write(answer + "");
        }

        br.close();
        bw.close();
    }

}
