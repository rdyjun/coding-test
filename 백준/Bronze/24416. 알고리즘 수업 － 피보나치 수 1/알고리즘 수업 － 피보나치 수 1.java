import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = getInt(br);

        bw.write(dfs(n) + " ");
        bw.write((n - 2) + "");

        br.close();
        bw.close();
    }

    private static int dfs(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }

        return dfs(num - 1) + dfs(num - 2);
    }

    private static int getInt(BufferedReader br) throws IOException {
        String input = br.readLine();
        return Integer.parseInt(input);
    }

}
