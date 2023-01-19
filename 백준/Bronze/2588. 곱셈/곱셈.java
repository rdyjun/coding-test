import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a * b;
        for(int i = 2; i >= 0; i--){
            System.out.println(a * (b % 10));
            b /= 10;
        }
        System.out.println(c);
    }
}