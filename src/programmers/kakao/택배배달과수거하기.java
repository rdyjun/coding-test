package programmers.kakao;

public class 택배배달과수거하기 {
    public static long solution (int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int a = 0;
        int b = 0;
        int aa = 0;
        int bb = 0;

        int on = 0;   // 트럭에 실을 수 있는 최대 물건 수
        int out = 0;  // 트럭에서 내릴 최대 물건 수
        boolean bl = false;
        int k = n;  //끝 위치 저장하는 곳

        for(int i = n - 1; i >= 0; i--){
            if (out + deliveries[i] == cap || i == 0) {
                if(!bl){
                    a += k + 1;
                    bl = false;
                    if(i == 0){
                        break;
                    }
                } else {
                    i = k + 1;
                    out = -aa - deliveries[i];
                    aa = 0;
                    a += k + 1;
                    bl = false;
                }
            } else if(out + deliveries[i] < cap){
                if (bl){
                    aa += deliveries[i];
                }
                out += deliveries[i];
            } else {
                if (!bl){
                    k = i;
                    bl = true;
                }
            }
        }
        k = n;
        bl = false;

        for(int i = n - 1; i >= 0; i--){
            if (on + pickups[i] == cap || i == 0) {
                if(!bl){
                    b += k + 1;
                    bl = false;
                    if(i == 0){
                        break;
                    }
                } else {
                    i = k + 1;
                    on = -bb - pickups[i];
                    bb = 0;
                    b += k + 1;
                    bl = false;
                }
            } else if(on + pickups[i] < cap){
                if (bl){
                    bb += pickups[i];
                }
                on += pickups[i];
            } else {
                if (!bl){
                    k = i;
                    bl = true;
                }
            }
        }
        answer = (a > b ? a : b) * 2;

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0});
    }
}
