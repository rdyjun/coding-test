import java.util.*;

class Solution {
    HashSet<Integer> s = new HashSet<>();
    
    public void sol (ArrayList<Integer> arr, int n, int m, int x) {
        int l = arr.size();
        s.add(n);
        if (m % l == (x + l - 1) % l)
            return;
        
        sol(arr, n + arr.get(m % l), m + 1, x);
    }
    public int solution(int[] elements) {
        int len = elements.length;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i : elements)
            arr.add(i);
        
        for (int i = 0; i < len; i++) {
            sol(arr, elements[i], i + 1, i);
        }
        return s.size() + 1;
    }
}