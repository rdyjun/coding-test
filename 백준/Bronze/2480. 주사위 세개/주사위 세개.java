import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int answer = 100;
        if(f == s && s == t) {
            answer *= 10 * f;
            answer += 10000;
        } else if (f == s || f == t) {
            answer *= f;
            answer += 1000;
        } else if (s == t) {
            answer *= s;
            answer += 1000;
        } else
            answer *= f > s ? (f > t ? f : t) : (s > t ? s : t);


        System.out.println(answer);
    }
}
