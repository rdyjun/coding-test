import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static BufferedReader br;
    private static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        init();
        int len = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < len; i++)
            arr.add(Integer.parseInt(br.readLine()));
        Collections.sort(arr);
        for(int i = 0; i < arr.size(); i++)
            bw.write(arr.get(i) + "\n");
        close();
    }
    private static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
    private static void close() throws IOException {
        bw.flush();
        bw.close();
        br.close();
    }
}