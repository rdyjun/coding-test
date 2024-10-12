import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    private Set<Board> visited = new HashSet<>();
    
    public int solution(int[][] beginning, int[][] target) {
        Board beginningBoard = new Board(beginning, 0);
        Board targetBoard = new Board(target, 0);
        
        if (beginningBoard.equals(targetBoard)) {
            return 0;
        }
        
        Queue<Board> queue = new LinkedList<>();
        queue.add(beginningBoard);
        visited.add(beginningBoard);
        
        while (!queue.isEmpty()) {
            Board board = queue.poll();
            
            for (int row = 0; row < beginning.length; row++) {
                Board rowUpdatedBoard = board.getBoardUpdatedByRow(row);
                
                if (!this.visited.contains(rowUpdatedBoard)) {
                    queue.add(rowUpdatedBoard);
                    this.visited.add(rowUpdatedBoard);
                    if (rowUpdatedBoard.equals(targetBoard)) {
                        return board.count + 1;
                    }
                }

            }
            
            for (int column = 0; column < beginning[0].length; column++) {
                Board columnUpdatedBoard = board.getBoardUpdatedByColumn(column);
                
                if (!this.visited.contains(columnUpdatedBoard)) {
                    queue.add(columnUpdatedBoard);
                    this.visited.add(columnUpdatedBoard);
                    if (columnUpdatedBoard.equals(targetBoard)) {
                        return board.count + 1;
                    }
                }
            }
        }
        
        return -1;
    }
}

class Board {
    public int[][] board;
    public int count;
    
    public Board(int[][] board, int count) {
        this.board = board;
        this.count = count;
    }
    
    public boolean equals(Object compareObject) {
        if (compareObject == this) return true;
        if (!(compareObject instanceof Board)) return false;
        
        Board compareTarget = (Board) compareObject;
        return Arrays.deepEquals(this.board, compareTarget.board);
    }
    
    public int hashCode() {
        return Arrays.deepHashCode(this.board);
    }
    
    public Board getBoardUpdatedByRow(int row) {
        int[][] newBoard = copyBoard();
        for (int column = 0; column < this.board[0].length; column++) {
            newBoard[row][column] = newBoard[row][column] ^ 1;
        }
        
        return new Board(newBoard, this.count + 1);
    }
    
    public Board getBoardUpdatedByColumn(int column) {
        int[][] newBoard = copyBoard();
        for (int row = 0; row < this.board.length; row++) {
            newBoard[row][column] = newBoard[row][column] ^ 1;
        }
        
        return new Board(newBoard, this.count + 1);
    }
    
    private int[][] copyBoard() {
        int height = this.board.length;
        int width = this.board[0].length;
        int[][] newBoard = new int[height][width];
        
        for (int row = 0; row < height; row++) {
            newBoard[row] = this.board[row].clone();
        }
        
        return newBoard;
    }
}