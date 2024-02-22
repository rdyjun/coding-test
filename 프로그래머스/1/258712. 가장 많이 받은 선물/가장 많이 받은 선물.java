import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int friendsLen = friends.length;
        int giftsLen = gifts.length;
        
        Map<String, Integer> friendsIndex = new HashMap<>();
        for(int i = 0; i < friendsLen; i++)
            friendsIndex.put(friends[i], i);
        
        int[] eachGift = new int[friendsLen];
        int[][] giftTo = new int[friendsLen][friendsLen];
        for(String gift : gifts) {
            String[] div = gift.split(" ");
            
            eachGift[friendsIndex.get(div[0])]++;
            eachGift[friendsIndex.get(div[1])]--;
            giftTo[friendsIndex.get(div[0])][friendsIndex.get(div[1])]++;
        }
        
        int[] answer = new int[friendsLen];
        
        for(int i = 0; i < friendsLen; i++) {
            for(int k = i + 1; k < friendsLen; k++) {
                if(giftTo[i][k] == giftTo[k][i]) {
                    if(eachGift[i] > eachGift[k])
                        answer[i]++;
                    
                    if(eachGift[i] < eachGift[k])
                        answer[k]++;
                    
                    continue;
                }
                
                if(giftTo[i][k] > giftTo[k][i]) {
                    answer[i]++;
                    continue;
                }
                
                answer[k]++;
            }
        }
        
        return Arrays.stream(answer).max().getAsInt();
    }
}