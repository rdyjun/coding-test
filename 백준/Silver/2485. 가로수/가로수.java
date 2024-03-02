import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) {
        IO.init();
        calculateMinimumStreetTree();
        IO.close();
    }

    private static void calculateMinimumStreetTree() {
        int streetTreeCount = Integer.parseInt(IO.read());
        int[] street = new int[streetTreeCount];
        street[0] = Integer.parseInt(IO.read());
        int left = street[0];

        int minDistance = -1;

        for (int treeIndex = 1; treeIndex < streetTreeCount; treeIndex++) {
            street[treeIndex] = Integer.parseInt(IO.read());
            int distance = street[treeIndex] - street[treeIndex - 1];

            minDistance = gcd(distance, minDistance);
        }

        int right = street[streetTreeCount - 1];
        int totalDistance = right - left;

        int newTree = (totalDistance / minDistance + 1) - streetTreeCount;
        IO.write(newTree);
    }

    private static int gcd(int a, int b) {
        while (b > 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
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
