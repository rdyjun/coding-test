import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int arrSize = Integer.parseInt(nm[0]);
        int throwCount = Integer.parseInt(nm[1]);
        int[] answer = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            answer[i] = i + 1;
        }
        for (int i = 0; i < throwCount; i++) {
            String[] throwArray = br.readLine().split(" ");
            int first = Integer.parseInt(throwArray[0]);
            int second = Integer.parseInt(throwArray[1]);
            int tmp = answer[first - 1];
            answer[first - 1] = answer[second - 1];
            answer[second - 1] = tmp;
        }
        for (int n : answer)
            bw.write(n + " ");
        bw.close();
    }
}