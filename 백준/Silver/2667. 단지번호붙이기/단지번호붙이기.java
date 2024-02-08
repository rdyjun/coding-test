import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static int n;
    private static int[][] arr;
    private static boolean[][] visited;
    private static List<Integer> answer;
    public static void main(String[] args) throws IOException {
        IO.init();

        String[] input = IO.read().split(" ");
        n = Integer.parseInt(input[0]);
        arr = new int[n][n];
        visited = new boolean[n][n];
        answer = new ArrayList<>();

        for(int row = 0; row < n; row++) {
            input = IO.read().split("");
            for(int column = 0; column < n; column++)
                arr[row][column] = Integer.parseInt(input[column]);
        }

        for(int row = 0; row < n; row++) {
            for(int column = 0; column < n; column++) {
                if(visited[row][column])
                    continue;

                if(arr[row][column] > 0)
                    answer.add(paint(row, column));
            }
        }

        IO.write(answer.size() + "\n");

        answer.sort(Comparator.comparingInt(v -> v));

        for(int count : answer)
            IO.write(count + "\n");

        IO.close();
    }
    private static int paint(int row, int column) {
        if(visited[row][column] || arr[row][column] == 0)
            return 0;

        visited[row][column] = true;

        int result = 1;

        if(row > 0)
            result += paint(row - 1, column);
        if(row < n - 1)
            result += paint(row + 1, column);
        if(column > 0)
            result += paint(row, column - 1);
        if(column < n - 1)
            result += paint(row, column + 1);

        return result;
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