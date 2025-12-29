import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int r1 = Integer.parseInt(input[2]);
            int x2 = Integer.parseInt(input[3]);
            int y2 = Integer.parseInt(input[4]);
            int r2 = Integer.parseInt(input[5]);

            double distance = getDistance(x1, y1, x2, y2);

            // 같은 지점의 같은 거리인 경우 -1
            if (x1 == x2 && y1 == y2 && r1 == r2) {
                System.out.println(-1);
                continue;
            }

            // 거리가 모자른 경우
            if (distance > r1 + r2) {
                System.out.println(0);
                continue;
            }

            // 특정 사람의 범위가 다른 사람의 범위를 감싸고 한 면이 맞물릴 때
            if (distance + r1 == r2 || distance + r2 == r1) {
                System.out.println(1);
                continue;
            }

            // 특정 사람의 범위가 다른 사람의 범위를 감싸기만 할 때
            if (distance + r1 < r2 || distance + r2 < r1) {
                System.out.println(0);
                continue;
            }

            // 한 점만 맞물리는 경우
            if (distance == r1 + r2) {
                System.out.println(1);
                continue;
            }

            System.out.println(2);
        }
    }

    private static double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
    }
}
