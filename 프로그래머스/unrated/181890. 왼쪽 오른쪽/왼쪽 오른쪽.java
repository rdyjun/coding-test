import java.util.stream.IntStream;

class Solution {
    public String[] solution(String[] str_list) {
        for (int i = 0; i < str_list.length; i++) {
            String st = str_list[i];
            if (st.equals("l")) 
                return IntStream.range(0, i)
                .mapToObj(v -> str_list[v])
                .toArray(String[]::new);
                
            if (st.equals("r"))
                return IntStream.range(i + 1, str_list.length)
                .mapToObj(v -> str_list[v])
                .toArray(String[]::new);
        }
        return new String[0];
    }
}