class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int clen = common.length;
        if(clen == 2){
            answer = common[1] - common[0];
        } else {
            if(common[1] - common[0] == common[2] - common[1]){
                answer = common[clen - 1] + common[1] - common[0];
            } else {
                if(common[1] / common[0] == common[2] / common[1]){
                answer = common[clen - 1] * common[1] / common[0];
                }
            }
        }
        return answer;
    }
}