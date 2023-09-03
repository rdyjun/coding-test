class Solution {
    public String solution(String n_str) {
        int n;
        for (n = 0; n < n_str.length(); n++)
            if (n_str.charAt(n) != '0')
                break;
        
        return n_str.substring(n, n_str.length());
    }
}