class Solution {
    public int solution(String myString, String pat) {
        int patLen = pat.length();
        int answer = 0;
        for (int i = 0; i < myString.length() - patLen + 1; i++) {
            String compareString = myString.substring(i, i + patLen);
            
            if (compareString.equals(pat))
                answer++;
        }
        return answer;
    }
}