import java.util.*;

class Solution {
    private int four (int n) {
        return n * 1111;
    }
    
    private int getMin (int a, int b, int c, int d) {
        return Integer.min(Integer.min(Integer.min(a, b), c), d);
    }
    
    private int oneThree (int n, int a) {
        int num = 10 * n + a;
        return num * num;
    }
    
    private int twoTwo (int p, int q) {
        int n = p - q;
        n *= n < 0 ? -1 : 1;
        return (p + q) * n;
    }
    private int twoOneOne (int q, int r) {
        return q * r;
    }
    
    public int solution(int a, int b, int c, int d) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(a, b, c, d));
        arr.sort(Comparator.naturalOrder());
        Set<Integer> s = new HashSet<>(arr);
        
        if (s.size() == 1)
            return four(s.iterator().next());
        
        if (s.size() == 4)
            return getMin(a, b, c, d);
        
        int n = (int)arr.stream()
            .filter(v -> v == arr.get(0))
            .count();
        
        if (s.size() == 2) {
            if (n == 2) {
                Iterator<Integer> i = s.iterator();
                return twoTwo(i.next(), i.next());
            }

            if (n == 1)
                return oneThree(arr.get(3), arr.get(0));
            
            return oneThree(arr.get(0), arr.get(3));
        }
        if (n == 2)
            return twoOneOne(arr.get(2), arr.get(3));
        
        if (arr.get(1) == arr.get(2))
            return twoOneOne(arr.get(0), arr.get(3));
        
        return twoOneOne(arr.get(0), arr.get(1));
    }
}