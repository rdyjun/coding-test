import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int len = Integer.parseInt(br.readLine());
        for (int i = 0; i < len; i++) {
            String str = br.readLine();
            bw.write("" + str.charAt(0) + str.charAt(str.length() - 1) + "\n");
        }
        bw.close();
    }
}