import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final Integer MAX_SIZE = 200000;

        int[] input = getNumberArray(br);
        int n = input[0];
        int k = input[1];

        int shortTime = Integer.MAX_VALUE;
        int countByShortTime = 0;

        Queue<Integer> positionQueue = new LinkedList<>();
        Queue<Integer> timeQueue = new LinkedList<>();
        Map<Integer, Integer> visited = new HashMap<>();

        positionQueue.add(n);
        timeQueue.add(0);

        while (!positionQueue.isEmpty()) {
            int position = positionQueue.poll();
            int time =  timeQueue.poll();

            int visitedMinTime = visited.getOrDefault(position, Integer.MAX_VALUE);
            if (time > shortTime                    // time이 최소시간보다 큰 경우
                    || position < 0                 // 위치가 음수인 경우
                    || MAX_SIZE <= position         // 위치가 이동 가능한 최대 위치를 초과한 경우
                    || visitedMinTime < time) {
                continue;
            }

            if (position == k) {
                if (time == shortTime) {
                    countByShortTime++;
                }

                if (time < shortTime) {
                    shortTime = time;
                    countByShortTime = 1;
                }

                continue;
            }

            visited.put(position, time);

            time++;

            positionQueue.add(position + 1);
            timeQueue.add(time);

            positionQueue.add(position - 1);
            timeQueue.add(time);

            positionQueue.add(position * 2);
            timeQueue.add(time);
        }

        bw.write(shortTime + "\n");
        bw.write(countByShortTime + "");

        br.close();
        bw.close();
    }


    private static int getInt(BufferedReader br) throws IOException {
        String input = br.readLine();
        return Integer.parseInt(input);
    }

    private static int[] getNumberArray(BufferedReader br) throws IOException {
        String input = br.readLine();
        String[] split = input.split(" ");
        return Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
