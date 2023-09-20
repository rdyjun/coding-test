class Solution {
    private int[] dfs (String s, int DFSCount, int removeZeroCount) {
        DFSCount++;
        for (String st : s.split("")) {
            if (st.equals("0")) {
                removeZeroCount++;
            }
        }
        
        s = s.replaceAll("0", "");
        int c = s.length();
        if (s.equals("1"))
            return new int[]{DFSCount, removeZeroCount};
            
        return dfs(Integer.toBinaryString(c), DFSCount, removeZeroCount);
    }
    
    public int[] solution(String s) {
        return dfs(s, 0, 0);
    }
}