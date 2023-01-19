class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++){
            
            String a = Integer.toBinaryString(arr1[i]|arr2[i]);
            a = String.format("%" + n + "s", a);
            a = a.replace("1", "#");
            a = a.replace("0", " ");
            answer[i] = a;
        }
        return answer;
    }
}