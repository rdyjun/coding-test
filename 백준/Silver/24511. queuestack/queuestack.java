import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder answer = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] typeArray = br.readLine().split(" ");
        String[] initValue = br.readLine().split(" ");

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (typeArray[i].equals("1")) {
                continue;
            }

            deque.add(Integer.parseInt(initValue[i]));
        }

        int k = Integer.parseInt(br.readLine());
        int[] valueArray = readIntegerInputArray(k, br);

        for (int valueIndex= 0; valueIndex < k; valueIndex++) {
            int value = valueArray[valueIndex];
            deque.addFirst(value);
            answer.append(" " + deque.removeLast());
        }

        bw.write(answer.toString().trim());
        br.close();
        bw.close();
    }

    private static List<Queue<Integer>> getQueue(int n, String[] typeArray, int[] initValue) {
        List<Queue<Integer>> queueList = new ArrayList<>();

        for (int i = 0; i < n; i++) {                                           // Queue만 List저장
            if (typeArray[i].equals("1")) {
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(initValue[i]);
            queueList.add(queue);
        }

        return queueList;
    }

    private static int[] readIntegerInputArray(int size, BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = Integer.parseInt(input[i]);
        }
        return result;
    }

}
