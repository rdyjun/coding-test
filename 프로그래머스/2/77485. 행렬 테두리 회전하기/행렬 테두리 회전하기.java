class Solution {
    
    private int[][] board;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int querieLen = queries.length;
        int[] answer = new int[querieLen];
        
        initializeBoard(rows, columns);
            
        for (int index = 0; index < querieLen; index++) {
            answer[index] = rotate(queries[index]);
        }
        
        return answer;
    }
    
    private void initializeBoard(int rows, int columns) {
        this.board = new int[rows][columns];
        int number = 1;
        
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                board[row][column] = number;
                number++;
            }
        }
    }
    
    private int rotate(int[] querie) {
        int tmp = this.board[querie[0] - 1][querie[1] - 1];
        int min = tmp;
        int move = 1;
        int r = querie[0];
        int c = querie[1] - 1;
        
        while (r > querie[0] - 1 || c > querie[1] - 1) {
            if (min > this.board[r][c]) {
                min = this.board[r][c];
            }
            
            switch (move) {
                case 1:
                    this.board[r - 1][c] = this.board[r][c];
                    
                    if (r == querie[2] - 1) {
                        move = 2;
                        c++;
                        break;
                    }
                    
                    r++;
                    
                    break;
                    
                case 2:
                    this.board[r][c - 1] = this.board[r][c];
                    
                    if (c == querie[3] - 1) {
                        move = 3;
                        r--;
                        break;
                    }
                    
                    c++;
                    
                    break;
                    
                case 3:
                    this.board[r + 1][c] = this.board[r][c];
                    
                    if (r == querie[0] - 1) {
                        move = 4;
                        c--;
                        break;
                    }
                    
                    r--;
                    
                    break;
                    
                case 4:
                    this.board[r][c + 1] = this.board[r][c];
                    c--;
                    
                    break;
            }
        }
        
        this.board[querie[0] - 1][querie[1]] = tmp;
        
        return min;
    }
    
}