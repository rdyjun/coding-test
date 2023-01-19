class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] basket = new int[moves.length];
        for(int i = 0; i < moves.length; i++){
            Loop2 :
            for(int k = 0; k < board.length; k++){
                if(board[k][moves[i] - 1] != 0){
                    for(int j = 0; j < basket.length; j++){
                        if(basket[j] == 0){
                            basket[j] = board[k][moves[i] - 1];
                            board[k][moves[i] - 1] = 0;
                            if(j > 0 && basket[j] == basket[j - 1]){
                                answer += 2;
                                basket[j] = 0;
                                basket[j - 1] = 0;
                            }
                            break Loop2;
                        }
                    }
                }
            }
        }
        return answer;
    }
}