class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++){
            int a = s.substring(0, i).lastIndexOf(s.charAt(i));
            if(a != -1)
                a = i - a;
            answer[i] = a;
        }
        return answer;
    }
}