import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int friendsLen = friends.length;
        int giftsLen = gifts.length;
        
        Map<String, Integer> totalGift = new HashMap<>();
        Map<String, Integer> giftLog = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();
        
        for(String giftName : gifts) {
            String[] giftNames = giftName.split(" ");
            
            int giftCount = totalGift.getOrDefault(giftNames[0], 0);
            totalGift.put(giftNames[0], giftCount + 1);
            
            giftCount = totalGift.getOrDefault(giftNames[1], 0);
            totalGift.put(giftNames[1], giftCount - 1);
            
            int giftSpecificCount = giftLog.getOrDefault(giftName, 0);
            giftLog.put(giftName, giftSpecificCount + 1);
        }
        
        for(int i = 0; i < friendsLen; i++) {
            String a = friends[i];
            for(int k = i + 1; k < friendsLen; k++) {
                String b = friends[k];
                
                int AToB = giftLog.getOrDefault(a + " " + b, 0);
                int BToA = giftLog.getOrDefault(b + " " + a, 0);
                
                if(AToB == BToA) {
                    int aGift = totalGift.getOrDefault(a, 0);
                    int bGift = totalGift.getOrDefault(b, 0);
                    
                    if(aGift > bGift)
                        result.put(a, result.getOrDefault(a, 0) + 1);
                    
                    if(aGift < bGift)
                        result.put(b, result.getOrDefault(b, 0) + 1);
                        
                    continue;
                }
                
                if(AToB > BToA) {
                    result.put(a, result.getOrDefault(a, 0) + 1);
                    continue;
                }
                
                result.put(b, result.getOrDefault(b, 0) + 1);
            }
        }
        
        int answer = 0;   
        for(int value : result.values())
            if(answer < value)
                answer = value;
        
        return answer;
    }
}