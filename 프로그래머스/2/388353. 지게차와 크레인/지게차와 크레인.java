import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    private Integer height;
    private Integer weight;
    private Integer answer;
    private String[][] storage; // storage의 2차원 배열
    private boolean[][] state; // 바깥과 연결되어있는지
    private Queue<Integer[]> visitedQueue;
    
    public int solution(String[] storage, String[] requests) {
        this.visitedQueue = new LinkedList<>();
        this.height = storage.length;
        this.weight = storage[0].length();
        this.answer = height * weight;
        int requestCount = requests.length;
        
        initStorageArray(storage);
        initState();
        
        processRequest(requests);
        
        return this.answer;
    }
    
    private void processRequest(String[] requests) {
        Set<Character> visited = new HashSet<>();
        
        for (String request : requests) {               // 각 request 실행
            if (visited.contains(request.charAt(0))) {  // 크레인으로 뺀 적이 있으면 무시
                continue;
            }

            if (request.length() == 1) {                // 1 글자일 때 처리 A
                removeOutterContainer(request);
                updateState();
                continue;
            }
                
            visited.add(request.charAt(0));             // 2 글자일 때 처리 AA
            removeAllSpecificContainer(request);
            updateState();
        }
    }
    
    private void removeAllSpecificContainer(String request) {
        String name = request.substring(0, 1);
        
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < weight; column++) {
                boolean isSameToRequest = this.storage[row][column].equals(name);
                if (!isSameToRequest) {
                    continue;
                }
                
                this.answer--;
                this.storage[row][column] = ".";
            }
        }
    }
    
    private void updateState() {
        boolean flag = true;
        
        while (flag) {
            flag = false;
            
            for (int r = 0; r < this.height; r++) {
                for (int c = 0; c < this.weight; c++) {
                    if (this.state[r][c] || !isOutter(r, c)) {
                        continue;
                    }

                    this.state[r][c] = true;
                    flag = true;
                }
            }
        }
    }
    
    private boolean isOutter(int row, int column) {
        if (row > 0
                && this.storage[row - 1][column].equals(".")
                && this.state[row - 1][column]) {
            return true;
        }
        
        if (row < this.height - 1
                && this.storage[row + 1][column].equals(".")
                && this.state[row + 1][column]) {
            return true;
        }
        
        if (column > 0
                && this.storage[row][column - 1].equals(".")
                && this.state[row][column - 1]) {
            return true;
        }
        
        if (column < this.weight - 1
                && this.storage[row][column + 1].equals(".")
                && this.state[row][column + 1]) {
            return true;
        }
        
        return false;
    }
    
    private void removeOutterContainer(String request) {
        for (int row = 0; row < this.height; row++) {
            for (int column = 0; column < this.weight; column++) {
                boolean isSameToRequest = storage[row][column].equals(request);
                boolean isState = state[row][column];
                if (!isSameToRequest || !isState) {
                    continue;
                }
                
                this.answer--;
                this.storage[row][column] = ".";
            }
        }
    }
    
    private void initStorageArray(String[] storage) {
        this.storage = new String[this.height][this.weight];
        for (int row = 0; row < this.height; row++) {
            this.storage[row] = storage[row].split("");
        }
    }
    
    private void initState() {
        this.state = new boolean[this.height][this.weight];
        for (int row = 0; row < this.height; row++) {           // 좌, 우측 끝열 지게차 가능 처리
            this.state[row][0] = true;
            this.state[row][this.weight - 1] = true;
        }
        
        for (int column = 0; column < this.weight; column++) {  // 위, 아래 행 지게차 가능 처리
            this.state[0][column] = true;
            this.state[this.height - 1][column] = true;
        }
    }
    
}