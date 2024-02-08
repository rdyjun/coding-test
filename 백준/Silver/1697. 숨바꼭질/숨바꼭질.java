import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        IO.init();

        String[] input = IO.read().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int answer;
        int now = n;
        int count = 0;
        Set<Integer> duplicated = new HashSet<>();

        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> c = new LinkedList<>();
        q.add(now);
        c.add(count);

        while(true) {
            now = q.poll();
            count = c.poll();

            if(now == m) {
                answer = count;
                break;
            }

            count++;

            if(now < m) {
                if(!duplicated.contains(now * 2)) {
                    q.add(now * 2);
                    c.add(count);
                }

                if(!duplicated.contains(now + 1)) {
                    q.add(now + 1);
                    c.add(count);
                }
            }

            if(!duplicated.contains(now - 1)) {
                q.add(now - 1);
                c.add(count);
                duplicated.add(now - 1);
            }
        }

        IO.write(String.valueOf(answer));

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