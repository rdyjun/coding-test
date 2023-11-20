import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String[] words = str.split(" ");
        int answer = 0;
        for (String st : words)
            if (st != "")
                answer++;
        bw.write(answer + "");
        bw.close();
    }
}