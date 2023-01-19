class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] a = new double[N];
        int[] b = new int[N];
        double tmp;
        for(int i = 1; i <= N; i++){
            answer[i - 1] = i;
        }
        for(int i = 0; i < N; i++){
            for(int k = 0; k < stages.length; k++){
                if(stages[k] >= i + 1){
                    a[i] += 1;
                }
                if(stages[k] == i + 1){
                    b[i] += 1;
                }
            }
        }
        for(int i = 0; i < a.length; i++){
            if(b[i] > 0 && a[i] > 0){
                a[i] = (double)b[i] / a[i];   
            } else if(b[i] == 0){
                a[i] = 0;
            }
        }
        for(int i = 0; i < N - 1; i++){
            for(int k = 1 + i; k < N; k++){
                if(a[i] < a[k]){
                    tmp = answer[i];
                    answer[i] = answer[k];
                    answer[k] = (int)tmp;
                    tmp = a[k];
                    a[k] = a[i];
                    a[i] = tmp;
                } else if(a[i] == a[k]){
                    if(answer[i] > answer[k]){
                        tmp = answer[i];
                        answer[i] = answer[k];
                        answer[k] = (int)tmp;
                    }
                }
            }
        }
        
        return answer;
    }
}