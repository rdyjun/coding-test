class Solution {
    public int[] solution(int[] numlist, int n) {
        int numlen = numlist.length;
        int[] answer = new int[numlen]; 
        int m = 0;
        int c, o;
        
        for (int i = 0; i < numlen; i++) {
            c = numlist[i] > n ? numlist[i] - n : n - numlist[i];
            for(int k = 0; k < numlen; k++) {
                if(i == k)
                    continue;
                
                o = numlist[k] > n ? numlist[k] - n : n - numlist[k];
                
                if (c == o && numlist[i] < numlist[k]) {
                    m++;
                } else if (c > o)
                    m++;
            }
            answer[m] = numlist[i];
            m = 0;
        }
        return answer;
    }
}