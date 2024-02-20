import java.io.*;

public class Main {
    
    private static int[][] board;

    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        IO.init();

        String[] input = IO.read().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        board = new int[n][m];

        // 보드 초기화
        for(int i = 0; i < n; i++) {
            input = IO.read().split(" ");
            
            for(int k = 0; k < m; k++)
                board[i][k] = Integer.parseInt(input[k]);
        }

        // 5가지 케이스별 최대값 가져오기
        IO.write(String.valueOf(getMax()));

        IO.close();
    }

    private static int getMax() {
        int max = case1();
        int tmp = case2();

        if(tmp > max)
            max = tmp;

        tmp = case3();
        if(tmp > max)
            max = tmp;

        tmp = case4();
        if(tmp > max)
            max = tmp;

        tmp = case5();
        if(tmp > max)
            max = tmp;

        return max;
    }
    
    private static int case1() {
        int max = 0;
        int result = 0;

        for(int i = 0; i < n; i++) {
            for (int k = 0; k < m - 3; k++) {
                result = board[i][k];
                result += board[i][k + 1];
                result += board[i][k + 2];
                result += board[i][k + 3];

                if(max < result)
                    max = result;
            }
        }

        for(int i = 0; i < n - 3; i++) {
            for(int k = 0; k < m; k++) {
                result = board[i][k];
                result += board[i + 1][k];
                result += board[i + 2][k];
                result += board[i + 3][k];

                if(max < result)
                    max = result;
            }
        }
        return max;
    }

    // 정사각형 모양
    private static int case2() {
        int max = 0;
        int result = 0;

        for(int i = 0; i < n - 1; i++) {
            for(int k = 0; k < m - 1; k++) {
                result = board[i][k];
                result += board[i + 1][k];
                result += board[i][k + 1];
                result += board[i + 1][k + 1];

                if(result > max)
                    max = result;
            }
        }

        return max;
    }
    
    // L자 모양
    private static int case3() {
        int max = 0;
        int result = 0;

        // L
        for(int i = 0; i < n - 2; i++) {
            for(int k = 0; k < m - 1; k++) {
                result = board[i][k];
                result += board[i + 1][k];
                result += board[i + 2][k];
                result += board[i + 2][k + 1];

                if(result > max)
                    max = result;

                // 왼쪽으로 뒤집은 L
                result = board[i][k + 1];
                result += board[i + 1][k + 1];
                result += board[i + 2][k + 1];
                result += board[i + 2][k];

                if(result > max)
                    max = result;

                // 위로 뒤집은 L : ┌
                result = board[i][k];
                result += board[i + 1][k];
                result += board[i + 2][k];
                result += board[i][k + 1];

                if(result > max)
                    max = result;

                // 위 및 왼쪽으로 뒤집은 L : ┐
                result = board[i][k];
                result += board[i][k + 1];
                result += board[i + 1][k + 1];
                result += board[i + 2][k + 1];

                if(result > max)
                    max = result;
            }
        }

        for(int i = 1; i < n; i++) {
            for(int k = 0; k < m - 2; k++) {
                // 왼쪽으로 누운 L
                result = board[i][k];
                result += board[i][k + 1];
                result += board[i][k + 2];
                result += board[i - 1][k + 2];

                if(result > max)
                    max = result;

                // 왼쪽으로 누운 L을 위로 뒤집은 L : ㄱ
                result = board[i - 1][k];
                result += board[i - 1][k + 1];
                result += board[i - 1][k + 2];
                result += board[i][k + 2];

                if(result > max)
                    max = result;

                // 오른쪽으로 누운 L
                result = board[i - 1][k];
                result += board[i][k];
                result += board[i - 1][k + 1];
                result += board[i - 1][k + 2];

                if(result > max)
                    max = result;

                // 오른쪽으로 누운 L을 뒤집은 L
                result = board[i - 1][k];
                result += board[i][k];
                result += board[i][k + 1];
                result += board[i][k + 2];

                if(result > max)
                    max = result;
            }
        }

        return max;
    }
    
    private static int case4() {
        int max = 0;
        int result = 0;

        //정방향
        for(int i = 0; i < n - 2; i++) {
            for(int k = 0; k < m - 1; k++) {
                result = board[i][k];
                result += board[i + 1][k];
                result += board[i + 1][k + 1];
                result += board[i + 2][k + 1];

                if(result > max)
                    max = result;

                result = board[i][k + 1];
                result += board[i + 1][k + 1];
                result += board[i + 1][k];
                result += board[i + 2][k];

                if(result > max)
                    max = result;
            }
        }

        // 옆으로 돌렸을 때
        for(int i = 1; i < n; i++) {
            for(int k = 0; k < m - 2; k++) {
                result = board[i][k];
                result += board[i][k + 1];
                result += board[i - 1][k + 1];
                result += board[i - 1][k + 2];

                if(result > max)
                    max = result;

                result = board[i - 1][k];
                result += board[i - 1][k + 1];
                result += board[i][k + 1];
                result += board[i][k + 2];

                if(result > max)
                    max = result;
            }
        }

        return max;
    }
    
    private static int case5() {
        int max = 0;
        int result = 0;
        
        for(int i = 0; i < n - 1; i++) {
            for(int k = 0; k < m - 2; k++) {
                // ㅜ 모양
                result = board[i][k];
                result += board[i][k + 1];
                result += board[i][k + 2];
                result += board[i + 1][k + 1];

                if(result > max)
                    max = result;

                // ㅗ 모양
                result = board[i + 1][k];
                result += board[i + 1][k + 1];
                result += board[i + 1][k + 2];
                result += board[i][k + 1];

                if(result > max)
                    max = result;
            }
        }
        
        for(int i = 0; i < n - 2; i++) {
            for(int k = 1; k < m; k++) {
                // ㅓ 모양
                result = board[i][k];
                result += board[i + 1][k];
                result += board[i + 1][k - 1];
                result += board[i + 2][k];

                if(result > max)
                    max = result;

                // ㅏ 모양
                result = board[i][k - 1];
                result += board[i + 1][k - 1];
                result += board[i + 1][k];
                result += board[i + 2][k - 1];

                if(result > max)
                    max = result;
            }
        }

        return max;
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

    public static void write(String message) throws IOException {
        bw.write(message);
    }
}