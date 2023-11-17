import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputType = br.readLine().split(" ");
        String numberSizeInString = inputType[0];
        String changeRangeInString = inputType[1];
        int numberSize = Integer.parseInt(numberSizeInString);
        int changeRange = Integer.parseInt(changeRangeInString);
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < numberSize; i++)
            answer.add(i + 1);

        for (int i = 0; i < changeRange; i++) {
            String[] changeIndexes = br.readLine().split(" ");
            int startIndex = Integer.parseInt(changeIndexes[0]);
            int endIndex = Integer.parseInt(changeIndexes[1]);
            while (startIndex < endIndex) {
                Collections.swap(answer, startIndex - 1, endIndex - 1);
                startIndex++;
                endIndex--;
            }
        }
        for (int i = 0; i < numberSize - 1; i++)
            bw.write(answer.get(i) + " ");
        bw.write("" + answer.get(numberSize - 1));

        bw.close();
        br.close();
    }
}