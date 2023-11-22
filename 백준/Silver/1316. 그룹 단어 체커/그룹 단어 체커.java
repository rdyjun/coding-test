import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (isGroupWord(word))
                answer++;
        }
        bw.write(answer + "");
        bw.close();
        br.close();
    }
    private static boolean isGroupWord (String word) {
        Set<Character> s = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!s.contains(ch)) {
                s.add(ch);
                continue;
            }
            if (word.charAt(i - 1) != ch)
                return false;
        }
        return true;
    }
}