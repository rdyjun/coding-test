import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.startsWith("1")) {
                int value = Integer.parseInt(input.split(" ")[1]);
                deque.push(value);

                continue;
            }

            if (input.startsWith("2")) {
                int value = Integer.parseInt(input.split(" ")[1]);
                deque.add(value);

                continue;
            }

            if (input.startsWith("3")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque.poll() + "\n");
                }

                continue;
            }

            if (input.startsWith("4")) {
                if (deque.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(deque.removeLast() + "\n");
                }

                continue;
            }

            if (input.startsWith("5")) {
                bw.write(deque.size() + "\n");
                continue;
            }

            if (input.startsWith("6")) {
                if (deque.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }

                continue;
            }

            if (input.startsWith("7")) {
                if (!deque.isEmpty()) {
                    bw.write(deque.peekFirst() + "\n");
                } else {
                    bw.write("-1\n");
                }

                continue;
            }

            if (input.startsWith("8")) {
                if (!deque.isEmpty()) {
                    bw.write(deque.peekLast() + "\n");
                } else {
                    bw.write("-1\n");
                }
            }
        }
        bw.close();
    }
}
