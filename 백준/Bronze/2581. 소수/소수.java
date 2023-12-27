import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[m - n + 1];
        int answer = 0;
        int first = 0;
        for (int i = 2; i <= m; i++) {
            if (i - n > 0 && arr[i - n])
                continue;
            if (i < n || !isPrime(i)) {
                fillMultiple(i, n, arr);
                continue;
            }
            if (first == 0)
                first = i;
            answer += i;
        }
        if (answer == 0)
            bw.write("-1");
        if (answer > 0)
            bw.write(answer + "\n" + first);
        bw.close();
        br.close();
    }
    private static boolean isPrime (int num) {
        int n = (int) Math.sqrt(num);
        for (int i = 2; i <= n; i++)
            if (num % i == 0)
                return false;
        return true;
    }
    private static void fillMultiple (int num, int n, boolean[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i])
                continue;
            int idx = i + n;
            if (idx % num == 0)
                arr[i] = true;
        }
    }
}
