import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> map = new HashMap<>();
        for (char ch = 'A'; ch <= 'O'; ch++)
            map.put(ch, (ch - 65) / 3 + 3);
        for (char ch = 'P'; ch <= 'S'; ch++)
            map.put(ch, 8);
        for (char ch = 'T'; ch <= 'V'; ch++)
            map.put(ch, 9);
        for (char ch = 'W'; ch <= 'Z'; ch++)
            map.put(ch, 10);
        String word = br.readLine();
        int answer = 0;
        for (int i = 0; i < word.length(); i++)
            answer += map.getOrDefault(word.charAt(i), 11);
        bw.write(answer + "");
        bw.close();
        br.close();
    }
}