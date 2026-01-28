import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // →, ←, ↑, ↓
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        int n = Integer.parseInt(st.nextToken()); // 체스판 크기
        int k = Integer.parseInt(st.nextToken()); // 말의 수

        // 보드 색 정보 채우기
        int[][] boardColorInfo = new int[n][n];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                boardColorInfo[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 말을 올릴 보드 초기화
        List<List<Deque<Integer>>> board = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            List<Deque<Integer>> lst = new ArrayList<>();
            for (int c = 0; c < n; c++) {
                lst.add(new ArrayDeque<>());
            }
            
            board.add(lst);
        }

        // 보드 위 말 배치
        int[][] horses = new int[k][3];      // 인덱스별 말 정보
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int moveType = Integer.parseInt(st.nextToken()); // 1부터 4까지 →, ←, ↑, ↓
            
            horses[i] = new int[]{row - 1, col - 1, moveType - 1}; // 말 정보 등록
            // 보드 위 말 인덱스 저장
            board.get(row - 1)
                 .get(col - 1)
                 .add(i);
        }

        int answer = -1;

        // 최대 턴 수인 1000만큼 검사 (i는 최대 10_000)
        for (int turn = 1; turn <= 1000; turn++) {

            // 턴마다 순서대로 각 말 이동
            for (int index = 0; index < k; index++) {
                // 현재 말의 위치
                int currentY = horses[index][0];
                int currentX = horses[index][1];
    
                // 가장 밑에 있지 않은 경우 해당 말 움직임 무시
                Deque<Integer> horseDeque = board.get(currentY).get(currentX);
                if (horseDeque.peekFirst() != index) {
                    continue;
                }
                
                int[] direction = dir[horses[index][2]];
    
                // 다음 좌표
                int nextY = currentY + direction[0]; // 다음 y좌표
                int nextX = currentX + direction[1]; // 다음 x좌표
    
                // -------------더 이상 움직일 수 없는 위치거나 파란색인 경우-------------
                if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= n || boardColorInfo[nextY][nextX] == 2) {
                    // 말 이동 방향 바꾸기
                    if (horses[index][2] % 2 == 0) {
                        horses[index][2]++;
                    } else {
                        horses[index][2]--;
                    }
    
                    // 반대 좌표
                    nextY = currentY - direction[0];
                    nextX = currentX - direction[1];
    
                    // 반대도 파란색인 경우 아무 작업 안함 (제자리)
                    if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= n || boardColorInfo[nextY][nextX] == 2) {
                        continue;
                    }
                }
    
                // -------------빨간색인 경우-------------
                if (boardColorInfo[nextY][nextX] == 1) {
                    // 꺼낸 말들 다시 저장
                    Deque<Integer> onBoard = board.get(nextY).get(nextX);
                    while (!horseDeque.isEmpty()) {
                        int horseIndex = horseDeque.removeLast(); // 순서 반대로 저장
    
                        // 말 개별 좌표 업데이트
                        horses[horseIndex][0] = nextY; // y좌표 업데이트
                        horses[horseIndex][1] = nextX; // x좌표 업데이트
    
                        // 보드 위 말 상태 업데이트
                        onBoard.add(horseIndex);
                    }
                }
    
                // ------------흰색인 경우-------------
                if (boardColorInfo[nextY][nextX] == 0) {
                    // 꺼낸 말들 해당 위치에 추가 저장
                    Deque<Integer> onBoard = board.get(nextY).get(nextX);
                    while (!horseDeque.isEmpty()) {
                        int horseIndex = horseDeque.removeFirst();
        
                        // 말 개별 좌표 업데이트
                        horses[horseIndex][0] = nextY; // y좌표 업데이트
                        horses[horseIndex][1] = nextX; // x좌표 업데이트
        
                        // 보드 위 말 상태 업데이트
                        onBoard.add(horseIndex);
                    }
                }

                // 이동 후 말이 4개 이상 쌓인 경우 종료
                if (board.get(nextY).get(nextX).size() >= 4) {
                    System.out.println(turn);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
