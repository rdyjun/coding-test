import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] ans = new boolean[(int)(max - min + 1)];

        long maxSqrt = (long) Math.sqrt(max);

        for(long i = 2; i <= maxSqrt; i++){
            long square = i * i;  // square = 4, min = 15,
            long start = min % square == 0 ? min / square : min / square + 1;

            for(long k = start; k * square <= max; k++){
                ans[(int)(k * square - min)] = true;
            }
        }
        // 1000 2000
        int c = 0;
        for(int i = 0; i < ans.length; i++){
            if(!ans[i])
                c++;
        }
        System.out.println(c);
    }
}
