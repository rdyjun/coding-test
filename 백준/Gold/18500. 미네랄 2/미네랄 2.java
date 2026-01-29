import java.util.*;
import java.io.*;

public class Main{

    private static final int[][] dir = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 동굴 크기
        int r = Integer.parseInt(st.nextToken()); // 행
        int c = Integer.parseInt(st.nextToken()); // 열

        // 동굴 초기화
        char[][] cave = new char[r][c];
        for (int row = 0; row < r; row++) {
            cave[row] = br.readLine().toCharArray();
        }

        // 막대를 던진 횟수
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        // 막대 던지기 (i가 짝수일 때 -> 방향 홀수일 때 <- 방향)
        for (int i = 0; i < n; i++) {
            // 던진 높이
            int h = r - Integer.parseInt(st.nextToken());

            // 맞는 미네랄 찾기
            int index = getMineralIndex(i % 2, h, cave);
            if (index == -1) { // 해당 행에 미네랄이 없으면 무시
                continue;
            }

            // 미네랄 제거
            cave[h][index] = '.';
            
            // 주변 클러스터 이동
            moved(h, index, r, c, cave);
        }

        // 동굴 상태 출력
        for (int row = 0; row < r; row++) {
            for (int column = 0; column < c; column++) {
                System.out.print(cave[row][column]);
            }
            System.out.println();
        }
    }

    // 방향과 높이, 동굴 정보를 입력받아 미네랄 위치 찾기
    private static int getMineralIndex(int dir, int height, char[][] cave) {
        // -> 방향으로 던짐
        if (dir == 0) {
            // 특정 높이에서 가장 먼저 나오는 미네랄 위치 반환
            for (int c = 0; c < cave[0].length; c++) {
                if (cave[height][c] == 'x') {
                    return c;
                }
            }
        }

        // <- 방향으로 던짐
        if (dir == 1) {
            // 특정 높이에서 가장 먼저 나오는 미네랄 위치 반환
            for (int c = cave[0].length - 1; c >= 0; c--) {
                if (cave[height][c] == 'x') {
                    return c;
                }
            }
        }

        return -1;
    }

    private static void moved(int mineralRow, int mineralColumn, int r, int c, char[][] cave) {
        boolean[][] visited = new boolean[r][c];
        
        // 제거한 미네랄 주위 클러스터 검사
        for (int[] d : dir) {
            int y = mineralRow + d[0];
            int x = mineralColumn + d[1];

            // 갈 수 없는 위치거나 클러스터가 아닌 경우 무시
            if (y < 0 || x < 0 || y >= r || x >= c || cave[y][x] == '.' || visited[y][x]) {
                continue;
            }
            
            bfs(y, x, r, c, cave, visited);
        }
    }

    private static void bfs(int mineralY, int mineralX, int r, int c, char[][] cave, boolean[][] visited) {
        // 클러스터의 열 중 가장 바닥에 있는 요소의 행 저장
        int maxHeight = 0;
        List<Integer[]> graph = new ArrayList<>(); // 클러스터 각 좌표를 저장하기 위한 배열
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{mineralY, mineralX});
        visited[mineralY][mineralX] = true;

        while (!q.isEmpty()) {
            Integer[] pos = q.poll();

            maxHeight = Math.max(maxHeight, pos[0]);     // 가장 밑에있는 요소의 높이
            graph.add(pos);

            for (int[] d : dir) {
                int y = pos[0] + d[0];
                int x = pos[1] + d[1];
                
                // 갈 수 없는 위치거나 클러스터가 아닌 경우 무시
                if (y < 0 || x < 0 || y >= r || x >= c || cave[y][x] == '.' || visited[y][x]) {
                    continue;
                }

                q.add(new Integer[]{y, x});
                visited[y][x] = true;
            }
        }

        // 동굴 내 대상 클러스터 제거
        for (Integer[] node : graph) {
            cave[node[0]][node[1]] = '.';
        }

        int depth = 1;

        // 대상 클러스터가 이동할 수 있는지 검사
        for (; depth < r - maxHeight ; depth++) {
            boolean cantMove = false;

            for (Integer[] node : graph) {
                // 해당 위치에 놓을 수 없는 경우
                if (cave[node[0] + depth][node[1]] == 'x') {
                    cantMove = true;
                }
            }

            if (cantMove) {
                break;
            }
        }

        // 이동할 수 있는 경우 이동 처리
        for (Integer[] node : graph) {
            cave[node[0] + depth - 1][node[1]] = 'x';
        }
    }
}
