package programmers.kakao;


public class 이모티콘할인행사 {
    static class Solution {
        // 1. 이모티콘 플러스 서비스 가입자를 최대한 늘리는 것.
        // 2. 이모티콘 판매액을 최대한 늘리는 것.
        int[][] caseCount;
        int c = 0;  // 상위
        int cc = 0;  // 하위
        public void dfs(int max, int min, int emtiSize) {
            for(int i = max; i >= min; i--){
                caseCount[c][cc] = i;
                if(emtiSize > 1) {
                    cc++;
                    --emtiSize;
                    dfs(max, min, emtiSize);
                } else {
                    cc++;
                }
            }
        }
        // 4,3 3 = 8
        // 4 4 4
        // 3 4 4
        // 4 3 4
        // 4 4 3
        // 3 3 4
        // 3 4 3
        // 4 3 3
        // 3 3 3

        // 4, 3
        // 4 4
        // 3 4
        // 4 3
        // 3 3

        public int[] solution(int[][] users, int[] emoticons) {
            int[] answer = new int[2]; // 0 = 가입자수, 1 = 판매액
            int max = users[0][0];
            int min = users[0][0];
            int arr;
            caseCount = new int[(int)Math.pow(max - min + 1, emoticons.length)][max - min + 1];

            //최대, 최소 할인율 구하기
            for(int i = 1; i < users.length; i++){
                if(users[i][0] > max){
                    max = users[i][0];
                }
                if(users[i][0] < min){
                    min = users[i][0];
                }
            }

            // 최대 할인율 앞자리만 빼오기
            if(max <= 9){
                if(max % 10 != 0)
                    max = max / 10 + 1;
                else
                    max /= 10;
            } else {
                max = 0;
            }

            // 가격이 작은 이모티콘 순으로 정렬
            for(int i = 0; i < emoticons.length - 1; i++){
                if(emoticons[i] > emoticons[i + 1]){
                    arr = emoticons[i];
                    emoticons[i] = emoticons[i + 1];
                    emoticons[i + 1] = arr;
                    i = 0;
                }
            }

            dfs(max, min, emoticons.length, emoticons, users);

            for(int i = max; i >= min; i--){
                for(int k = max; k >= min; k--){

                }
            }
            // 4 4 4 4
            // 3 4 4 4
            // 4 3 4 4
            // 4 4 3 4
            // 4 4 4 3

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000});
    }
}
