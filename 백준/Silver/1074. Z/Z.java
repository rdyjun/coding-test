import java.util.Scanner;

public class Main {
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int width = (int) Math.pow(2, n);

        findInvite(width, r, c);
        System.out.println(answer);
    }
    public static void findInvite(int width, int r, int c){
        if(r < width / 2 && c < width / 2){
            findInvite(width / 2, r, c);
        } else if (r < width / 2){
            answer += (width / 2) * (width / 2);
            findInvite(width / 2, r, c - 2 * (width / 4));
        } else if (c < width / 2){
            answer += width * width / 2;
            findInvite(width / 2, r - 2 * (width / 4), c );
        } else if (!(width == 1)){
            answer += (width / 2) * (width / 2);
            answer += width * width / 2;
            findInvite(width / 2, r - 2 * (width / 4), c - 2 * (width / 4));
        }
    }
}
