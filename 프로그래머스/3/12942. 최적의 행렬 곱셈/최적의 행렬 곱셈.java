import java.util.Arrays;

class Solution {
    
    private int matrixCount;
    private int[][] cost;
    private int[][] matrix_sizes;
    
    public int solution(int[][] matrix_sizes) {
        this.matrixCount = matrix_sizes.length;
        this.cost = initializeArray(matrixCount);
        this.matrix_sizes = matrix_sizes;
        
        findMinCost();
        
        return this.cost[0][this.matrixCount - 1];
    }
    
    private void findMinCost() {
        // 연산할 행렬의 수 0일 때는 1개를 의미
        for (int multipleMatrixCount = 0; multipleMatrixCount < this.matrixCount; multipleMatrixCount++) {
            // 연산을 시작할 행렬의 인덱스
            rotateMatrix(multipleMatrixCount);
        }
    }
    
    //** 각 행렬을 순회하여 최소 값 연산 */
    private void rotateMatrix(int multipleMatrixCount) {
        for (int index = 0; index < this.matrixCount; index++) {
            int start = index; // 시작 위치 
            int end = index + multipleMatrixCount; // 마지막 위치

            if (end >= matrixCount) {
                continue;
            }

            if (start == end) {
                this.cost[start][end] = 0;
                continue;
            }

            particionCost(start, end);
        }
    }
    
    /** 시작위치와 마지막 위치를 입력받아 배열을 둘로 나누어 연산해서 가장 적은 비용의 곱셈 수 찾기 */
    private void particionCost(int start, int end) {
        // 왼쪽과 오른쪽을 나누는 중간을 이동시키며 비교
        for (int middle = start; middle < end; middle++) {
            int left = this.cost[start][middle];
            int right = this.cost[middle + 1][end];
            // 왼쪽과 오른 쪽을 이을 때 필요한 곱셈 수
            int multiple = this.matrix_sizes[start][0] * this.matrix_sizes[middle][1] * this.matrix_sizes[end][1];

            // start부터 end까지 곱셈 수는 left + right + multiple
            this.cost[start][end] = Math.min(this.cost[start][end], left + right + multiple);
        }
    }
    
    private int[][] initializeArray(int matrixCount) {
        int[][] array = new int[matrixCount][matrixCount];
        for (int i = 0; i < matrixCount; i++) {
            Arrays.fill(array[i], Integer.MAX_VALUE);
        }
        
        return array;
    }
}
