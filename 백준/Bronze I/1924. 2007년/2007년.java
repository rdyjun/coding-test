import java.io.*;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {
        IO.init();

        final String[] week = new String[]{"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        final int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        String[] input = IO.read().split(" ");
        int month = Integer.parseInt(input[0]);
        int day = Integer.parseInt(input[1]);

        int total = day - 1;

        for(int i = 1; i < month; i++)
            total += days[i - 1];

        int answer = total % 7;

        IO.write(week[answer]);

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