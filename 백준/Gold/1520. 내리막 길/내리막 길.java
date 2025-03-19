import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] dp;
    static int[][] array;
    static int height;
    static int width;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = getNumberArray(br);

        height = input[0];
        width = input[1];

        array = new int[height][width];
        for (int i = 0; i < height; i++) {
            array[i] = getNumberArray(br);
        }

        dp = new int[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[height - 1][width - 1] = 1;

        bw.write(dfs(0, 0) + "");

        br.close();
        bw.close();
    }

    private static int dfs(int y, int x) {
        if (dp[y][x] > -1) {
            return dp[y][x];
        }
        int count = 0;

        for (int direction = 0; direction < 4; direction++) {
            int nextY = y + dir[direction][0];
            int nextX = x + dir[direction][1];

            if (nextX < 0 || nextX >= width || nextY < 0 || nextY >= height || array[nextY][nextX] >= array[y][x]) {
                continue;
            }

            count += dfs(nextY, nextX);
        }

        dp[y][x] = count;

        return count;
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
