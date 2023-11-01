class Solution {
    public String solution(String my_string, int[] indices) {
        String[] splitString = my_string.split("");
        for (int i : indices)
            splitString[i] = "";
        return String.join("", splitString);
    }
}