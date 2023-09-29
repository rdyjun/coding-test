class Solution {
    private int divideNum (int n) {
        if (n % 2 == 1)
            n++;
        return n / 2;
    }
    
    public int solution(int n, int a, int b) {
        int answer = 1;
        if (a > b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (!(b - a == 1 && a % 2 == 1)) {
            answer++;
            a = divideNum(a);
            b = divideNum(b);
        }
        return answer;
    }
}