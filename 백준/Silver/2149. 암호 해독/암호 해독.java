import java.io.*;
import java.util.*;

public class Main {

    private static Character[][] board;

    public static void main(String[] args) throws IOException {
        IO.init();

        // 각 key별 암호를 저장
        Map<Integer, List<Character>> map = new HashMap<>();

        // 키 및 암호문 받아오기
        char[] key = IO.read().toCharArray();
        char[] tmpKey = key.clone();
        int col = key.length;

        char[] password = IO.read().toCharArray();
        int row = password.length / col;

        // 정렬된 키 상태
        Arrays.sort(tmpKey);
        
        // 정렬된 키 순서에 따라 암호 저장
        for(int i = 0; i < col; i++) {
            List<Character> arr = map.getOrDefault(i, new ArrayList<>());

            for(int k = i * row; k < (i + 1) * row; k++)
                arr.add(password[k]);
            map.put(i, arr);
        }

        board = new Character[row][col];
        boolean[] visited = new boolean[col];

        // 기본 키에 맞게 board 배열에 재구성
        for(int i = 0; i < col; i++) {
            char now = key[i];

            // 현재 키에 맞는 정렬 키의 배열 찾기
            int k = 0;
            for(; k < col; k++) {
                if(visited[k] || now != tmpKey[k])
                    continue;

                visited[k] = true;
                break;
            }

            fillBoard(i, map.get(k));
        }

        for(int i = 0; i < row; i++)
            for(int k = 0; k < col; k++)
                IO.write(board[i][k]);

        IO.close();
    }
    private static void fillBoard(int col, List<Character> chars) {
        for(int i = 0; i < board.length; i++)
            board[i][col] = chars.get(i);
    }
}

class IO {
    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() throws IOException {
        bw.flush();
        bw.close();
        br.close();
    }

    public static String read() throws IOException {
        return br.readLine();
    }

    public static void write(Object message) throws IOException {
        bw.write(String.valueOf(message));
    }
}