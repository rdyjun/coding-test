import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) {
        IO.init();
        findNextPrimeNumber();
        IO.close();
    }

    private static void findNextPrimeNumber() {
        int numberCount = Integer.parseInt(IO.read());

        for (int numberIndex = 0; numberIndex < numberCount; numberIndex++) {
            long number = Long.parseLong(IO.read());

            if (number <= 1) {
                number = 2;
            }

            IO.write(nextPrimeNumber(number) + "\n");
        }
    }

    private static long nextPrimeNumber(long number) {
        int limit = (int)Math.sqrt(number);

        for (int divider = 2; divider <= limit; divider++) {
            if (number % divider > 0) {
                continue;
            }

            number++;
            limit = (int)Math.sqrt(number);

            divider = 1;
        }
        return number;
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
