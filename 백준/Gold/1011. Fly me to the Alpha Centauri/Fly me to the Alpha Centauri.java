import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        IO.init();
        spaceMinMovementCount();
        IO.close();
    }

    private static void spaceMinMovementCount() {
        int caseCount = Integer.parseInt(IO.read());

        while (caseCount-- > 0) {
            minStep();
        }
    }

    private static void minStep() {
        StringTokenizer input = new StringTokenizer(IO.read(), " ");

        int from = Integer.parseInt(input.nextToken());
        int to = Integer.parseInt(input.nextToken());

        int distance = to - from;
        int sum = 2;
        int moveCount = 0;

        int i = 1;
        while (sum < distance && sum > 0) {
            moveCount += 2;
            i++;
            sum += i + i;
        }

        sum -= i + i;

        if (distance - sum >= i) {
            moveCount++;
            sum += i;
        }

        if (distance > sum) {
            moveCount++;
        }

        IO.write(moveCount + "\n");
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
            e.printStackTrace();
        }
    }

    public static String read() {
        try {
            return reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void write(Object message) {
        try {
            writer.write(String.valueOf(message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
