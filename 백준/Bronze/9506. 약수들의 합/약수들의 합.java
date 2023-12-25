import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int sum;
        Set<Integer> arr;
        while (n != -1) {
            int m = (int) Math.sqrt(n);
            sum = 1;
            arr = new HashSet<>();
            arr.add(1);
            for (int i = 2; i <= m; i++) {
                if (n % i == 0) {
                    sum += i + n / i;
                    arr.add(i);
                    arr.add(n / i);
                }
                if (sum > n)
                    break;
            }
            if (sum != n)
                bw.write(n + " is NOT perfect.\n");
            if (sum == n)
                print(n, new ArrayList<>(arr), bw);
            n = Integer.parseInt(br.readLine());
        }
        bw.close();
        br.close();
    }
    private static void print (int n, List<Integer> arr, BufferedWriter bw) throws IOException {
        Collections.sort(arr);
        bw.write(n + " = ");
        for (int i = 0; i < arr.size() - 1; i++)
            bw.write(arr.get(i) + " + ");
        bw.write(arr.get(arr.size() - 1) + "\n");
    }
}
