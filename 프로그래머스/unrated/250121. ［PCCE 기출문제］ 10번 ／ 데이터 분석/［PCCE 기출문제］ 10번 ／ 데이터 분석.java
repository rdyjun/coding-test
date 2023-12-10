import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Arrays;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Data> dataList = new ArrayList<>();
        for (int[] eachData : data)
            dataList.add(new Data(eachData));
        
        dataList = dataList.stream()
            .filter(v -> v.isLessThen(val_ext, ext))
            .sorted((v1, v2) -> Integer.compare(v1.getSortValue(sort_by), v2.getSortValue(sort_by)))
            .collect(Collectors.toList());
        int[][] answer = new int[dataList.size()][4];
        for (int i = 0; i < dataList.size(); i++)
            answer[i] = dataList.get(i).toList();
        return answer;
    }
}
class Data {
    private Integer code;
    private Integer date;
    private Integer maximum;
    private Integer remain;
    public Data (int[] data) {
        this.code = data[0];
        this.date = data[1];
        this.maximum = data[2];
        this.remain = data[3];
    }
    public Integer getCode() {
        return this.code;
    }
    public boolean isLessThen (int val, String ext) {
        int n = getExtNum(ext);
        return n < val;
    }
    public int getExtNum (String ext) {
        switch (ext) {
            case "code":
                return this.code;
            case "date":
                return this.date;
            case "maximum":
                return this.maximum;
            case "remain":
                return this.remain;
        }
        return -1;
    }
    public int getSortValue (String sort_by) {
        int n = getExtNum(sort_by);
        return n;
    }
    public int[] toList () {
        int[] list = new int[4];
        list[0] = code;
        list[1] = date;
        list[2] = maximum;
        list[3] = remain;
        return list;
    }
}