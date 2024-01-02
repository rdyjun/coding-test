import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> map = new HashMap<>();
        List<String> answer = new ArrayList<>();
        Map<Integer, Integer> max = new HashMap<>();
        for (int i = 0; i < orders.length; i++) {
            Order order = new Order(orders[i], course);
            List<String> menus = order.getCourseMenus();
            for (String menu : menus)
                map.put(menu, map.getOrDefault(menu, 0) + 1);
        }
        for (String key : map.keySet()) {
            int count = map.get(key);
            int len = key.length();
            if (count >= 2 && max.getOrDefault(len, 0) < count)
                max.put(len, count);
        }
        for (String key : map.keySet()) {
            int count = map.get(key);
            int len = key.length();
            if (max.getOrDefault(len, -1) == count)
                answer.add(key);
        }
        Collections.sort(answer);
        return answer.stream()
                .toArray(String[]::new);
    }
}
class Order {
    private String menu;
    private List<String> courseMenus;
    private int[] course;
    public Order (String menu, int[] course) {
        this.menu = menu;
        this.course = course;
        courseMenus = new ArrayList<>();
        getCourse();
    }
    private void getCourse (int idx, StringBuilder courseMenu, int courseIndex) {
        courseMenu.append(menu.charAt(idx));
        if (course[courseIndex] == courseMenu.length()) {
            char[] charArray = courseMenu.toString().toCharArray();
            Arrays.sort(charArray);
            courseMenu = new StringBuilder(String.valueOf(charArray));
            courseMenus.add(courseMenu.toString());
            courseIndex++;
            if (courseIndex == course.length)
                return;
        }
        int len = menu.length();
        for (int i = idx + 1; i < len; i++)
            getCourse(i, new StringBuilder(courseMenu), courseIndex);
    }
    private void getCourse () {
        int len = menu.length() - 1;
        for (int i = 0; i < len; i++)
            getCourse(i, new StringBuilder(), 0);
    }
    public List<String> getCourseMenus () {
        return courseMenus;
    }
}