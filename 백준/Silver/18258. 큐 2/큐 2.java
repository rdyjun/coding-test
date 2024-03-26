import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        IO.init();

        String[] input = IO.read()
                .split(" ");

        int n = Integer.parseInt(input[0]);
        Deque<Integer> deque = new LinkedList<>();

        while (n-- > 0) {
            input = IO.read()
                    .split(" ");

            if (input[0].equals("push")) {
                deque.add(Integer.valueOf(input[1]));
                continue;
            }

            if (input[0].equals("empty")) {
                if (deque.isEmpty()) {
                    IO.write("1\n");
                    continue;
                }

                IO.write("0\n");
                continue;
            }

            if (input[0].equals("size")) {
                IO.write(deque.size() + "\n");
                continue;
            }

            if (deque.isEmpty()) {
                IO.write("-1\n");
                continue;
            }

            if (input[0].equals("pop")) {
                IO.write(deque.pop() + "\n");
                continue;
            }

            if (input[0].equals("front")) {
                IO.write(deque.getFirst() + "\n");
                continue;
            }

            if (input[0].equals("back")) {
                IO.write(deque.getLast() + "\n");
                continue;
            }

            throw new IllegalArgumentException("값 오류");

        }
        IO.close();
    }

}

class IO {

    private static BufferedReader reader;

    private static BufferedWriter writer;

    public static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() {
        try {
            writer.flush();
            writer.close();
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String read() {
        String input = null;
        try {
            input = reader.readLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (input == null) {
            throw new IllegalArgumentException();
        }

        return input;
    }

    public static void write(Object message) {
        try {
            writer.write(String.valueOf(message));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
