import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int row = 0; row < 5; row++) {
            answer[row] = validateTable(places[row]);
        }
        
        return answer;
    }
    
    private int validateTable(String[] places) {
        for (int r = 0; r < 5; r++) {
            String place = places[r];
            
            for (int c = 0; c < 5; c++) {
                if (places[r].charAt(c) != 'P') {
                    continue;
                }
                
                if (!validate(r, c, places)) {
                    return 0;
                }
            }
        }
        
        return 1;
    }
    
    private boolean validate(int r, int c, String[] places) {
        Queue<Position> q = new LinkedList<>();
        
        Position start = new Position(c, r, 0);
        q.add(start.getRight());
        q.add(start.getBottom());
        q.add(start.getLeft());
        
        while (!q.isEmpty()) {
            Position p = q.poll();
            
            if (!p.isAvailable() ||
                p.isPatition(places) ||
                p.isStart(c, r)) {
                continue;
            }
            
            if (p.isPersonHere(places)) {
                return false;
            }
            
            q.add(p.getRight());
            q.add(p.getBottom());
            q.add(p.getLeft());
        }
        
        return true;
    }
    
}

class Position {
    
    private int x;
    
    private int y;
    
    private int c;
    
    public Position(int x, int y, int c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }
    
    public boolean isAvailable() {
        if (this.x < 0 ||
            this.x >= 5 || 
            this.y < 0 ||
            this.y >= 5 || 
            this.c >= 3) {
            return false;
        }
        
        return true;
    }
    
    public boolean isStart(int startX, int startY) {
        return this.x == startX && this.y == startY;
    }
    
    public Position getRight() {
        return new Position(x + 1, y, c + 1);
    }
    
    public Position getBottom() {
        return new Position(x, y + 1, c + 1);
    }
    
    public Position getLeft() {
        return new Position(x - 1, y, c + 1);
    }
    
    public boolean isPersonHere(String[] places) {
        return places[this.y]
            .charAt(this.x) == 'P';
    }
    
    public boolean isPatition(String[] places) {
        return places[y].charAt(x) == 'X';
    }
    
}
