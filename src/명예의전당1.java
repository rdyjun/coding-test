public class 명예의전당1 {
    public static void main(String[] args) {
        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        int k = 4;

        int[] answer = new int[score.length];
        int[] a = new int[k];
        answer[0] = score[0];
        a[0] = score[0];


        for(int i = 1; i < score.length; i++) {
            for(int o = 0; o < k; o++) {
                if (score[i] > a[o]) {
                    for(int b = i >= k ? k - 1 : i; b > o; b--) {
                        a[b] = a[b - 1];
                    }
                    a[o] = score[i];
                    break;
                } else if (i < k && o == k - 1) {
                    a[o] = score[i];
                }
            }

            if(i < k) {  //i가 명예전당 랭킹이라면 i 입력 아니면 맨 끝 번호 입력
                answer[i] = a[i];
            } else
                answer[i] = a[k - 1];
        }

        for(int c : answer)
            System.out.println(c);
    }
}