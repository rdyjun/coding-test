import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    public int solution(String[][] relation) {
        int answer = 0;
        int columnCount = relation[0].length;
        int rowCount = relation.length;
        
        String[][] array = new String[columnCount][rowCount];
        
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < columnCount; c++) {
                array[c][r] = relation[r][c];
            }
        }
        
        Set<Set<Integer>> visited = new HashSet<>();
        
        Queue<ValueData> q = new LinkedList<>();
        for (int i = 0; i < columnCount; i++) {
            q.add(new ValueData(i, array[i]));
        }
        
        while (!q.isEmpty()) {
            ValueData data = q.poll();
            
            if (!validateVisited(data.getIndexHistory(), visited)) {
                continue;
            }
            
            if (data.isUnique()) {
                answer++;
                visited.add(data.getIndexHistory());
                continue;
            }
            
            for (int i = data.getIndex() + 1; i < columnCount; i++) {
                q.add(data.getNext(i, array[i]));
            }
        }
        
        return answer;
    }
    
    private boolean validateVisited(Set<Integer> indexHistory, Set<Set<Integer>> visited) {        
        for (Set<Integer> visit : visited) {
            if (indexHistory.containsAll(visit)) {
                return false;
            }
        }
        
        return true;
    }
    
}

class ValueData {
    
    private int index;
    
    private Set<Integer> indexHistory;
    
    private String[] values;
    
    public ValueData(int index, String[] values) {
        this.index = index;
        this.values = values;
        this.indexHistory = new HashSet<>();
        this.indexHistory.add(index);
    }
    
    public ValueData(int index, Set<Integer> indexHistory, String[] values) {
        this.index = index;
        this.values = values;
        this.indexHistory = indexHistory;
        this.indexHistory.add(index);
    }
    
    public ValueData getNext(int index, String[] values) {
        String[] tmpValues = values.clone();
        
        for (int i = 0; i < this.values.length; i++) {
            tmpValues[i] = this.values[i] + "/" + tmpValues[i];
        }
        
        return new ValueData(index, new HashSet<>(this.indexHistory), tmpValues);
    }
    
    public Set<Integer> getIndexHistory() {
        return this.indexHistory;
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public boolean isUnique() {
        Set<String> array = new HashSet<>();
        
        for (String value : this.values) {
            array.add(value);
        }
        
        return array.size() == values.length;
    }
    
}


/*
[["a", "1", "aaa", "c", "ng"],
["a", "1", "bbb", "e", "g"],
["c", "1", "aaa", "d", "ng"],
["d", "2", "bbb", "d", "ng"]]

13
14
15
24
34
*/