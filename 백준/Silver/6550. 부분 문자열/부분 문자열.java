import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr;

        while(sc.hasNextLine()) {
            arr = sc.nextLine().split(" ");

            int find = 0;

            for(int i = 0; i < arr[1].length(); i++) {
                if(find >= arr[0].length())
                    break;
                if(arr[1].charAt(i) == arr[0].charAt(find))
                    find++;
            }

            boolean flag = find == arr[0].length();

            if(flag)
                System.out.println("Yes");

            if(!flag)
                System.out.println("No");
        }
    }
}