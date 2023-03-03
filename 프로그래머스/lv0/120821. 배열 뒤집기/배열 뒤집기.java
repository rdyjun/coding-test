class Solution {
    public int[] solution(int[] num_list) {
        int a;
        int n = num_list.length;
        for(int i = 0; i < n / 2; i++){
            a = num_list[i];
            num_list[i] = num_list[n - 1 - i];
            num_list[n - 1 - i] = a;
        }
        return num_list;
    }
}