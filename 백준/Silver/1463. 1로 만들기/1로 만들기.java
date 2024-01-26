import java.io.*;

public class Main {
    private static int answer = -1;
    public static void main(String[] args) throws IOException {
        IO.init();

        int x = Integer.parseInt(IO.read());

        dfs(x, 0);

        IO.write(String.valueOf(answer));
        IO.close();
    }
    private static void dfs(int x, int count) {
        if(answer != -1 && count >= answer)
            return;
        if(x == 1) {
            updateAnswer(count);
            return;
        }

        if(x % 3 == 0)
            dfs(x / 3, count + 1);
        if(x % 2 == 0)
            dfs(x / 2, count + 1);
        dfs(x - 1, count + 1);
    }
    private static void updateAnswer(int count) {
        if(answer == -1 || count < answer)
            answer = count;
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