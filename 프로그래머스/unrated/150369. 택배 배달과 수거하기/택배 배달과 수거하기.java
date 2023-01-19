class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
            // 초기설정
            int d = -1;
            int p = -1;
            boolean bl = false;
            int dPoint = 0, pPoint = 0;

            // 시작 인덱스 찾기
            for(int i = n - 1; i >= 0; i--){
                if(deliveries[i] != 0){
                    d = i;
                    break;
                }
            }
            for(int i = n - 1; i >= 0; i--){
                if(pickups[i] != 0){
                    p = i;
                    break;
                }
            }
            while(true){
                if(d + p == -2){
                    break;
                } else {
                    answer += ((d > p ? d : p) + 1) * 2;
                }

                for(int a = d; a >= 0; a--){
                    if(dPoint + deliveries[a] <= cap){  // 배달 포인트가 같거나 낮을 때
                        dPoint += deliveries[a];
                        if (a == 0)
                            d = -1;
                    } else
                        if(dPoint + deliveries[a] > cap){
                            d = a;
                            deliveries[a] -= cap - dPoint;
                            break;
                    }
                }

                bl = false;

                for(int b = p; b >= 0; b--){
                    if(pPoint + pickups[b] <= cap){  // 배달 포인트가 같거나 낮을 때
                        pPoint += pickups[b];
                        if (b == 0)
                            p = -1;
                    } else
                    if(pPoint + pickups[b] > cap){
                        p = b;
                        pickups[b] -= cap - pPoint;
                        break;
                    }
                }

                //초기화
                dPoint = 0;
                pPoint = 0;
                bl = false;
            }
            return answer;
    }
}