import java.util.*;

class Solution {    
    
    public int solution(String str1, String str2) {
        Words words1 = new Words(str1);
        Words words2 = new Words(str2);
        int sameWordCount = words1.compareTo(words2);
        
        int all = words1.size() + (words2.size() - sameWordCount);
        double answer = 1.0;
        if (sameWordCount > 0 || all > 0)
            answer *= (double)sameWordCount / all;
        return (int)(answer * 65536.0);
    }
}
class Words {
    private List<String> words;
    private boolean[] visited;
    
    public Words (String str) {
        str = str.toLowerCase();
        this.words = createWordArray(str);
        int wordsSize = this.words.size();
        visited = new boolean[wordsSize];
    }
    public int size () {
        return words.size();
    }
    public String get (int index) {
        return words.get(index);
    }
    public boolean isVisited (int index) {
        return this.visited[index];
    }
    public void checkVisited (int index) {
        this.visited[index] = true;
    }
    private List<String> createWordArray (String str) {
        List<String> arr = new ArrayList<>();
        int strLen = str.length();
        for (int charIndex = 0; charIndex < strLen - 1; charIndex++) {
            char firstChar = str.charAt(charIndex);
            if (!isString(firstChar))
                continue;
            char secondChar = str.charAt(charIndex + 1);
            if (!isString(secondChar))
                continue;
            arr.add("" + firstChar + secondChar);
        }
        return arr;
    }
    private boolean isString (char ch) {
        if (ch >= 'a' && ch <= 'z')
            return true;
        return false;
    }
    public int compareTo (Words compareWords) {
        int sameWordCount = 0;
        for (int originalIndex = 0; originalIndex < size(); originalIndex++) {
            String originalString = get(originalIndex);
            sameWordCount += tourCompareWords(originalIndex, originalString, compareWords);
        }
        return sameWordCount;
    }
    private int tourCompareWords (int originalIndex, String originalString, Words compareWords) {
        for (int compareIndex = 0; compareIndex < compareWords.size(); compareIndex++) {
            if (compareWords.isVisited(compareIndex))
                continue;
            
            String compareString = compareWords.get(compareIndex);
            if (originalString.equals(compareString)) {
                compareWords.checkVisited(compareIndex);
                return 1;
            }
        }
        return 0;
    }
}