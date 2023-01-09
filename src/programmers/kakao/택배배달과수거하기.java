package programmers.kakao;

import java.util.ArrayList;

public class 택배배달과수거하기 {
    public static long solution (int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        // 초기설정
        int d = 0;
        int p = 0;
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
            if(pickups[i] != 0) {
                p = i;
                break;
            }
        }
        answer += (d > p ? d : p) + 1;


        while(true){
            for(int a = d; a >= 0; a--){
                if(a == 0 && !bl){
                    if(dPoint + deliveries[a] > cap)
                        d = 0;
                    else
                        d = -1;
                } else if(dPoint + deliveries[a] == cap){  // 배달 포인트가 같을 때
                    if(bl && deliveries[a] != 0){
                        deliveries[a] = 0;
                        break;
                    }
                    dPoint += deliveries[a];
                } else if(dPoint + deliveries[a] < cap){  // 배달 포인트가 남을 때
                    if(bl && deliveries[a] != 0){
                        deliveries[a] = 0;
                    }
                    dPoint += deliveries[a];
                } else if(dPoint + deliveries[a] > cap){
                    if(!bl){
                        bl = true;
                        d = a;
                    }
                    if(dPoint == cap){
                        break;
                    }
                }
            }
            bl = false;

            for(int b = p; b >= 0; b--){
                if(b == 0 && !bl){
                    if(pPoint + pickups[b] > cap)
                        p = 0;
                    else
                        p = -1;
                } else if(pPoint + pickups[b] == cap){  // 배달 포인트가 같을 때
                    if(bl && pickups[b] != 0){
                        pickups[b] = 0;
                        break;
                    }
                    pPoint += pickups[b];
                } else if(pPoint + pickups[b] < cap){
                    if(bl && pickups[b] != 0){
                        pickups[b] = 0;
                    }
                    pPoint += pickups[b];
                } else if(pPoint + pickups[b] > cap){
                    if(!bl){
                        bl = true;
                        p = b;
                    }
                    if(pPoint == cap){
                        break;
                    }
                }
            }

            if(d + p == -2){
                break;
            }
            answer += (d > p ? d : p) + 1;


            //초기화
            dPoint = 0;
            pPoint = 0;
            bl = false;
        }
        System.out.println(answer * 2);
        return answer * 2;
    }

    public static void main(String[] args) {
        solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0});
//        solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0});
//        solution(3, 7, new int[]{0, 0, 0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0, 0, 0});
    }
}


// 5 3
// 4 2

// 7 5 3
// 6 5 3 2
// 7 5 3 2


//    long answer = 0;
//    int a = 0;
//    int b = 0;
//    int aa = 0;
//    int bb = 0;
//
//    int on = 0;   // 트럭에 실을 수 있는 최대 물건 수
//    int out = 0;  // 트럭에서 내릴 최대 물건 수
//    boolean bl = false;
//    int k = n - 1;  //끝 위치 저장하는 곳
//
//        for(int i = n - 1; i >= 0; i--){
//                if(i == 0){
//                if(bl){   // 방문할 집이 남아 있을 때
//                out = -aa - deliveries[i];
//                bl = false;
//                i = k + 1;
//                aa = 0;
//                } else {  // 모두 방문했을 때
//                if(out != 0 && !bl) {  //방문한 기록이 있을 때
//                a += k + 1;
//                }
//                break;
//                }
//                } else if(out + deliveries[i] < cap){
//        if (bl){  //방문할 집이 남아있을 때
//        aa += deliveries[i];
//        }
//        out += deliveries[i];
//        } else if(out + deliveries[i] == cap) {
//        if (deliveries[i - 1] != 0){
//        if(bl){
//        out = -aa - deliveries[i];
//        } else {
//        a += k + 1;
//        k = i - 1;
//        out = -aa;
//        }
//        aa = 0;
//        bl = false;
//        } else {
//        out += deliveries[i];
//        }
//        } else {
//        if (!bl){
//        a += k + 1;
//        k = i;
//        bl = true;
//        }
//        }
//        }
//        k = n - 1;
//        bl = false;
//
//        for(int i = n - 1; i >= 0; i--){
//        if(i == 0){
//        if(bl){   // 방문할 집이 남아 있을 때
//        on = -bb - pickups[i];
//        bl = false;
//        i = k + 1;
//        bb = 0;
//        } else {  // 모두 방문했을 때
//        if(on != 0 && !bl) {  //방문한 기록이 있을 때
//        b += k + 1;
//        }
//        break;
//        }
//        } else if(on + pickups[i] < cap){
//        if (bl){  //방문할 집이 남아있을 때
//        bb += pickups[i];
//        }
//        on += pickups[i];
//        } else if(on + pickups[i] == cap) {
//        if (pickups[i - 1] != 0){
//        if(bl){
//        on = -bb - pickups[i];
//        } else {
//        b += k + 1;
//        k = i - 1;
//        on = -bb;
//        }
//        bb = 0;
//        bl = false;
//        } else {
//        on += pickups[i];
//        }
//        } else {
//        if (!bl){
//        b += k + 1;
//        k = i;
//        bl = true;
//        }
//        }
//        }
//        answer = (a > b ? a : b) * 2;
//        return answer;