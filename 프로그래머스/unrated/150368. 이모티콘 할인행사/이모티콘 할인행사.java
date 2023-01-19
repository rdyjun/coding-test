class Solution {
    int[][] caseCount;
        int c = 0;  // 상위
        int cc = 0;  // 하위
        int emoticonSize;

        // max, min 한 자리수로 변환
        public int numDown(int n){
            if(n > 9){
                if(n % 10 != 0)
                    return n / 10 + 1;
                else
                    return n / 10;
            } else {
                if(n != 0){
                    return 1;
                } else {
                    return 0;
                }

            }
        }
        public void findCase(int max, int min) {
            for(int i = max; i >= min; i--){
                caseCount[c][cc] = i;
                if(emoticonSize > 1) {
                    cc++;
                    --emoticonSize;
                    findCase(max, min);
                } else {
                    try {
                        caseCount[c + 1] = caseCount[c].clone();
                    } catch (IndexOutOfBoundsException e) {
                        break;
                    }
                    c++;
                }
            }
            emoticonSize++;
            cc--;
        }
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2]; // 0 = 가입자수, 1 = 판매액
            int max = users[0][0];
            int min = users[0][0];
            int arr;


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
            max = numDown(max);
            min = numDown(min);


            emoticonSize = emoticons.length;  // 함수에 사용할 변수 초기값
            caseCount = new int[(int)Math.pow(max - min + 1, emoticons.length)][emoticons.length];  // 함수에 사용할 배열 (꼭 이 위치여야 함)
            int[] plus = new int[caseCount.length];
            int[] sales = new int[caseCount.length];

            // 가격이 작은 이모티콘 순으로 정렬
            for(int i = 0; i < emoticons.length - 1; i++){
                if(emoticons[i] > emoticons[i + 1]){
                    arr = emoticons[i];
                    emoticons[i] = emoticons[i + 1];
                    emoticons[i + 1] = arr;
                    i = 0;
                }
            }

            findCase(max, min);

//            //경우의 수 출력
//            for(int i = 0; i < caseCount.length; i++){
//                for(int k = 0; k < caseCount[0].length; k++){
//                    System.out.print(caseCount[i][k] + " ");
//                }
//                System.out.println("");
//            }

            for (int i = 0; i < caseCount.length; i++){  // 4424
                user:
                for(int k = 0; k < users.length; k++){   // k = 0
                    int a = 0;
                    emoticons:
                    for(int o = 0; o < emoticons.length; o++){  // o = 3
                        if(users[k][0] <= caseCount[i][o] * 10){  // users[0][0] = 40 <= 40
                            a += emoticons[o] * (10 - caseCount[i][o]) * 10 / 100;  // a = 520 + 600 + 1960
                            if(a >= users[k][1]){  // 520 + 600 >= 2900 false
                                plus[i] += 1;
                                continue user;
                            }
                        }
                        if (o == emoticons.length - 1) {
                            sales[i] += a;
                            break;
                        }
                    }
                }
            }
            answer[0] = plus[0];
            answer[1] = sales[0];
            for(int i = 1; i < plus.length; i++){
                if(answer[0] < plus[i]){
                    answer[0] = plus[i];
                    answer[1] = sales[i];
                } else if (answer[0] == plus[i] && answer[1] < sales[i]){
                    answer[1] = sales[i];
                }
            }
            return answer;
    }
}