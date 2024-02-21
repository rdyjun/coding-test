import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        IO.init();

        StringBuilder stringBuilder;
        String word = IO.read();
        String answer = null;

        Set<String> set = new HashSet<>();

        int n = Integer.parseInt(IO.read());
        for(int i = 0; i < n; i++)
            set.add(IO.read());

        boolean flag = true;
        for(int c = 0; c < 26 && flag; c++) {
            stringBuilder = new StringBuilder();
            for(int i = 0; i < word.length(); i++)
                stringBuilder.append((char) ((word.charAt(i) - 'a' + c) % 26 + 97));

            answer = stringBuilder.toString();

            for(String st : set) {
                if(!answer.contains(st))
                    continue;

                flag = false;
                break;
            }
        }

        IO.write(answer);
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

    public static void write(Object message) throws IOException {
        bw.write(String.valueOf(message));
    }
}