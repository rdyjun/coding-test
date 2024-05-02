import java.util.Set;
import java.util.HashSet;
import java.util.Objects;
import java.util.Arrays;

class Solution {
    public String[] solution(int[][] lines) {
        int linesLength = lines.length;
        Line[] lineList = createLineList(linesLength, lines);
        
        Set<Position> positionList = new HashSet<>();
        
        for (int i = 0; i < linesLength; i++) {
            Line line1 = lineList[i];
            
            for (int k = i + 1; k < linesLength; k++) {
                Line line2 = lineList[k];
                
                Position position = line1.findCrossingPoint(line2);
                if (position != null) {
                    positionList.add(position);
                }
            }
        }
        
        Integer maxX = Integer.MIN_VALUE;
        Integer minX = Integer.MAX_VALUE;
        Integer minY = Integer.MAX_VALUE;
        Integer maxY = Integer.MIN_VALUE;
        
        for (Position position : positionList) {
            int x = position.getX();
            int y = position.getY();
            
            maxX = Math.max(x, maxX);
            maxY = Math.max(y, maxY);
            minX = Math.min(x, minX);
            minY = Math.min(y, minY);
        }
        
        char[][] result = initialize(maxX, minX, minY, maxY);
        int row = result.length;
        
        for (Position position : positionList) {
            int x = position.getX();
            int y = position.getY();
            
            result[row - 1 - (y - minY)][x - minX] = '*';
        }
        
        String[] answer = new String[result.length];
        for (int i = 0; i < result.length; i++) {
            answer[i] = new String(result[i]);
        }
        
        return answer;
    }
    
    private char[][] initialize(int maxX, int minX, int minY, int maxY) {
        char[][] array = new char[maxY - minY + 1][maxX - minX + 1];
        for (int i = 0; i < array.length; i++) {
            Arrays.fill(array[i], '.');
        }
        return array;
    }
    
    private Line[] createLineList(int linesLength, int[][] lines) {
        Line[] lineList = new Line[linesLength];
        
        for (int i = 0; i < linesLength; i++) {
            int x = lines[i][0];
            int y = lines[i][1];
            int c = lines[i][2];
            
            int gcd = Operator.gcd(x, y);
            gcd = Operator.gcd(gcd, c);
            lineList[i] = new Line(x / gcd, y / gcd, c / gcd);
        }
        
        return lineList;
    }
    
}

class Operator {
    
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        
        while (b > 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        
        return Math.abs(a);
    }
    
}

class Line {
    
    private int a;
    
    private int b;
    
    private int c;
    
    public Line(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public Position findCrossingPoint(Line line) {
        long divide = (long) this.a * line.b - (long) this.b * line.a;
        if (divide == 0) {
            return null;
        }
        
        long x = (long) this.b * line.c - (long) this.c * line.b;
        long y = (long) this.c * line.a - (long) this.a * line.c;
        
        if ((x % divide != 0) ||
           (y % divide != 0)) {
            return null;
        }
        
        x = x / divide;
        y = y / divide;
        
        return new Position((int) x, (int) y);
    }
    
}

class Position {
    
    private int x;
    
    private int y;
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        
        if (!(o instanceof Position)) {
            return false;
        }
        
        Position p = (Position) o;
        if (this.x != p.x ||
           this.y != p.y) {
            return false;
        }
        
        return true;
    }
    
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
}
