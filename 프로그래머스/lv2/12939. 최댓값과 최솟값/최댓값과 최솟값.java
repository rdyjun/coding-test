class Solution {
    public String solution(String s) {
        String[] ans = s.split(" ");
        int min = Integer.parseInt(ans[0]);
        int max = min;
        for (int i = 1; i < ans.length; i++) {
            int n = Integer.parseInt(ans[i]);
            if (min > n)
                min = n;
            if (max < n)
                max = n;
        }
        return min + " " + max;
    }
}