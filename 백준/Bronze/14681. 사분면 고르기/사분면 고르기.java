import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int answer = 1;
        answer += y > 0 ? 0 : 2;
        if (answer == 3){
            if (x > 0)
                answer++;
        } else {
            if (x < 0)
                answer++;
        }



        System.out.println(answer);
    }
}
