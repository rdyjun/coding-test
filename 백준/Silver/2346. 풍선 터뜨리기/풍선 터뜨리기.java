import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine()
                .split(" ");

        Deque<Balloon> balloons = initializeDequeByInput(n, input);
        StringBuilder answer = new StringBuilder();

        while (!balloons.isEmpty()) {
            Balloon balloon = balloons.getFirst();

            answer.append(balloon.index + " ");
            balloons.removeFirst();

            if (balloons.isEmpty()) {
                break;
            }

            int move = balloon.move;
            if (balloon.move > 0) {
                move--;
            }

            if (move > 0) {
                rotateLeft(move, balloons);
            }
            if (move < 0) {
                rotateRight(move, balloons);
            }
        }

        System.out.println(answer.toString().trim());
    }

    private static Deque<Balloon> initializeDequeByInput(int n, String[] input) {
        Deque<Balloon> balloons = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int move = Integer.parseInt(input[i]);
            balloons.add(new Balloon(i + 1, move));
        }

        return balloons;
    }

    private static void rotateLeft(int count, Deque<Balloon> balloons) {
        count = Math.abs(count);

        for (int i = 0; i < count; i++) {
            balloons.addLast(balloons.removeFirst());
        }
    }

    private static void rotateRight(int count, Deque<Balloon> balloons) {
        count = Math.abs(count);

        for (int i = 0; i < count; i++) {
            balloons.addFirst(balloons.removeLast());
        }
    }

    static class Balloon {

        private int index;
        private int move;

        public Balloon(int index, int move) {
            this.index = index;
            this.move = move;
        }

    }

}
