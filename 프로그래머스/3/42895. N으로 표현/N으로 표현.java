import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;

class Solution {
    
    private static final Integer LIMIT = 8;
    
    private int N;
    
    private Set<Integer> visited;
    
    private List<Set<Integer>> dp;
    
    public int solution(int N, int number) {
        this.N = N;
        this.visited = new HashSet<>();
        this.dp = new ArrayList<>();
        
        int n = 1;
        
        for (int i = 0; i < LIMIT; i++, n++) {
            Set<Integer> arr = new HashSet<>();
            int num = nextNumber(n, N);
            arr.add(num);
            
            if (i > 0) {
                addValues(i, arr);
            }
            
            for (int value : arr) {
                visited.add(value);
            }
            
            dp.add(arr);
            
            if (arr.contains(number)) {
                break;
            }
        }
        
        if (this.visited.contains(number)) {
            return dp.size();
        }
        
        return -1;
    }
    
    private void addValues(int n, Set<Integer> arr) {
        for (int i = 0; i <= n / 2; i++) {
            Set<Integer> left = this.dp.get(i);
            Set<Integer> right = this.dp.get(n - i - 1);
            
            for (int l : left) {
                for (int r : right) {
                    addToArray(l + r, arr);
                    addToArray(l * r, arr);
                    addToArray(l - r, arr);
                    addToArray(r + l, arr);
                    
                    if (r != 0) {
                        addToArray(l / r, arr);
                    }
                    
                    if (l != 0) {
                        addToArray(r / l, arr);
                    }
                }
            }
        }
    }
    
    private void addToArray(int number, Collection<Integer> array) {
        if (!this.visited
            .contains(number)) {
            array.add(number);
        }
    }
    
    private int nextNumber(int n, int N) {
        int result = 0;
        int multiple = 1;
        
        for (int i = 0; i < n; i++) {
            result += multiple * N;
            multiple *= 10;
        }
        
        return result;
    }
    
}
