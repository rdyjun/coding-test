import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        IO.init();

        getDifferenceStringCount();

        IO.close();
    }

    private static void getDifferenceStringCount() throws IOException {
        String input = IO.read();
        int length = input.length();

        Set<String> substrings = new HashSet<>();

        for(int substringLength = 0; substringLength < length; substringLength++) {
            for(int index = 0; index < length - substringLength; index++) {
                substrings.add(input.substring(substringLength, substringLength + index + 1));
            }
        }

        int answer = substrings.size();

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
