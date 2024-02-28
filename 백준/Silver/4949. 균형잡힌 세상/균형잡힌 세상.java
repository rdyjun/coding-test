import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        IO.init();

        String input = IO.read();

        while (!input.equals(".")) {
            result(input);
            input = IO.read();
        }

        IO.close();
    }

    private static void result(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.add('(');
                continue;
            }

            if (c == '[') {
                stack.add('[');
                continue;
            }

            if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    IO.write("no\n");
                    return;
                }

                stack.pop();
            }

            if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    IO.write("no\n");
                    return;
                }

                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            IO.write("no\n");
            return;
        }

        IO.write("yes\n");
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
