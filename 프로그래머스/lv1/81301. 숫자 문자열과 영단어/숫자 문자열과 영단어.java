class Solution {
    public int solution(String s) {
        if(s.length() >= 3){
          String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
            for(int i = 0; i <= 9; i++){
                s = s.replace(num[i], String.valueOf(i));
            }
        }
        int answer = Integer.valueOf(s);
        return answer;
    }
}