class Solution {
    
    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length;
        int n = lock.length;
        
        for (int r = 1 - m; r < n; r++) {
            for (int c = 1 - m; c < n; c++) {
                loop:
                for (int i = 0; i < 4; i++) { // 4 방향
                    int[][] tmp = deepCopy(n, lock);
                    
                    for (int rr = 0; rr < m; rr++) {
                        for (int cc = 0; cc < m; cc++) {
                            if (r + rr >= n ||
                                c + cc >= n ||
                               r + rr < 0 ||
                               c + cc < 0) {
                                
                                continue;
                            }
                            
                            tmp[r + rr][c + cc] += key[rr][cc];
                        }
                    }
                    
                    if (validate(tmp)) {
                        return true;
                    }
                    
                    key = rotate(key);
                }
            }
        }
        
        return false;
    }
    
    private int[][] deepCopy(int n, int[][] lock) {
        int[][] tmp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            tmp[i] = lock[i].clone();
        }
        
        return tmp;
    }
    
    private int[][] rotate(int[][] array) {
        int n = array.length;
        int[][] tmp = new int[n][n];
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                tmp[r][c] = array[c][n - r - 1];
            }
        }
        
        return tmp;
    }
    
    private boolean validate(int[][] array) {
        for (int[] r : array) {
            for (int c : r) {
                if (c != 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
}
