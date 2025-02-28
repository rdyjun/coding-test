import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Stack;

class Solution {
    private final static Integer SECRET_CODE_LENGTH = 5;
    private int a = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        
        List<Set<Integer>> qSet = initQSet(q);
        Stack<NumberSet> stack = new Stack<>();
        stack.add(new NumberSet());
        
        while (!stack.isEmpty()) {
            NumberSet numberSet = stack.pop();
            if (numberSet.size() == SECRET_CODE_LENGTH) {
                answer += validateSecretCode(numberSet, qSet, ans);
                continue;
            }
            
            int startNumber = numberSet.getBigNumber() + 1;
            for (int i = startNumber; i <= n; i++) {
                if (numberSet.has(i)) {
                    continue;
                }
                
                NumberSet cloneSet = numberSet.clone();
                cloneSet.add(i);
                stack.add(cloneSet);
            }
        }
        
        return answer;
    }
    
    private int validateSecretCode(NumberSet numberSet, List<Set<Integer>> qSet, int[] ans) {
        for (int i = 0; i < qSet.size(); i++) {
            Set<Integer> value = qSet.get(i);
            int count = numberSet.getUnionCount(value);
            if (ans[i] != count) {
                return 0;
            }
        }
        
        return 1;
    }
    
    private List<Set<Integer>> initQSet(int[][] q) {
        List<Set<Integer>> qSet = new ArrayList<>();
        
        Arrays.stream(q)
                .map(this::arrayToSet)
                .forEach(qSet::add);
        
        return qSet;
    }
    
    private Set<Integer> arrayToSet(int[] qArray) {
        Set<Integer> numberSet = new HashSet<>();
        Arrays.stream(qArray)
                .forEach(numberSet::add);
        
        return numberSet;
    }
    
    static class NumberSet {
        private Set<Integer> set;
        private Integer bigNumber = 0;
        
        public NumberSet() {
            this.set = new HashSet<>();
        }
        
        public int size() {
            return set.size();
        }
        
        public void add(int value) {
            this.set
                    .add(value);
            
            bigNumber = Math.max(bigNumber, value);
        }
        
        public int getBigNumber() {
            return this.bigNumber;
        }
        
        public int getUnionCount(Set<Integer> compare) {
            Set<Integer> intersection = new HashSet<>(compare);
            intersection.retainAll(
                this.set);
            
            return intersection.size();
        }
        
        public boolean has(int value) {
            return this.set
                    .contains(value);
        }
        
        public NumberSet clone() {
            NumberSet cloneSet = new NumberSet();
            this.set
                    .stream()
                    .forEach(cloneSet::add);
            return cloneSet;
        }
    }
}