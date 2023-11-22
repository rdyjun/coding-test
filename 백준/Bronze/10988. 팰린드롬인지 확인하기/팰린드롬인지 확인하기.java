import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int strLen = str.length();
        for (int i = 0; i < strLen / 2; i++) {
            if (str.charAt(i) != str.charAt(strLen - i - 1)) {
                bw.write("0");
                bw.close();
                br.close();
                return;
            }
        }
        bw.write("1");
        bw.close();
        br.close();
    }
}