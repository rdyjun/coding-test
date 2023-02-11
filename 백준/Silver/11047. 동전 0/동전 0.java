import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        int answer = 0;

        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }

        int min = 0;
        int max = a.length - 1;
        while(k > 0){
            int mid = (min + max) / 2;
            if(a[a.length - 1] < k){
                k -= a[a.length - 1];
                answer += 1;
            } else if(a[mid] == k){
                answer += 1;
                break;
            } else if(a[mid] > k){
                if(a[mid - 1] < k){
                    k -= a[mid - 1];
                    min = 0;
                    max = a.length - 1;
                    answer += 1;
                } else if(a[mid - 1] == k){
                    answer += 1;
                    break;
                } else {
                    max = mid - 1;
                }
            } else if(a[mid] < k){
                if(a[mid + 1] > k){
                    k -= a[mid];
                    min = 0;
                    max = a.length - 1;
                    answer += 1;
                } else if(a[mid + 1] == k){
                    answer += 1;
                    break;
                } else {
                    min = mid + 1;
                }
            }


        }
        System.out.println(answer);
    }
}
