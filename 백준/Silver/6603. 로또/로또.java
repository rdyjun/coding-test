import java.io.*;

public class Main {

    private static String[] input;

    private static int k;

    private static BufferedWriter bw;

    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine().split(" "); // k와 k개의 수열
        k = Integer.parseInt(input[0]); // k

        while(k > 0) {
            getCase(-1, 0, new String[6]);

            bw.write("\n");

            // 입력 받고 n초기화
            input = br.readLine().split(" ");
            k = Integer.parseInt(input[0]);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void getCase(int index, int kIndex, String[] arr) throws IOException { // 2 1
        if(index == 5) {
            print(arr);
            return;
        }

        index++;

        for(int i = kIndex; i <= k - (6 - kIndex) && i < k; i++) {
            String[] tmpArray = arr.clone();
            tmpArray[index] = input[i + 1];

            getCase(index, i + 1, tmpArray);
        }
    }

    private static void print(String[] arr) throws IOException {
        for(int i = 0; i < 5; i++)
            bw.write(arr[i] + " ");
        bw.write(arr[5] + "\n");
    }
}