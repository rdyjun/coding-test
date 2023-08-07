class Solution {
    public int compare (char msChar, String patChar, int n) {
        if (msChar == Character.toUpperCase(patChar.charAt(n)) || 
            msChar == Character.toLowerCase(patChar.charAt(n)))
            return 1;
        if (n > 0 &&
           msChar == Character.toUpperCase(patChar.charAt(0)) || 
            msChar == Character.toLowerCase(patChar.charAt(0)))
            return -1;
        return 0;
    }
    public int changeValue (int a, int b) {
        if (b == 1)
            return a + b;
        if (b == -1)
            return 1;
        return 0;
    }
    public int solution(String myString, String pat) {
        int n = 0;
        for (int i = 0; i < myString.length() && n != pat.length(); i++) {
            char ch = myString.charAt(i);
            n = changeValue(n, compare(ch, pat, n));
        }
        if (n == pat.length())
            return 1;
        return 0;
    }
}