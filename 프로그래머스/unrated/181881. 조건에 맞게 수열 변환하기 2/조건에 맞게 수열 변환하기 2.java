class Solution {
    public int solution(int[] arr) {
        boolean flag = true;
        int n = 0;
        while (flag) {
            flag = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 50 && arr[i] % 2 == 0) {
                    arr[i] /= 2;
                    flag = true;
                    continue;
                }
                if (arr[i] < 50 && arr[i] % 2 == 1) {
                    arr[i] *= 2;
                    arr[i]++;
                    flag = true;
                }
            }
            n++;
        }
        return n - 1;
    }
}