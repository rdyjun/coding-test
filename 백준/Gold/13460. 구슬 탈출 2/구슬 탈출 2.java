import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] endPosition = new int[2];
        int[] redPosition = new int[2];
        int[] bluePosition = new int[2];

        // 보드 초기화
        int[][] board = new int[n][m];
        for (int r = 0; r < n; r++) {
            char[] charArray = br.readLine()
                    .toCharArray();
            
            for (int c = 0; c < m; c++) {
                if (charArray[c] == '#') {
                    board[r][c] = 1;
                    continue;
                }
                
                if (charArray[c] == 'R') {
                    redPosition[0] = r;
                    redPosition[1] = c;
                    continue;
                }

                if (charArray[c] == 'B') {
                    bluePosition[0] = r;
                    bluePosition[1] = c;
                    continue;
                }

                if (charArray[c] == 'O') {
                    endPosition[0] = r;
                    endPosition[1] = c;
                    board[r][c] = 2;
                    continue;
                }
            }
        }

        // 빨간 구슬, 파란 구슬 방문 여부
        boolean[][][][] visited = new boolean[n][m][n][m];
        visited[redPosition[0]][redPosition[1]][bluePosition[0]][bluePosition[1]] = true;
        
        Queue<Integer[]> q = new LinkedList<>();
        // RY, RX, C, BY, BX
        q.add(new Integer[]{redPosition[0], redPosition[1], 0, bluePosition[0], bluePosition[1]});

        while (!q.isEmpty()) {
            Integer[] pos = q.poll();
            Integer[] redPos = {pos[0], pos[1]};
            Integer[] bluePos = {pos[3], pos[4]};

            if (pos[2] >= 10) {
                continue;
            }

            for (int[] dir : direction) {
                // 이동 위치
                int[] movedRed = move(redPos[0], redPos[1], dir, board);
                int[] movedBlue = move(bluePos[0], bluePos[1], dir, board);

                // 같은 위치에 있는지
                if (movedRed[0] == movedBlue[0] && movedRed[1] == movedBlue[1]) {
                    // 둘 다 골인 경우 무시
                    if (movedRed[0] == endPosition[0] && movedRed[1] == endPosition[1]) {
                        continue;
                    }

                    // 빨간 구슬이 더 많이 움직인 경우 파란 구슬 뒤로
                    if (movedRed[2] > movedBlue[2]) {
                        movedRed[0] -= dir[0];
                        movedRed[1] -= dir[1];
                    }

                    // 파란 구슬이 더 많이 움직인 경우 빨간 구슬 뒤로
                    if (movedRed[2] < movedBlue[2]) {
                        movedBlue[0] -= dir[0];
                        movedBlue[1] -= dir[1];
                    }
                }

                // 이미 방문한 위치인 경우
                if (visited[movedRed[0]][movedRed[1]][movedBlue[0]][movedBlue[1]]) {
                    continue;
                }

                // 블루가 골인 경우
                if (movedBlue[0] == endPosition[0] && movedBlue[1] == endPosition[1]) {
                    continue;
                }

                // 레드가 골인 경우
                if (movedRed[0] == endPosition[0] && movedRed[1] == endPosition[1]) {
                    System.out.println(pos[2] + 1);
                    return;
                }

                visited[movedRed[0]][movedRed[1]][movedBlue[0]][movedBlue[1]] = true;
                q.add(new Integer[]{movedRed[0], movedRed[1], pos[2] + 1, movedBlue[0], movedBlue[1]});
            }
        }

        System.out.println(-1);
    }

    private static int[] move(int y, int x, int[] dir, int[][] board) {
        int cnt = 0;
        while (board[y][x] == 0) {
            y += dir[0];
            x += dir[1];
            cnt++;

            // 골인 지점인 경우 골인 지점 반환
            if (board[y][x] == 2) {
                return new int[]{y, x, cnt};
            }
        }

        return new int[]{y - dir[0], x - dir[1], cnt - 1};
    }
}
