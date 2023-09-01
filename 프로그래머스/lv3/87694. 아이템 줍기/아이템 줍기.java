import java.util.*;
import java.lang.*;

// 힌트 참고
class Solution {
    private int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private Rect[] rectGroup;
    
    private boolean isInner (int posX, int posY) {
        for (Rect rect : this.rectGroup)
            if (rect.isOverlap(posX, posY))
                return true;
        return false;
    }
    
    public int getMax (int[][] rectangle, int index) {
        return Arrays.stream(rectangle)
            .mapToInt(v -> v[index])
            .max()
            .orElseThrow(() -> new NoSuchElementException("x 값이 존재하지 않습니다."));
    }
    private void printBoard (Board board, int maxX, int maxY) {
        for (int k = maxY; k >= 0; k--) {
            for (int i = 0; i < maxX; i++) {
                System.out.print((board.get(i, k) ? 1 : 0) + " ");
            }
            System.out.println("");
        }
    }
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int rectCount = rectangle.length;
        this.rectGroup = new Rect[rectCount];
        
        int maxX = getMax(rectangle, 2) * 2;
        int maxY = getMax(rectangle, 3) * 2;
        
        Board board = new Board(maxX, maxY);
        
        for (int i = 0; i < rectCount; i++) {
            Rect rect = new Rect(rectangle[i]);
            rectGroup[i] = rect;
            board.draw(rect);
        }
        
        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();
        Queue<Integer> c = new LinkedList<>();
        
        xq.add(characterX * 2);
        yq.add(characterY * 2);
        c.add(0);
        
        while (!xq.isEmpty()) {
            int x = Math.max(Math.min(xq.poll(), maxX), 0);
            int y = Math.max(Math.min(yq.poll(), maxY), 0);
            int count = c.poll();
            
            if(!board.get(x, y) || isInner(x, y))
                continue;
            
            System.out.println(x + " " + y);
            
            board.visited(x, y);
            
            if (x == itemX * 2 && y == itemY * 2)
                return count / 2;
            
            for (int[] i : dir) {
                xq.add(x + i[0]);
                yq.add(y + i[1]);
                c.add(count + 1);
            }
        }
        return -1;
    }
}

class Rect {
    private Position start;
    private Position end;
    
    public Rect (int[] rect) {
        this.start = new Position(rect[0] * 2, rect[1] * 2);
        this.end = new Position(rect[2] * 2, rect[3] * 2);
    }
    
    public Position getStart () {
        return this.start;
    }
    public Position getEnd () {
        return this.end;
    }
    
    public boolean isOverlap (int x, int y) {
        return start.getX() < x
            && end.getX() > x
            && start.getY() < y
            && end.getY() > y;
    }
}

class Board {
    private boolean[][] board;
    
    public Board (int width, int height) {
        this.board = new boolean[width + 1][height + 1];
    }
    
    public boolean get (int x, int y) {
        return this.board[x][y];
    }
    
    public void visited (int x, int y) {
        this.board[x][y] = false;
    }
    
    public void draw (Rect rect) {
        Position start = rect.getStart();
        Position end = rect.getEnd();
        
        int startX = start.getX();
        int startY = start.getY();
        int endX = end.getX();
        int endY = end.getY();
        
        for (int i = startX; i <= endX; i++) {
            board[i][startY] = true;
            board[i][endY] = true;
        }
        
        for (int i = startY; i <= endY; i++) {
            board[startX][i] = true;
            board[endX][i] = true;
        }
    }
}

class Position {
    private int x;
    private int y;
    
    public Position (int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX () {
        return x;
    }
    
    public int getY () {
        return y;
    }
}