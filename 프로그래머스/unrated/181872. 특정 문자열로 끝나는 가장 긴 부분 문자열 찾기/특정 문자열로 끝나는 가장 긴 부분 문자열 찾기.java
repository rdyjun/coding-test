class Solution {
    public String solution(String myString, String pat) {
        String reverseString = new StringBuffer(myString)
            .reverse()
            .toString();
        
        String reversePat = new StringBuffer(pat)
            .reverse()
            .toString();
        
        int n = myString.length() - reverseString.indexOf(reversePat);
        
        return myString.substring(0, n);
    }
}