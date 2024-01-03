import java.io.*;

public class Main {
    private static BufferedReader br;
    private static BufferedWriter bw;
    public static void main (String[] args) throws IOException {
        init();
        String[] t;
        int[] numArr = new int[3];
        String answer;
        while (true) {
            t = br.readLine().split(" ");
            for (int i = 0; i < 3; i++)
                numArr[i] = Integer.parseInt(t[i]);
            answer = lengthComparation(numArr);
            if (answer.equals("end"))
                break;
            bw.write(answer + "\n");
        }
        close();
    }
    private static String lengthComparation(int[] arr) {
        if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0)
            return "end";
        // 큰 값 구하기
        int max = arr[0];
        if (max < arr[1])
            max = arr[1];
        if (max < arr[2])
            max = arr[2];
        // 삼각형이 올바른지 검사
        if (arr[0] + arr[1] + arr[2] - max <= max)
            return "Invalid";
        // 모든 변의 길이가 같은지 검사
        if (arr[0] == arr[1] && arr[1] == arr[2])
            return "Equilateral";
        // 두 변의 길이만 같은지 검사
        if (arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2])
            return "Isosceles";

        return "Scalene";
    }
    private static void init () {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
    private static void close () throws IOException {
        bw.flush();
        bw.close();
        br.close();
    }
}