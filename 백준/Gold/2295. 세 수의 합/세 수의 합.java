import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        IO.init();

        int n = Integer.parseInt(IO.read());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(IO.read());

        // 배열 정렬
        Arrays.sort(arr);

        // 두 수의 합 저장
        Set<Integer> result = new HashSet<>();
        for(int i = 0; i < n; i++)
            for(int k = i; k < n; k++)
                result.add(arr[i] + arr[k]);
        
        // 가장 큰 수부터 원소를 하나씩 빼면서 나머지 값이 result에 존재하는지 검사
        for(int i = n - 1; i >= 0; i--) {
            int now = arr[i];
            for(int k = 0; k < n; k++) {
                if(result.contains(now - arr[k])) {
                    IO.write(now);
                    IO.close();
                    return;
                }
            }
        }

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