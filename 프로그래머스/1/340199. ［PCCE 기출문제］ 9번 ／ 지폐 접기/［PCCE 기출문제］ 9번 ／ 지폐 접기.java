class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while (!isSmallThenWallet(wallet, bill)) {
            bill = folding(bill);
            answer++;
        }
        
        return answer;
    }
    
    public boolean isSmallThenWallet(int[] wallet, int[] bill) {
        return Math.max(bill[0], bill[1]) <= Math.max(wallet[0], wallet[1]) &&
            Math.min(bill[0], bill[1]) <= Math.min(wallet[0], wallet[1]);
    }
    
    public int[] folding(int[] bill) {
        if (bill[0] > bill[1]) {
            return new int[]{bill[0] / 2, bill[1]};
        }
        
        return new int[]{bill[0], bill[1] / 2};
    }
}