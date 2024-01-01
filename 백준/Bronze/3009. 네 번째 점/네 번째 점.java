import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");
        String[] c = br.readLine().split(" ");
        String x = a[0];
        String y = a[1];
        if (b[0].equals(x))
            x = c[0];
        if (a[0].equals(c[0]))
            x = b[0];
        if (b[1].equals(y))
            y = c[1];
        if (a[1].equals(c[1]))
            y = b[1];
        bw.write(x + " " + y);
        bw.close();
        br.close();
    }
}