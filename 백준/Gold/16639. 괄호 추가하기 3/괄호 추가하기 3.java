import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수식의 길이
        int n = Integer.parseInt(br.readLine());

        int numberCount = n / 2 + 1;
        int opCount = n / 2;
        
        char[] op = new char[opCount];    // 각 연산자 저장
        int[] num = new int[numberCount]; // 각 숫자 저장
        int[][][] dp = new int[numberCount + 1][numberCount + 1][2]; // 특정 위치[a]부터 특정 위치 까지[b] 최대비용 [0] 최소비용 [1]
        for (int r = 0; r <= numberCount; r++) {
            for (int c = 0; c <= numberCount; c++) {
                dp[r][c] = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
            }
        }

        char[] input = br.readLine().toCharArray();

        // 연산자 저장
        for (int i = 1; i < input.length; i += 2) {
            op[i / 2] = input[i];
        }

        // 숫자 저장
        for (int i = 0; i < input.length; i += 2) {
            int number = input[i] - '0';
            num[i / 2] = number;
            dp[i / 2 + 1][i / 2 + 1] = new int[]{number, number};
        }

        // 사용할 숫자에 따라 좌-우로 나누어 최대값 찾기
        for (int count = 2; count <= numberCount; count++) { // 사용할 숫자 개수
            for (int row = 1; row <= numberCount - count + 1; row++) { // 시작 숫자의 인덱스
                int col = count + row - 1;
                
                // dp[row][row + count - 1]을 구하기 위한 연산
                // subCount: 좌측 값 크기
                for (int subCount = 1; subCount < count; subCount++) {
                    // row값부터 서브 크기만큼
                    int leftMax = dp[row][row + subCount - 1][0];
                    int leftMin = dp[row][row + subCount - 1][1];
                    int rightMax = dp[row + subCount][col][0];
                    int rightMin = dp[row + subCount][col][1];
                    
                    char oper = op[row + subCount - 2];

                    int result1 = calc(oper, leftMax, rightMax);
                    int result2 = calc(oper, leftMin, rightMax);
                    int result3 = calc(oper, leftMax, rightMin);
                    int result4 = calc(oper, leftMin, rightMin);

                    int maxValue = Math.max(Math.max(Math.max(result1, result2), result3), result4);
                    int minValue = Math.min(Math.min(Math.min(result1, result2), result3), result4);

                    // 최댓값이 초기화된 경우 비교 후 저장
                    if (dp[row][col][0] != Integer.MIN_VALUE) {
                        dp[row][col][0] = Math.max(dp[row][col][0], maxValue);
                    }

                    // 최댓값이 초기화되지 않은 경우 바로 저장
                    if (dp[row][col][0] == Integer.MIN_VALUE) {
                        dp[row][col][0] = maxValue;
                    }

                    // 최솟값이 초기화된 경우 비교 후 저장
                    if (dp[row][col][1] != Integer.MIN_VALUE) {
                        dp[row][col][1] = Math.min(dp[row][col][1], minValue);
                    }
                    // 최솟값이 초기화되지 않은 경우 바로 저장
                    if (dp[row][col][1] == Integer.MIN_VALUE) {
                        dp[row][col][1] = minValue;
                    }
                }
            }
        }

        // // 디버깅
        // for (int r = 0; r <= numberCount; r++) {
        //     for (int c = 0; c <= numberCount; c++) {
        //         System.out.print("[" + String.format("%3s", dp[r][c][0]) + ", " + String.format("%3s", dp[r][c][1]) + "]\t");
        //     }
        //     System.out.println();
        // }
        
        System.out.println(dp[1][numberCount][0]);
    }

    private static int calc(char op, int left, int right) {
        if (op == '+') {
            return left + right;
        }
        if (op == '-') {
            return left - right;
        }
        if (op == '*') {
            return left * right;
        }

        return -1;
    }
}

/**
x x x  x  x  x
x 3 11 x  x  x
x x 8  56 x  x
x x x  7  -2 x
x x x  x  9  18
x x x  x  x  2
**/