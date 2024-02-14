import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        IO.init();

        String[] input = IO.read().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Set<String> nArr = new HashSet<>();
        Set<String> mArr = new HashSet<>();

        for(int i = 0; i < n; i++)
            nArr.add(IO.read());

        for(int i = 0; i < m; i++)
            mArr.add(IO.read());

        List<String> answer = new ArrayList<>();

        for(String name : nArr)
            if(mArr.contains(name))
                answer.add(name);

        answer = answer.stream()
                .sorted()
                .collect(Collectors.toList());

        IO.write(answer.size() + "\n");

        for(String name : answer)
            IO.write(name + "\n");

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