class Solution {
    public String[] solution(String[] s) {
        for (int i = 0; i < s.length; i++) {
            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            
            for (int k = 0; k < s[i].length(); k++) {
                sb.append(s[i].charAt(k));
                int sblen = sb.length();
                if (sblen >= 3
                    && sb.charAt(sblen - 1) == '0'
                    && sb.charAt(sblen - 2) == '1'
                    && sb.charAt(sblen - 3) == '1') {
                    
                    sb.setLength(sblen - 3);
                    cnt++;
                }
            }
            
            // 0이 있으면
            int zeroIndex = sb.lastIndexOf("0");
            if (zeroIndex != -1) {
                sb.insert(zeroIndex + 1, "110".repeat(cnt));
            } else {
                // 0이 없으면
                sb.insert(0, "110".repeat(cnt));
            }
            
            s[i] = sb.toString();
        }
        
        return s;
    }
}
