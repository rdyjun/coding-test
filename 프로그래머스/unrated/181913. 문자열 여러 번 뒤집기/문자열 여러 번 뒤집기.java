class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb;
        
        for (int i = 0; i < queries.length; i++) {
            String st = my_string.substring(queries[i][0], queries[i][1] + 1);
            sb = new StringBuilder(st);
            sb.reverse();
            
            my_string = my_string.substring(0, queries[i][0]) + sb.toString() + my_string.substring(queries[i][1] + 1);
        }

        return my_string;
    }
}
