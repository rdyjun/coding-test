import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        Map<Character, Integer> map = new HashMap<>();
        for (char i = 'a'; i <= 'z'; i++)
            map.put(i, -1);
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (map.get(ch) == -1)
                map.put(ch, i);
        }
        for (Character alpha : map.keySet())
            bw.write(map.get(alpha) + " ");
        bw.close();
        br.close();
    }
}