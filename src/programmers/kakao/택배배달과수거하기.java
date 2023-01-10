package programmers.kakao;

    public class 택배배달과수거하기 {
        public static long solution (int cap, int n, int[] deliveries, int[] pickups) {
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
            System.out.println(answer);
            return answer * 2;
        }





    public static void main(String[] args) {
//        solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0});
        solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0});
//        solution(3, 7, new int[]{0, 0, 0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0, 0, 0});
    }
}



// 스택 방식 ( 미완 )
//import java.util.ArrayList;
//        import java.util.Stack;

//public class 택배배달과수거하기 {
//    public static long solution (int cap, int n, int[] deliveries, int[] pickups) {
//        long answer;
//        // 초기설정
//        Stack<Integer> d = new Stack<>();
//        Stack<Integer> p = new Stack<>();
//
//        // 스택에 넣기
//        for(int i : deliveries){
//            d.add(i);
//        }
//        for(int i : deliveries){
//            p.add(i);
//        }
//        while(d.empty() && d.peek() == 0){
//            d.pop();
//        }
//        while(p.empty() && p.peek() == 0){
//            p.pop();
//        }
//
//        answer = (d.size() > p.size() ? d.size() : p.size()) * 2;
//
//        while()
//
//        System.out.println();
//        return answer;
//    }

