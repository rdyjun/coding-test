class Solution {
    private int len;
    private int[] sticker;
    private int loop (int n) {
        int len = this.len - n - 2;
        if (n == 0)
            len -= 1;
        int[] arr = new int[len];
        int m = sticker[n];
        int b;
        for (int i = 0; i < len; i++) {
            if (i <= 1) {
                arr[i] = m + sticker[i + n + 2];
                continue;
            }
            arr[i] = sticker[i + n + 2] + arr[i - 2];
            if (i - 3 < 0)
                continue;
            b = sticker[i + n + 2] + arr[i - 3];
            if (arr[i] < b)
                arr[i] = b;
        }
        if (len < 2 || arr[len - 1] > arr[len - 2])
            return arr[len - 1];
        return arr[len - 2];
    }
    private int getMax () {
        int max = sticker[0];
        for (int i = 1; i < len; i++)
            if (max < sticker[i])
                max = sticker[i];
        return max;
    }
    public int solution(int[] sticker) {
        len = sticker.length;
        this.sticker = sticker;
        if (len <= 3)
            return getMax();
        int a = loop(0);
        int b = loop(1);
        int c = 0;
        if (len > 4)
            c = loop(2);
        if (a > b && a > c)
            return a;
        if (b > c)
            return b;
        return c;
    }
}