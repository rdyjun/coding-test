import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int arrSize = Integer.parseInt(nm[0]);
        int throwCount = Integer.parseInt(nm[1]);
        int[] answer = new int[arrSize];
        for (int i = 0; i < throwCount; i++) {
            String[] throwArray = br.readLine().split(" ");
            int start = Integer.parseInt(throwArray[0]);
            int end = Integer.parseInt(throwArray[1]);
            for (int k = start; k <= end; k++) {
                answer[k - 1] = Integer.parseInt(throwArray[2]);
            }
        }
        for (int n : answer)
            bw.write(n + " ");
        bw.close();
    }
}