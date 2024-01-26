import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        IO.init();
        int answer = 0;

        int n = Integer.parseInt(IO.read());
        int[] buildings = new int[n];
        int[] showing = new int[n];

        StringTokenizer input = new StringTokenizer(IO.read());

        for(int i = 0; i < n; i++)
            buildings[i] = Integer.parseInt(input.nextToken());

        for(int i = 0; i < n; i++) {
            showing[i] += showBuildings(i, buildings, 1); // 오른쪽
            showing[i] += showBuildings(i, buildings, -1); // 왼쪽
        }

        answer = Arrays.stream(showing)
                .max()
                .orElse(0);

        IO.write(String.valueOf(answer));
        IO.close();
    }
    private static int showBuildings(int now, int[] buildings, int side) {
        int x = now;
        int y = buildings[now];
        int len = buildings.length;
        int count = 0;
        double angle;
        double max = 0;

        for(int i = now + side; i >= 0 && i < len; i += side) {
            angle = Math.abs(Math.atan2(x - i, y - buildings[i]));
            if(angle > max) {
                count++;
                max = angle;
            }
        }
        return count;
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