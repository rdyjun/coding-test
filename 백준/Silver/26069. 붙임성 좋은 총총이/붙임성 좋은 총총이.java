import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = getInt(br);

        Set<String> set = new HashSet<>();
        set.add("ChongChong");

        for (int i = 0; i < n; i++) {
            InputMeetHumansName inputMeetHumansName = getInputMeetHumansName(br);
            String first = inputMeetHumansName.first;
            String second = inputMeetHumansName.second;

            boolean isFirstInSet = set.contains(first);
            boolean isSecondInSet = set.contains(second);

            if (isFirstInSet && isSecondInSet) {
                continue;
            }

            if (isFirstInSet || isSecondInSet) {
                set.add(first);
                set.add(second);
            }
        }

        bw.write(set.size() + "");

        br.close();
        bw.close();
    }

    private static int getInt(BufferedReader br) throws IOException {
        String input = br.readLine();
        return Integer.parseInt(input);
    }

    private static InputMeetHumansName getInputMeetHumansName(BufferedReader br) throws IOException {
        String input = br.readLine();
        String[] split = input.split(" ");
        return new InputMeetHumansName(split[0], split[1]);
    }

    static class InputMeetHumansName {
        String first;
        String second;

        public InputMeetHumansName(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }
}
