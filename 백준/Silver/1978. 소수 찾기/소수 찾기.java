import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrLen = sc.nextInt();
        int answer = 0;

        loop:
        for(int i = 0; i < arrLen; i++){
            int a = sc.nextInt();
            if(a == 1){
                continue;
            }
            for(int k = 2; k <= Math.sqrt(a); k++){
                if(a % k == 0){
                    continue loop;
                }
            }
            answer++;

        }
        System.out.println(answer);
    }
}
