import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

class Solution {
    
    private Integer n;
    private List<List<Integer>> array;
    private Set<Direction> visited;
    private Set<Integer> nextVisit;
    
    public int solution(int n, int[][] lighthouse) {
        this.n = n;
        this.array = new ArrayList<>();
        this.visited = new HashSet<>();
        this.nextVisit = new HashSet<>();
        
        extendsArray(); // array 확장
        initializeNode(lighthouse); // 노드 추가
        findLeafNode();
        
        return search();
    }
    
    private void initializeNode(int[][] lighthouse) {
        for (int[] eachLighthouse : lighthouse) {
            int a = eachLighthouse[0];
            int b = eachLighthouse[1];
            
            this.array.get(a).add(b);
            this.array.get(b).add(a);
        }
    }
    
    private void extendsArray() {
        int n = this.n;
        
        while (n-- >= 0) {
            this.array.add(new ArrayList<>());
        }
    }
    
    private void findLeafNode() {
        for (int lighthouseNumber = 1; lighthouseNumber <= n; lighthouseNumber++) {
            int connectedNodeCount = this.array
                .get(lighthouseNumber)
                .size();
            
            if (connectedNodeCount == 1) {
                this.nextVisit.add(lighthouseNumber);
            }
        }
    }
    
    private int search() {
        if (isAnswer()) {
            return 0;
        }
        
        int next = getNext();
        List<Integer> childList = this.array.get(next);

        int parent = childList.get(0); // 부모 노드
        nextVisit.remove(parent);
        removeParentFromChild(parent); // 각 자식 노드에서 부모 노드와의 관계 제거

        return 1 + search();
    }
    
    private int getNext() {
        for (int next : this.nextVisit) {
            return next;
        }
        
        return -1;
    }
    
    private boolean isAnswer() {
        return this.visited.size() == this.n - 1;
    }
    
    private void removeParentFromChild(int parent) {        
        List<Integer> childList = this.array.get(parent);
        
        for (int child : childList) {
            Direction d = new Direction(parent, child);
            this.visited.add(d);
            
            List<Integer> childsChildList = this.array.get(child); // 자식의 자식 노드들
            
            if (childsChildList.size() == 1) { // 리프노드라면
                this.nextVisit.remove((Integer) child); // 대기열에서 제거
                continue;
            }
            
            childsChildList.remove((Integer) parent); // 리프노드가 아니라면 부모와의 연결 제거
            if (childsChildList.size() == 1) { // 연결 제거를 통해 리프 노드가 됐다면 대기열에 추가
                this.nextVisit.add(child);
            }
        }
    }
    
}

class Direction {
    
    private Integer a;
    
    private Integer b;
    
    public Direction(int a, int b) {
        this.a = (Integer) a;
        this.b = (Integer) b;
    }
    
    public boolean equals(Object o) {
        if (o == null ||
           o.getClass() != getClass()) {
            return false;
        }
        
        Direction d = (Direction) o;
        
        return (this.a == d.a && this.b == d.b) ||
           (this.a == d.b && this.b == d.a);
    }
    
    public int hashCode(Object o) {
        return Objects.hash(Math.max(a, b), Math.min(a, b));
    }
    
}