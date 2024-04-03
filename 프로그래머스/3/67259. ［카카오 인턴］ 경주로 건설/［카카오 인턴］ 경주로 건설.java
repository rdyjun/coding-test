import java.util.PriorityQueue;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

class Solution {
    
    private static final Integer RIGHT_DIR = 1;
    
    private static final Integer BOTTOM_DIR = 2;
    
    private static final Integer LEFT_DIR = 3;
    
    private static final Integer TOP_DIR = 4;
    
    public int solution(int[][] board) {
        int height = board.length;
        int width = board[0].length;
        
        board[0][0] = 1;
        
        int answer = Integer.MAX_VALUE;
        
        Set<Position> visited = new HashSet<>();
        
        PriorityQueue<Position> q = new PriorityQueue<>();
        q.add(new Position(0, 1, 100, RIGHT_DIR));
        q.add(new Position(1, 0, 100, BOTTOM_DIR));
        
        while (!q.isEmpty()) {
            Position now = q.poll();
            
            if (!now.available(board) ||
               visited.contains(now)) {
                continue;
            }
            
            visited.add(now);
            
            if (now.isHere(height - 1, width - 1)) {
                int n = now.getCost();
                if (answer > n) {
                    answer = n;
                }
            }
            
            for (int dir = RIGHT_DIR; dir <= TOP_DIR; dir++) {
                q.add(now.move(dir));
            }
        }
        return answer;
    }
    
}

class Position implements Comparable<Position> {
    
    private int r;
    
    private int c;
    
    private int cost;
    
    private int dir;
    
    public Position(int r, int c, int cost, int dir) {
        this.r = r;
        this.c = c;
        this.cost = cost;
        this.dir = dir;
    }
    
    public boolean available(int[][] board) {
        int height = board.length;
        int width = board[0].length;
        
        if (this.r >= height ||
            this.r < 0 ||
            this.c >= width ||
            this.c < 0) {
            return false;
        }
        
        if (board[this.r][this.c] == 0) {
            return true;
        }
        
        return false;
    }
    
    public Position move(int dir) {
        int cost = this.cost;
        cost += 100;
        
        if (this.dir != dir) {
            cost += 500;
        }
        
        return getNextPosition(dir, cost);
    }
    
    private Position getNextPosition(int dir, int cost) {
        switch (dir) {
            case 1:
                return new Position(this.r, this.c + 1, cost, dir);
            case 2:
                return new Position(this.r + 1, this.c, cost, dir);
            case 3:
                return new Position(this.r, this.c - 1, cost, dir);
            case 4:
                return new Position(this.r - 1, this.c, cost, dir);
        }
        
        return null;
    }
    
    public int getCost() {
        return this.cost;
    }
    
    public boolean isHere(int r, int c) {
        return this.r == r && this.c == c;
    }
    
    @Override
    public int compareTo(Position p) {
        if (this.cost > p.cost) {
            return 1;
        }
        
        if (this.cost < p.cost) {
            return -1;
        }
        
        return 0;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null ||
           o.getClass() != getClass()) {
            return false;
        }
        
        Position p = (Position) o;
        
        if (this.r != p.r ||
           this.c != p.c ||
           this.dir != p.dir) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.r, this.c, this.dir);
    }
    
}