import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = Integer.parseInt(st.nextToken());
        Character answer;
        switch (result / 10) {
            case 10:
            case 9:
                answer = 'A';
                break;
            case 8:
                answer = 'B';
                break;
            case 7:
                answer = 'C';
                break;
            case 6:
                answer = 'D';
                break;
            default:
                answer = 'F';
        }

        System.out.println(answer);
    }
}