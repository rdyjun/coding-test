import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.toUpperCase();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++)
            map.put((int) str.charAt(i), map.getOrDefault((int) str.charAt(i), 0) + 1);
        String answer = "?";
        int max = Collections.max(map.values());
        for (int i : map.keySet()) {
            if (max != map.get(i))
                continue;
            if (answer.equals("?")) {
                answer = String.valueOf((char) i);
                continue;
            }
            answer = "?";
            break;
        }

        bw.write(answer);
        bw.close();
        br.close();
    }
}