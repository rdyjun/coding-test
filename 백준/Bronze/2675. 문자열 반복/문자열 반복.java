import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String stringOfRange = br.readLine();
        int range = Integer.parseInt(stringOfRange);
        for (int i = 0; i < range; i++) {
            String[] rangeAndWord = br.readLine().split(" ");
            int wordRange = Integer.parseInt(rangeAndWord[0]);
            for (String st : rangeAndWord[1].split("")) {
                for (int k = 0; k < wordRange; k++)
                    bw.write(st);
            }
            bw.write("\n");
        }
        bw.close();
        br.close();
    }
}