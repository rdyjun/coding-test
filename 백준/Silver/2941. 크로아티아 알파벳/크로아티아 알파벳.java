import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] word = new String[]{"dz=", "lj", "nj", "c=","c-", "d-", "s=", "z="};

        for (String st : word)
            str = str.replaceAll(st, "a");
        bw.write(str.length() + "");
        bw.close();
        br.close();
    }
}