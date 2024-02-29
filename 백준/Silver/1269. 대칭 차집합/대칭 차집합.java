import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        IO.init();

        getDifferenceOfSets();

        IO.close();
    }

    private static void getDifferenceOfSets() throws IOException {
        StringTokenizer input = new StringTokenizer(IO.read());

        Set<Integer> numberList = new HashSet<>();

        input = new StringTokenizer(IO.read());
        
        while (input.hasMoreTokens()) {
            int nextNumber = Integer.parseInt(input.nextToken());
            numberList.add(nextNumber);
        }

        int answer = numberList.size();

        input = new StringTokenizer(IO.read());
        
        while (input.hasMoreTokens()) {
            int nextNumber = Integer.parseInt(input.nextToken());

            if (numberList.contains(nextNumber)) {
                answer--;
                continue;
            }

            answer++;
        }

        IO.write(answer);
    }
}

class IO {
    private static BufferedReader reader;
    private static BufferedWriter writer;

    public static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() throws IOException {
        writer.flush();
        writer.close();
        reader.close();
    }

    public static String read() throws IOException {
        return reader.readLine();
    }

    public static void write(Object message) throws IOException {
        writer.write(String.valueOf(message));
    }
}
