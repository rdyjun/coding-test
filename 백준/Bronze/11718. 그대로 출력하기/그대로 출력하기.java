import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st;
        while ((st = br.readLine()) != null)
            bw.write(st + "\n");

        bw.close();
        br.close();
    }
}