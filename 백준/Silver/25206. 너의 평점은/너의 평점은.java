import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        Map<String, Float> map = new HashMap<>();
        map.put("A+", 4.5F);
        map.put("A0", 4.0F);
        map.put("B+", 3.5F);
        map.put("B0", 3.0F);
        map.put("C+", 2.5F);
        map.put("C0", 2.0F);
        map.put("D+", 1.5F);
        map.put("D0", 1.0F);
        map.put("F", 0.0F);
        int totalPoint = 0;
        double totalScore = 0;
        while ((str = br.readLine()) != null) {
            String[] data = str.split(" ");
            String score = data[2];
            if (score.equals("P"))
                continue;
            int point = Integer.parseInt(data[1].substring(0, 1));

            totalPoint += point;
            totalScore += point * map.get(score);
        }
        double answer = totalScore / totalPoint;
        bw.write(answer + "");
        bw.close();
        br.close();
    }
}