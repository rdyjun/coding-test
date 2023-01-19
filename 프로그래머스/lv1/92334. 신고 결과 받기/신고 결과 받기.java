import java.util.Arrays;
class Solution {

    public int[] solution(String[] id_list, String[] report, int k) {
        Arrays.sort(report);
        int[] answer = new int[id_list.length];
        int[] rpoint = new int[id_list.length];
        String[][] rp = new String[report.length][2];
        for(int i = 0; i < report.length; i++){
            rp[i][0] = report[i].substring(0, report[i].indexOf(" "));
            rp[i][1] = report[i].substring(report[i].indexOf(" ") + 1);
        }
        for(int i = 0; i < report.length; i++){
            rp[i] = report[i].split(" ");
        }
        
        for(int i = 0; i < report.length; i++){
            if(i == report.length - 1 || !report[i].equals(report[i + 1])){
                for(int j = 0; j < id_list.length; j++){
                    if(id_list[j].equals(rp[i][1])){
                        rpoint[j] += 1;
                    }
                }
            }
        }
        for(int i = 0; i < report.length; i++){
            if(i == report.length - 1 || !report[i].equals(report[i + 1])){
                for(int j = 0; j < id_list.length; j++){
                    if(id_list[j].equals(rp[i][0])){
                        for(int o = 0; o < id_list.length; o++){
                            if(id_list[o].equals(rp[i][1])){
                                if(rpoint[o] >= k){
                                    answer[j] += 1;
                                }
                            }
                        }
                        
                    }
                }
            }
        }
        return answer;
    }
}