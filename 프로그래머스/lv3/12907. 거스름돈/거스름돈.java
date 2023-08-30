// 해설을 통한 풀이
class Solution {
    public int solution(int n, int[] money) {
        int[] coin = new int[n];
        
        for (int m : money) {
            coin[m - 1] += 1;
            for (int k = m + 1; k <= n; k++)
                coin[k - 1] += coin[k - m - 1];
        }
        
        return coin[n - 1] % 1000000007;
    }
}