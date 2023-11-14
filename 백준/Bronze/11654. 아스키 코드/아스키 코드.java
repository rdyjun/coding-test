import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String len = br.readLine();
        char answer = len.charAt(0);
        bw.write((answer + 0) + "");
        bw.close();
    }
}