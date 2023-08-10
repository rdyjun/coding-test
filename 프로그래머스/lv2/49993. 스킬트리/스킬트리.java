class Solution {
    public int solution(String skill, String[] skill_trees) {
        int len = skill_trees.length;
        char ch;
        char nextChar;
        int answer = 0;
        int level;
        for (int i = 0; i < len; i++) {
            int l = skill_trees[i].length();
            level = 0;
            for (int k = 0; k < l; k++) {
                char a = skill_trees[i].charAt(k);
                if (!skill.contains(Character.toString(a)))
                    continue;
                if (skill.charAt(level) == a) {
                    level = level + 1;
                    continue;
                }
                answer++;
                break;
            }
        }
        return len - answer;
    }
}