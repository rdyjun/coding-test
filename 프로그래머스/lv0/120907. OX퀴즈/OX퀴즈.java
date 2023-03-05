class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        int i = 0;
        for(String st : quiz){
            String[] stArr = new String[5];
            stArr = st.split(" ");
            int num = Integer.parseInt(stArr[0]);
            switch (stArr[1]){
                case "+" :
                    num += Integer.parseInt(stArr[2]);
                    break;
                case "-" :
                    num -= Integer.parseInt(stArr[2]);
                    break;
            }
            answer[i] = (String.valueOf(num).equals(stArr[4]) ? "O" : "X");
            i++;
        }
        return answer;
    }
}