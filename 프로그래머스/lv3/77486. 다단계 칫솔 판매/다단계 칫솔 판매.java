import java.util.*;

class Solution {
    private Map<String, Integer> index;
    private String[] referral;
    
    private void putMoneyToSuper (int sellerIndex, int money, double[] answer) {
        String superName = referral[sellerIndex];
        
        if (money / 10 < 1) {
            answer[sellerIndex] += money;
            return;
        }
        double m = money / 10;
        int mny = m % 1 > 0 ? (int)m + 1 : (int)m;
        
        answer[sellerIndex] += money - mny;
        
        if (superName.equals("-"))
            return;
        
        int superIndex = index.get(superName);
        
        putMoneyToSuper(superIndex, mny, answer);
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        this.referral = referral;
        int len = seller.length;
        int p = enroll.length;
        double[] answer = new double[p];
        index = new HashMap<>();
        
        for (int i = 0; i < p; i++)
            index.put(enroll[i], i);
        
        for (int i = 0; i < len; i++) {
            String sellerName = seller[i];
            int sellerIndex = index.get(sellerName);
            
            putMoneyToSuper (sellerIndex, amount[i] * 100, answer);
        }
        int[] asw = Arrays.stream(answer)
            .mapToInt(v -> (int)v)
            .toArray();
        return asw;
    }
}