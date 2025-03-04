import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine()
                .split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int count = 0;
        int index = k - 1;

        Set<Integer> added = new HashSet<>();

        List<Integer> array = new ArrayList<>(IntStream.range(1, n + 1)
                .boxed()
                .collect(Collectors.toList()));
        int[] answer = new int[n];

        while (count < n - 1 && !added.contains(array.get(index))) {
            int value = array.get(index);
            answer[count] = value;
            added.add(value);
            array.remove(index);

            index = (index + k - 1) % array.size();
            count++;
        }

        System.out.print("<");
        for (int i = 0; i < n - 1; i++) {
            System.out.print(answer[i] + ", ");
        }
        System.out.print(array.get(0) + ">");
    }
}
