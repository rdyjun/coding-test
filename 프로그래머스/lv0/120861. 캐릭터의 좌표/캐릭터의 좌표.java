class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[]{0, 0};
        for(String st : keyinput) {
            switch (st) {
                case "left" :
                    if (answer[0] != board[0] / -2)
                        answer[0] -= 1;
                    break;
                case "right" :
                    if (answer[0] != board[0] / 2)
                        answer[0] += 1;
                    break;
                case "up" :
                    if (answer[1] != board[1] / 2)
                        answer[1] += 1;
                    break;
                case "down" :
                    if (answer[1] != board[1] / -2)
                        answer[1] -= 1;
                    break;
            }
        }
        return answer;
    }
}