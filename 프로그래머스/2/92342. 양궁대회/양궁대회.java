class Solution {
    private static final Integer MAX_POINT = 10;
    
    private int[] info;
    private int maxDiffPoint = -1;
    private int maxPoint = -1;
    private int[] answer;
    
    public int[] solution(int n, int[] info) {
        this.info = info;
        dfs(n, -1, new int[MAX_POINT + 1]);
        
        if (maxPoint == -1) {
            return new int[]{-1};
        }
        
        return this.answer;
    }
    
    private void dfs(int n, int index, int[] lion) {        
        if (index == MAX_POINT || n == 0) {
            compareAnswer(lion);
            
            return;
        }
        
        for (int i = index + 1; i < MAX_POINT; i++) {
            if (this.info[i] > n) {
                continue;
            }
            
            int[] newLion = lion.clone();
            newLion[i] = this.info[i];
            
            dfs(n - this.info[i], i, newLion.clone());
            
            if (this.info[i] == n) {
                continue;
            }
            
            int[] tmpLion = lion.clone();
            tmpLion[i] = this.info[i] + 1;
            
            dfs(n - this.info[i] - 1, i, tmpLion);
        }
        
        lion[MAX_POINT] = n;
        dfs(0, MAX_POINT, lion);
    }
    
    private void compareAnswer(int[] lion) {        
        int apeachePoint = 0;
        int lionPoint = 0;
                    
        for (int i = 0; i < MAX_POINT; i++) {
            int point = MAX_POINT - i;
            
            if (this.info[i] >= lion[i] &&
               this.info[i] > 0) {
                apeachePoint += point;
            }
            
            if (this.info[i] < lion[i]) {
                lionPoint += point;
            }
        }
        
        int totalDiff = lionPoint - apeachePoint;
        
        if (totalDiff <= 0 ||
           totalDiff < this.maxDiffPoint) {
            return;
        }
        
        if (totalDiff > this.maxDiffPoint) {
            this.maxDiffPoint = totalDiff;
            this.maxPoint = lionPoint;
            this.answer = lion;
            return;
        }
        
        if (lionPoint > this.maxPoint) {
            this.maxPoint = lionPoint;
            this.answer = lion;
        }
    }
}