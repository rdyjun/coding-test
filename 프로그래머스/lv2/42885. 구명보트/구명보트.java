import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int len = people.length;
        int answer = 0;
        int k = 0;
        
        for (int i = len - 1; k <= i; i--) {
            answer++;
            if (people[k] + people[i] <= limit)
                k++;
        }
        return answer;
    }
}