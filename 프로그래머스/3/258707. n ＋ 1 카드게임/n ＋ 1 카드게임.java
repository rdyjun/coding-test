import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

class Solution {
    
    public int solution(int coin, int[] cards) {
        int answer = 1;
        int n = cards.length;
        
        // 처음 손에 가지고 있는 카드 저장
        Set<Integer> hand = new HashSet<>();
        int count = 0;
        for(int i = 0; i < n / 3; i++) {
            hand.add(cards[i]);
            if(hand.contains(n + 1 - cards[i]))
                count++;
        }
        
        Set<Integer> s = new HashSet<>(); // 코인으로 사야하는 카드들 저장공간  
        int twoCoinCount = 0; // 코인 두 개로 사야하는 경우
        int i;
        
        // 라운드 시작
        for(i = n / 3; i < n - 1 && count >= -1; i += 2, answer++) {
            if(count == -1) {
                if(twoCoinCount <= 0 || coin < 2) { // 코인 두 개로도 라운드 진행이 불가능한 경우 종료
                    answer--;
                    break;
                }
                
                twoCoinCount--; //코인 두 개로 라운드 진행이 가능한 경우
                coin -= 2; // 코인 차감
                count++;
            }
            
            int a = cards[i];
            int b = cards[i + 1];
            
            s.add(a);
            if(s.contains(n + 1 - a))
                twoCoinCount++;

            if(coin > 0 && hand.contains(n + 1 - a)) {
                coin--;
                count++;
            }
            
            s.add(b);
            if(s.contains(n + 1 - b))
                twoCoinCount++;

            if(coin > 0 && hand.contains(n + 1 - b)) {
                coin--;
                count++;
            }
            
            count--;
        }
        
        if(count == -1 && i == n)
            answer--;
        
        return answer;
    }
}
