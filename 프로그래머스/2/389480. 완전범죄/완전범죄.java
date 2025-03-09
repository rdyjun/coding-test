import java.util.Set;
import java.util.HashSet;
import java.util.Stack;
import java.util.Objects;

class Solution {
    
    public int solution(int[][] info, int n, int m) {
        int maxB = initMaxB(info);
        if (m > maxB) { // B로만 훔칠 수 있다면 종료
            return 0;
        }
        
        int answer = Integer.MAX_VALUE;
        
        Set<String> visited = new HashSet<>();
        Stack<A> stack = initStack(maxB, info);
        while (!stack.isEmpty()) {
            A a = stack.pop();
            
            if (a.isValid(n, m)) {
                answer = Math.min(answer, a.a);
                
                continue;
            }
            
            String key = a.getKey();
            
            if (visited.contains(key)
                    || a.a >= answer
                    || a.index == info.length - 1
                    || !a.isValidA(n)) {
                continue;
            }
            
            visited.add(key);
            
            for (int i = a.index + 1; i < info.length; i++) {
                A copyA = new A(a);
                copyA.update(info[i][0], info[i][1], i);
                stack.add(copyA);
            }
        }
        
        if (answer == Integer.MAX_VALUE) {
            return -1;
        }
        
        return answer;
    }
    
    private Stack<A> initStack(int maxB, int[][] info) {
        Stack<A> stack = new Stack<>();
        
        for (int i = 0; i < info.length; i++) {
            A a = new A(info[i][0], info[i][1], i, maxB);
            stack.add(a);
        }
        
        return stack;
    }
    
    private int initMaxB(int[][] info) {
        int maxB = 0;
        for (int i = 0; i < info.length; i++) {
            maxB += info[i][1];
        }
        
        return maxB;
    }
    
    static class A {
        private int a;  // 시작부터 0
        private int b;  // 시작부터 MAX
        private int index;
        
        public A() {}
        
        public A(int a, int b, int index, int maxB) {
            this.b = maxB;
            update(a, b, index);
            this.index = index;
        }
        
        public A(A a) {
            this.a = a.a;
            this.b = a.b;
            this.index = a.index;
        }
        
        public boolean isValid(int n, int m) {
            if (this.a >= n || this.b >= m) {
                return false;
            }
            
            return true;
        }
        
        public void update(int a, int b, int index) {
            this.a += a;
            this.b -= b;
            this.index = index;
        }
        
        public boolean isValidA(int n) {
            if (this.a >= n) {
                return false;
            }
            
            return true;
        }
        
        public boolean equals(Object object) {
            if (!(object instanceof A)) {
                return false;
            }
            
            A compare = (A) object;
            
            if (this.a != compare.a
                    || this.b != compare.b
                    || this.index != compare.index) {
                return false;
            }
            
            return true;
        }
        
        public int hashcode() {
            return Objects.hashCode(this.a + " :: " + this.b + " :: " + this.index);
        }
        
        public String getKey() {
            return this.a + "-" + this.b + "-" + this.index;
        }
    }
}