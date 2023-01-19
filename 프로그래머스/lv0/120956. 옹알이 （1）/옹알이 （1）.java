class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] speech = {"aya", "ye", "woo", "ma"};
        int a;
        
        for(int i = 0; i < babbling.length; i++){
            a = babbling[i].length();
            for(int k = 0; k < 4; k++){
                if(a > 0){
                    if(babbling[i].contains(speech[k])){
                        a -= speech[k].length();
                    }
                }
            }
            if(a == 0)
                answer++;
        }
        return answer;
    }
}