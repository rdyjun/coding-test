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
        int[][] arr = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            arr[i] = getNumberArray(br);
        }

        bw.write("" + dp(n, arr));

        br.close();
        bw.close();
    }

    private static int dp(int n, int[][] arr) {
        Square[][] dp = new Square[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][i] = new Square(arr[i][0], arr[i][1]);
        }

        for (int count = 2; count <= n; count++) {
            for (int from = 1; from <= n - count + 1; from++) {
                int to = from + count - 1;

                for (int mid = from; mid < to; mid++) {
                    Square left = dp[from][mid];
                    Square right = dp[mid + 1][to];
                    Square newSquare = left.matrixMultiply(right);
                    if (dp[from][to] != null && newSquare.value > dp[from][to].value) {
                        continue;
                    }

                    dp[from][to] = newSquare;
                }

            }
        }

        return dp[1][n].value;
    }

    static class Square {
        int x;
        int y;
        int value;

        public Square(int x, int y) {
            this.x = x;
            this.y = y;
            this.value = 0;
        }

        public Square(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public Square matrixMultiply(Square square) {
            int sum = this.value + square.value;
            int multiple = this.x * this.y * square.y;

            return new Square(this.x, square.y, sum + multiple);
        }
    }


    private static int getInt(BufferedReader br) throws IOException {
        String input = br.readLine();
        return Integer.parseInt(input);
    }

    private static int[] getNumberArray(BufferedReader br) throws IOException {
        String input = br.readLine();
        String[] split = input.split(" ");
        return Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
