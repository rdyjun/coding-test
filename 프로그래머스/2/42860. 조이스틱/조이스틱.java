import java.util.Set;
import java.util.HashSet;

class Solution {
    private String name;
    private int nameLength;
    private int moveCount;
    private Set<Integer> notAIndex;
    
    public int solution(String name) {
        this.name = name;
        this.nameLength = name.length();
        this.moveCount = this.nameLength - 1;
        this.notAIndex = new HashSet<>();
        
        int answer = 0;
        
        for (int i = 0; i < this.nameLength; i++) {
            int click = name.charAt(i) - 'A';
            answer += Math.min(click, 26 - click);
            
            if (click > 0) {
                this.notAIndex.add(i);
            }
        }
        
        right(0, 0, new HashSet<>());
        left(0, 0, new HashSet<>());
        
        return answer + this.moveCount;
    }
    
    private void right(int index, int result, Set<Integer> visited) {
        int now = getNowIndex(index);
        visited.add(now);
        
        if (validate(result, visited)) {
            return;
        }
        
        int next = getNowIndex(now + 1);
        if (getChar(next) == 'A' && 
           getChar(now) != 'A') {
            left(now - 1, result + 1, new HashSet<>(visited));
        }
        
        right(now + 1, result + 1, new HashSet<>(visited));
    }
    
    private void left(int index, int result, Set<Integer> visited) {
        int now = getNowIndex(index);
        visited.add(now);
        
        if (validate(result, visited)) {
            return;
        }
        
        int next = getNowIndex(index - 1);
        if (getChar(next) == 'A' && 
           getChar(now) != 'A') {
            right(now + 1, result + 1, new HashSet<>(visited));
        }
        
        left(now - 1, result + 1, new HashSet<>(visited));
    }
    
    private char getChar(int index) {
        return this.name.charAt(index);
    }
    
    private int getNowIndex(int index) {        
        if (index < 0) {
            return this.nameLength + index;
        }
        
        if (index >= this.nameLength) {
            return index % this.nameLength;
        }
        
        return index;
    }
    
    private boolean validate(int result, Set<Integer> visited) {
        if (result >= this.moveCount) {
            return true;
        }
        
        if (visited.containsAll(this.notAIndex)) {
            this.moveCount = result;
            return true;
        }
        
        return false;
    }
}