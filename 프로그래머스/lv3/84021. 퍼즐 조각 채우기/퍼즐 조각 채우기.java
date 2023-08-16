import java.util.*;
import java.lang.*;

class Solution {
    private int len;
    private int[][] direction = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    private int[][] puzzleShape;
    private ArrayList<ArrayList<Integer>> puzzleBySize = new ArrayList<>();
    private ArrayList<int[]> visited = new ArrayList<>();
    private ArrayList<Puzzle> allPuzzle = new ArrayList<>();
    private int answer = 0;
    
    private int DFSInPuzzlePiece (int row, int col, int[] dirct, int[][] table, int visitedNum) {
        row = Math.max(Math.min(row + dirct[0], len - 1), 0);
        col = Math.max(Math.min(col + dirct[1], len - 1), 0);
        
        // 방문여부 검사
        if (table[row][col] == visitedNum)
            return 0;
        
        //방문 체크
        table[row][col] = visitedNum;
        puzzleShape[row][col] = 1;
        
        int puzzleSize = 1;
        for (int[] dir : this.direction)
            puzzleSize += DFSInPuzzlePiece(row, col, dir, table, visitedNum);
        
        return puzzleSize;
    }
    
    /** 퍼즐 길이 별 퍼즐 저장소 크기 늘리기 */
    private void extendToPuzzleBySize (int size) {
        for (int i = puzzleBySize.size(); i < size; i++)
            puzzleBySize.add(new ArrayList<>());
    }
    
    /** [퍼즐 찾기] 테이블에서 퍼즐 찾고, 퍼즐 길이 별 저장소 저장 & 퍼즐 객체 생성 */
    private void findPuzzlePiece (int[][] table) {
        int[] pos = startPosition(table);
        if (pos[0] == -1 || pos[1] == -1)
            return;
        
        int puzzleSize = DFSInPuzzlePiece(pos[0], pos[1], new int[]{0, 0}, table, 0);
        Puzzle puzzle = new Puzzle(puzzleSize, this.puzzleShape);
        extendToPuzzleBySize(puzzleSize); // puzzleBySize 크기 필요한 만큼 늘리기
        this.puzzleBySize.get(puzzleSize - 1).add(allPuzzle.size()); // 퍼즐 크기별 정리
        this.allPuzzle.add(puzzle); // 퍼즐 저장
        this.puzzleShape = new int[len][len]; // 퍼즐 모양 초기화
        
        findPuzzlePiece(table);
    }
    
    
    private int[] startPosition (int[][] puzzle) {
        for (int row = 0; row < len; row++)
            for (int col = 0; col < len; col++)
                if (puzzle[row][col] == 1)
                    return new int[]{row, col};
        return new int[]{-1, -1};
    }
            
    
    private boolean comparePuzzle (int[][] holeShape, int[][] compareShape, int[] holePosition, int[] comparePosition, int[] dirct) {
        holePosition[0] = Math.max(Math.min(holePosition[0] + dirct[0], len - 1), 0);
        holePosition[1] = Math.max(Math.min(holePosition[1] + dirct[1], len - 1), 0);
        comparePosition[0] = Math.max(Math.min(comparePosition[0] + dirct[0], len - 1), 0);
        comparePosition[1] = Math.max(Math.min(comparePosition[1] + dirct[1], len - 1), 0);
        
        if (holeShape[holePosition[0]][holePosition[1]] !=
           compareShape[comparePosition[0]][comparePosition[1]])
            return false;
        
        if (holeShape[holePosition[0]][holePosition[1]] == 0)
            return true;
        
        holeShape[holePosition[0]][holePosition[1]] = 0;
        compareShape[comparePosition[0]][comparePosition[1]] = 0;
        
        boolean flags;
        
        for (int[] dir : direction) {
            flags = comparePuzzle(holeShape, compareShape, holePosition.clone(), comparePosition.clone(), dir);
            if (!flags)
                return false;
        }
        
        return true;
    }
    
    private int[][] rotateBoard (int[][] board) {
        int[][] tmpBoard = new int[len][len];
        for (int i = 0; i < len; i++)
            for (int k = 0; k < len; k++)
                tmpBoard[i][k] = board[len - k - 1][i];
        return tmpBoard;
    }
    
    
    private void compareDFS (int[][] game_board) {
        for (int row = 0; row < this.len; row++) {
            for (int col = 0; col < this.len; col++) {
                if (game_board[row][col] == 0) {
                    int roadLength = DFSInPuzzlePiece(row, col, new int[]{0, 0}, game_board, 1);
                    if (puzzleBySize.size() < roadLength) {
                        visited.add(startPosition(this.puzzleShape));
                        this.puzzleShape = new int[this.len][this.len];
                        continue;
                    }
                        
                    ArrayList<Integer> sameSizePuzzleList = puzzleBySize.get(roadLength - 1);
                    
                    for (int puzzleIndex = 0; puzzleIndex < sameSizePuzzleList.size(); puzzleIndex++) {
                        int findPuzzleIndex = sameSizePuzzleList.get(puzzleIndex);
                        
                        Puzzle findPuzzle = allPuzzle.get(findPuzzleIndex);
                        int[][] compareShape = findPuzzle.getShape();
                        int[] holeStart = startPosition(this.puzzleShape);
                        int[] compareStart = startPosition(findPuzzle.getShape());
                        
                        if (comparePuzzle(deepCopy(puzzleShape), deepCopy(compareShape), holeStart, compareStart, new int[]{0, 0})) {
                            visited.add(holeStart);
                            answer += roadLength;
                            sameSizePuzzleList.remove(puzzleIndex);
                            break;
                        }
                    }
                    puzzleShape = new int[len][len];
                }
            }
        }
    }
    
    private int[][] deepCopy (int[][] board) {
        int[][] tmp = new int[len][len];
        for (int i = 0; i < len; i++)
            tmp[i] = board[i].clone();
        return tmp;
    }
    
    public int solution(int[][] game_board, int[][] table) {
        this.len = game_board.length;
        this.puzzleShape = new int[len][len];
        
        findPuzzlePiece(table);
        for (int rotate = 0; rotate < 4; rotate++) {
            compareDFS(deepCopy(game_board));
            
            for (int[] i : visited)
                DFSInPuzzlePiece(i[0], i[1], new int[]{0, 0}, game_board, 1);
            
            visited = new ArrayList<>();
            game_board = rotateBoard(game_board);
        }
        return answer;
    }
}

class Puzzle {
    private int size;
    private int[][] shape;
    
    public Puzzle (int size, int[][] shape) {
        this.size = size;
        this.shape = shape;
    }
    
    public int getSize() {
        return this.size;
    }
    
    public int[][] getShape() {
        return this.shape;
    }
}