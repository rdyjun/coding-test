import java.io.*;

public class Main {
    private static BufferedReader br;
    private static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        init();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        String[] arr = new String[n];
        int answer = -1;
        for(int i = 0; i < n; i++)
            arr[i] = br.readLine();

        char now;
        int firstCount = 0;
        int secondCount = 0;
        for(int i = 0; i <= n - 8; i++) {
            for(int k = 0; k <= m - 8; k++) {
                now = arr[i].charAt(k);
                for(int y = i; y < i + 8; y++) {
                    for(int x = k; x < k + 8; x++) {
                        char c = arr[y].charAt(x);
                        if(c != now)
                            firstCount++;
                        if(c == now)
                            secondCount++;
                        now = swap(now);
                    }
                    now = swap(now);
                }
                int min = firstCount;
                if(firstCount > secondCount)
                    min = secondCount;
                if(answer == -1 || answer > min)
                    answer = min;
                firstCount = 0;
                secondCount = 0;
            }
        }
        bw.write(answer + "");
        close();
    }
    private static char swap(char c) {
        if(c == 'B')
            return 'W';
        return 'B';
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