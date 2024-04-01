import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

class Solution {
    
    private int height;
    
    private int width;
    
    private int[] total;
    
    private int[][] land;
    
    public int solution(int[][] land) {
        this.land = land;
        this.height = land.length;
        this.width = land[0].length;
        this.total = new int[this.width];
        
        rotateAll();
        
        return getMax();
    }
    
    private int getMax() {
        int max = 0;
        
        for (int value : this.total) {
            if (value > max) {
                max = value;
            }
        }
        
        return max;
    }
    
    private void rotateAll() {
        for (int r = 0; r < this.height; r++) {
            for (int c = 0; c < this.width; c++) {
                checkPosition(r, c);
            }
        }
    }
    
    private void checkPosition(int r, int c) {
        if (this.land[r][c] > 0) {
            search(r, c);
        }
    }
    
    private void search(int r, int c) {
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(r, c));
        
        Set<Integer> visitedColumn = new HashSet<>();
        
        int sum = 0;
        
        while (!q.isEmpty()) {
            Position position = q.poll();
            int row = position.getRow();
            int column = position.getColumn();
            
            if (this.land[row][column] <= 0) {
                continue;
            }
            
            visitedColumn.add(column);
            
            this.land[row][column] = -1;
            sum++;
            
            if (row > 0) {
                q.add(new Position(row - 1, column));
            }
            
            if (row < this.height - 1) {
                q.add(new Position(row + 1, column));
            }
        
            if (column > 0) {
                q.add(new Position(row, column - 1));
            }
        
            if (column < this.width - 1) {
                q.add(new Position(row, column + 1));
            }
        }
        
        for (Integer eachVisitedColumn : visitedColumn) {
            this.total[eachVisitedColumn] += sum;
        }
    }
    
}

class Position {
    
    private int r;
    
    private int c;
    
    public Position(int r, int c) {
        this.r = r;
        this.c = c;
    }
    
    public int getRow() {
        return this.r;
    }
    
    public int getColumn() {
        return this.c;
    }
    
    @Override
    public boolean equals(Object o) {
        Position position = (Position) o;
        
        if (position.r != this.r||
           position.c != this.c) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.r, this.c);
    }
    
}