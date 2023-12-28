class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 3) {
            sb.append(n % 3);
            n /= 3;
        }
        sb.append(n);
        for (int i = 0; i < sb.length() - 1; i++) {
            char now = sb.charAt(i);
            if (now <= '0') {
                sb.setCharAt(i + 1, (char) (sb.charAt(i + 1) - 1));
                now += 3;
                sb.setCharAt(i, now);
            }
            if (now == '3')
                sb.setCharAt(i, '4');
        }
        if (sb.charAt(sb.length() - 1) == '3')
            sb.setCharAt(sb.length() - 1, '4');
        if (sb.charAt(sb.length() - 1) <= '0')
            sb.deleteCharAt(sb.length() - 1);
        return sb.reverse()
                .toString();
    }
}