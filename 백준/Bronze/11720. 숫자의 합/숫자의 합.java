import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String len = br.readLine();
        String[] num = br.readLine().split("");
        int answer = 0;
        for (String n : num)
            answer += Integer.parseInt(n);
        bw.write(answer + "");
        bw.close();
    }
}