import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class Main {

    private static int k;

    private static int w;

    private static int h;

    private static int[][] board;

    public static void main(String[] args) {
        IO.init();

        String[] input = IO.read().split(" ");
        k = Integer.parseInt(input[0]);

        input = IO.read().split(" ");
        w = Integer.parseInt(input[0]);
        h = Integer.parseInt(input[1]);
        board = new int[h][w];

        initializeBoard();

        IO.write(result());
        IO.close();
    }

    private static int result() {
        Queue<Position> nextNode = new LinkedList<>();
        nextNode.add(new Position(0, 0, k, 0));

        Set<Position> visited = new HashSet<>();

        while (!nextNode.isEmpty()) {
            Position now = nextNode.poll();

            if (now.isHere(w - 1, h - 1)) {
                return now.getMoveCount();
            }

            if (!now.isValid(h, w, board) || visited.contains(now)) {
                continue;
            }

            visited.add(now);

            now.moveNextPosition(nextNode);

            if (now.isCountZero()) {
                continue;
            }

            now.moveHorseStep(nextNode);
        }

        return -1;
    }

    private static void initializeBoard() {
        for (int r = 0; r < h; r++) {
            String[] input = IO.read()
                    .split(" ");

            for (int c = 0; c < w; c++) {
                board[r][c] = Integer.parseInt(input[c]);
            }
        }
    }

}

class Position implements Comparable<Position> {

    private final int x;

    private final int y;

    private final int horseStepCount;

    private final int moveCount;

    public Position(int x, int y, int horseStepCount, int moveCount) {
        this.x = x;
        this.y = y;
        this.horseStepCount = horseStepCount;
        this.moveCount = moveCount;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public boolean isHere(int w, int h) {
        return !(w != x || h != y);
    }

    public void moveNextPosition(Queue<Position> queue) {
        queue.add(new Position(this.x - 1, this.y, this.horseStepCount, this.moveCount + 1));
        queue.add(new Position(this.x + 1, this.y, this.horseStepCount, this.moveCount + 1));
        queue.add(new Position(this.x, this.y - 1, this.horseStepCount, this.moveCount + 1));
        queue.add(new Position(this.x , this.y + 1, this.horseStepCount, this.moveCount + 1));
    }

    public void moveHorseStep(Queue<Position> queue) {
        queue.add(new Position(this.x - 1, this.y - 2, this.horseStepCount - 1, this.moveCount + 1));
        queue.add(new Position(this.x - 2, this.y - 1, this.horseStepCount - 1, this.moveCount + 1));
        queue.add(new Position(this.x - 1, this.y + 2, this.horseStepCount - 1, this.moveCount + 1));
        queue.add(new Position(this.x - 2, this.y + 1, this.horseStepCount - 1, this.moveCount + 1));
        queue.add(new Position(this.x + 1, this.y - 2, this.horseStepCount - 1, this.moveCount + 1));
        queue.add(new Position(this.x + 2, this.y - 1, this.horseStepCount - 1, this.moveCount + 1));
        queue.add(new Position(this.x + 1, this.y + 2, this.horseStepCount - 1, this.moveCount + 1));
        queue.add(new Position(this.x + 2, this.y + 1, this.horseStepCount - 1, this.moveCount + 1));
    }

    public boolean isCountZero() {
        return this.horseStepCount <= 0;
    }

    public boolean isValid(int h, int w, int[][] board) {
        return !(x < 0 || y < 0 || x >= w || y >= h || board[this.y][this.x] == 1);
    }

    @Override
    public int compareTo(Position otherPosition) {
        if (this.x > otherPosition.x) {
            return 1;
        }

        if (this.y != otherPosition.y) {
            return -1;
        }

        if (this.horseStepCount != otherPosition.horseStepCount) {
            return -1;
        }

        return 0;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Position position = (Position) other;
        return this.x == position.x &&
                this.y == position.y &&
                this.horseStepCount == position.horseStepCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, horseStepCount);
    }

}

class IO {

    private static BufferedReader reader;
    private static BufferedWriter writer;

    public static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() {
        try {
            writer.flush();
            writer.close();
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String read() {
        String input = null;
        try {
            input = reader.readLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (input == null) {
            throw new IllegalArgumentException();
        }

        return input;
    }

    public static void write(Object message) {
        try {
            writer.write(String.valueOf(message));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
