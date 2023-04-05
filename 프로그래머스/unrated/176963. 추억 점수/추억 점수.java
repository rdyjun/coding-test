class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        for (int i = 0; i < photo.length; i++) {
            for (int k = 0; k < photo[i].length; k++) {
                String nm = photo[i][k];
                for(int n = 0; n < name.length; n++) {
                    if (nm.equals(name[n]))
                        answer[i] += yearning[n];
                }
            }
        }
        return answer;
    }
}