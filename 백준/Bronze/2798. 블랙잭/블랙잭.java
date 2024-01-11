import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int max;
    private static List<Integer> arr;
    private static int answer = 0;
    public static void main (String[] args) throws IOException {
        init();
        String[] nm = br.readLine().split(" ");
        int len = Integer.parseInt(nm[0]);
        String[] stringArr = br.readLine().split(" ");
        max = Integer.parseInt(nm[1]);
        arr = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int n = Integer.parseInt(stringArr[i]);
            if(n > max)
                continue;
            arr.add(n);
        }
        len = arr.size();
        dfs(len);
        bw.write(answer + "");
        close();
    }
    private static void dfs(int len) {
        int now;
        for (int i = 0; i < len - 2; i++) {
            now = dfs(i, 0, len, 1);
            if (now > answer)
                answer = now;
        }
    }
    private static int dfs(int idx, int sum, int len, int count) {
        sum += arr.get(idx);
        if(sum > max)
            return 0;
        if(count == 3)
            return sum;
        int n;
        int tmp = 0;
        count++;
        for (int i = idx + 1; i < len; i++) {
            n = dfs(i, sum, len, count);
            if(n > tmp)
                tmp = n;
        }
        return tmp;
    }
    private static void init () {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
    private static void close () throws IOException {
        bw.flush();
        bw.close();
        br.close();
    }
}