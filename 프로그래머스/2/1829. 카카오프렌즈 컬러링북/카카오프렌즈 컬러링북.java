import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    private int max = 0;
    
    public int[] solution(int m, int n, int[][] picture) {
        Picture pic = new Picture(picture);
        
        return pic.findArea();
    }
    
}

class Picture {
    
    private Integer[][] picture;
    
    private Integer width;
    
    private Integer height;
    
    private Integer areaCount = 0;
    
    public Picture(int[][] picture) {
        this.height = picture.length;
        this.width = picture[0].length;
        this.picture = new Integer[this.height][this.width];
        
        for (int row = 0; row < this.height; row++) {
            for (int column = 0; column < this.width; column++) {
                this.picture[row][column] = picture[row][column];
            }
        }
    }
    
    public int[] findArea() {
        int maxArea = 0;
        
        for (int row = 0; row < this.height; row++) {
            for (int column = 0; column < this.width; column++) {
                if (this.picture[row][column] < 0) {
                    continue;
                }
                
                maxArea = Math.max(maxArea, searchArea(row, column));
            }
        }
        
        return new int[]{this.areaCount, maxArea};
    }
    
    private int searchArea(int r, int c) {
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        
        int number = this.picture[r][c];
        int result = 0;
        
        if (number > 0) {
            this.areaCount++;
        }
        
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(r, c));
        
        while (!q.isEmpty()) {
            Position now = q.poll();
            
            if (getValue(now) != number) {
                continue;
            }
            
            checkVisited(now);
            
            result++;
            
            for (int[] direction : directions) {
                Position nextPosition = now.getMovedPosition(direction);
                
                if (validatePosition(nextPosition)) {
                    q.add(nextPosition);
                }
            }
        }
        
        if (number == 0) {
            return -1;
        }
        
        return result;
    }
    
    private boolean validatePosition(Position position) {
        int row = position.getRow();
        int column = position.getColumn();
        
        if (row < 0 ||
           row >= this.height ||
           column < 0 ||
           column >= this.width) {
            return false;
        }
        
        return true;
    }
    
    private void checkVisited(Position position) {
        this.picture[position.getRow()][position.getColumn()] = -1;
    }
    
    private int getValue(Position position) {
        return this.picture[position.getRow()][position.getColumn()];
    }
    
    private boolean isvisited(int r, int c) {
        if (this.picture[r][c] == -1) {
            return true;
        }
        
        return false;
    }
    
}

class Position {
    
    private Integer row;
    
    private Integer column;
    
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
    public Integer getRow() {
        return this.row;
    }
    
    public Integer getColumn() {
        return this.column;
    }
    
    public Position getMovedPosition(int[] direction) {
        return new Position(this.row + direction[0], this.column + direction[1]);
    }
    
}
