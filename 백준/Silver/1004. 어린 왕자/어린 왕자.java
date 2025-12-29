import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
                    
            String[] positionString = br.readLine().split(" ");
            int x1 = Integer.parseInt(positionString[0]);
            int y1 = Integer.parseInt(positionString[1]);
            int x2 = Integer.parseInt(positionString[2]);
            int y2 = Integer.parseInt(positionString[3]);
            
            int n = Integer.parseInt(br.readLine());

            int result = 0;
            
            for (int k = 0; k < n; k++) {
                String[] input = br.readLine()
                        .split(" ");

                int rx = Integer.parseInt(input[0]);
                int ry = Integer.parseInt(input[1]);
                int r = Integer.parseInt(input[2]);

                boolean startInRadius = Math.sqrt(Math.pow(Math.abs(rx - x1), 2) + Math.pow(Math.abs(ry - y1), 2)) < r;
                boolean endInRadius = Math.sqrt(Math.pow(Math.abs(rx - x2), 2) + Math.pow(Math.abs(ry - y2), 2)) < r;

                if (startInRadius ^ endInRadius) {
                    result++;
                }
            }

            System.out.println(result);
        }
    }
}