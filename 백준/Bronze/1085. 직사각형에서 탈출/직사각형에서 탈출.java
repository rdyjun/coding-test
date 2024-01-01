import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int w = Integer.parseInt(input[2]);
        int h = Integer.parseInt(input[3]);
        int min = 0;
        if (w - x >= x)
            min = x;
        if (w - x < x)
            min = w - x;
        if (h - y >= y && min > y)
            min = y;
        if (h - y < y && min > h - y)
            min = h - y;
        bw.write(min + "");
        bw.close();
        br.close();
    }
}
