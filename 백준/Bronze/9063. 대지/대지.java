import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            bw.write("0");
            bw.flush();
            bw.close();
            br.close();
            return;
        }
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int maxX, minX, maxY, minY;
        maxX = minX = x;
        maxY = minY = y;
        for (int i = 1; i < n; i++) {
            input = br.readLine().split(" ");
            x = Integer.parseInt(input[0]);
            y = Integer.parseInt(input[1]);
            if (maxX < x)
                maxX = x;
            if (minX > x)
                minX = x;
            if (maxY < y)
                maxY = y;
            if (minY > y)
                minY = y;
        }
        bw.write((maxX - minX) * (maxY - minY) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

