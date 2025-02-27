class Solution {
    public int solution(int n, int w, int num) {        
        int row = getTotalRow(n, w);                    // 최대 높이
        int filledRow = n / w;
        
        int boxRow = (num - 1) / w + 1;                 // 상자의 행
        int boxColumn = getBoxColumn(boxRow, w, num);   // 상자의 열
        int result = filledRow - boxRow + 1;
        
        return result + findTopBox(row, n, w, filledRow, boxColumn);
    }
    
    private int findTopBox(int row, int n, int w, int filledRow, int boxColumn) {
        if (row == filledRow) {
            return 0;
        }
        
        boolean isTopOdd = row % 2 == 1;
        if (isTopOdd && n % w >= boxColumn) {           // 홀수면서 박스가 있는지
            return 1;
        }
        
        if (!isTopOdd && w - n % w < boxColumn) {      // 짝수면서 박스가 위치에 있는지
            return 1;
        }
        
        return 0;
    }
    
    private int getBoxColumn(int boxRow, int w, int num) {
        if (boxRow % 2 == 0) {
            return boxRow * w - num + 1;
        }
        
        return (num - 1) % w + 1;
    }
    
    private int getTotalRow(int n, int w) {
        int row = n / w;
        if (n % w > 0) {
            row++;
        }
        
        return row;
    }
}