import java.util.Stack;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Solution {
    
    private static final Integer TYPE_INDEX = 0;
    
    private static final Integer NUMBER_INDEX = 2;
    
    private int n; // 행 높이
    
    private int k; // 실시간 위치
    
    private int[][] dp; // 전, 후 인덱스
    
    private Set<Integer> removedSet; // 제거된 인덱스
    
    private Stack<Integer> removed; // 제거된 인덱스 스택
    
    public String solution(int n, int k, String[] cmd) {
        this.n = n;
        this.k = k;
        this.removed = new Stack<>();
        this.removedSet = new HashSet<>();
        initializeDp();
        
        for (String command : cmd) {
            char mainCommand = command.charAt(TYPE_INDEX);
            int commandLength = command.length();
            
            if (commandLength == 1) {
                processing(mainCommand);
                continue;
            }
            
            int moveCount = Integer.parseInt(command.substring(NUMBER_INDEX));
            processing(mainCommand, moveCount);
        }
                
        return getAnswer();
    }
    
    private void initializeDp() {
        this.dp = new int[this.n][2];
        
        for (int i = 0; i < n; i++) {
            this.dp[i][0] = i - 1;
            this.dp[i][1] = i + 1;
        }
    }
    
    private void processing(char mainCommand) {
        if (mainCommand == 'C') {
            int prev = this.dp[this.k][0];
            int next = this.dp[this.k][1];
            
            if (prev >= 0) {
                this.dp[prev][1] = next;
            }
            
            if (next < this.n) {
                this.dp[next][0] = prev;
            }
            
            this.removedSet.add(this.k);
            this.removed.add(this.k);
            updateK();
            return;
        }
        
        if (mainCommand == 'Z') {
            int restore = this.removed.pop();
            int prev = this.dp[restore][0];
            int next = this.dp[restore][1];
            
            while (this.removedSet.contains(prev)) {
                prev = this.dp[prev][0];
            }
            
            while(this.removedSet.contains(next)) {
                next = this.dp[next][1];
            }
            
            if (prev >= 0) {
                this.dp[prev][1] = restore;
            }
            
            if (next < this.n) {
                this.dp[next][0] = restore;
            }
            
            this.removedSet.remove(restore);
            return;
        }
        
        throw new IllegalArgumentException("정의되지 않은 명령입니다. " + mainCommand);
    }
    
    private void processing(char mainCommand, int moveCount) {        
        if (mainCommand == 'D') {
            getMovedToDownIndex(moveCount);
            return;
        }

        if (mainCommand == 'U') {
            getMovedToUpIndex(moveCount);
            return;
        }
        
        throw new IllegalArgumentException("정의되지 않은 명령입니다. " + mainCommand);
    }
    
    private void getMovedToDownIndex(int count) {
        while (count > 0) {
            count--;
            this.k = this.dp[this.k][1];
        }
    }
    
    private void getMovedToUpIndex(int count) {
        while (count > 0) {
            count--;
            this.k = this.dp[this.k][0];
        }
    }
    
    private void updateK() {
        int next = dp[this.k][1];
        int prev = dp[this.k][0];
        
        if (next < this.n) {
            this.k = next;
            return;
        }
        
        if (prev >= 0) {
            this.k = prev;
        }
    }
    
    private String getAnswer() {
        StringBuilder stb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            if (this.removedSet.contains(i)) {
                stb.append("X");
                continue;
            }
            
            stb.append("O");
        }
        
        return stb.toString();
    }
    
}
