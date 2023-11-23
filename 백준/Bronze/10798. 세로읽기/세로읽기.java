import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> strList = new ArrayList<>();
        int maxLen = 0;
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            strList.add(str);
            if (maxLen < str.length())
                maxLen = str.length();
        }

        for (int i = 0; i < maxLen; i++) {
            for (int k = 0; k < strList.size(); k++) {
                if (strList.get(k).length() > i)
                    bw.write(strList.get(k).charAt(i) + "");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}