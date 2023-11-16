import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();
        for (String file : files)
            fileList.add(new File(file));
        boolean[] visited = new boolean[files.length];
        Collections.sort(fileList);
        return fileList.stream()
            .map(v -> v.getFileName())
            .toArray(String[]::new);
    }
    private void sortFile (List<File> fileList, boolean[] visited) {
        for (int targetIndex = 0; targetIndex < fileList.size() - 1; targetIndex++) {
            if (visited[targetIndex])
                continue;
            int changeIndex = findPrecendingString(fileList, targetIndex, visited);
            if (changeIndex == targetIndex)
                continue;
            Collections.swap(fileList, targetIndex, changeIndex);
        }
    }
    private int findPrecendingString (List<File> fileList, int targetIndex, boolean[] visited) {
        File lastFile = fileList.get(targetIndex);
        File candidateFile;
        int changeIndex = targetIndex;
        for (int candidateIndex = targetIndex + 1; candidateIndex < fileList.size(); candidateIndex++) {
            if (visited[candidateIndex])
                continue;
            candidateFile = fileList.get(candidateIndex);
            if (lastFile.compareTo(candidateFile) == 1) {
                lastFile = candidateFile;
                changeIndex = candidateIndex;
            }
        }
        return changeIndex;
    }
}

class File implements Comparable<File> {
    private String head;
    private int number;
    private String fileName;
    
    public File (String fileName) {
        this.fileName = fileName;
        this.head = findHead();
        this.number = findNumber();
    }
    
    @Override
    public int compareTo (File f2) {
        String firstFileHead = this.getHead();
        String secondFileHead = f2.getHead();
        
        int compareHead = firstFileHead.compareToIgnoreCase(secondFileHead);
        if (compareHead > 0)
            return 1;
        if (compareHead < 0)
            return -1;
        if (this.getNumber() > f2.getNumber())
            return 1;
        if (this.getNumber() < f2.getNumber())
            return -1;
        return 0;
    }
    public String getFileName () {
        return this.fileName;
    }
    public String getHead () {
        return this.head;
    }
    public int getNumber () {
        return this.number;
    }
    private int findNumber () {
        int fileNameLength = this.fileName.length();
        int numberStartIndex = -1;
        for (int i = 0; i < fileNameLength; i++) {
            if (isNumber(this.fileName.charAt(i))) {
                numberStartIndex = i;
                break;
            }
        }
        int numberIndex = numberStartIndex + 1;
        if (fileNameLength > numberStartIndex + 5)
            fileNameLength = numberStartIndex + 5;
        
        for (; numberIndex < fileNameLength; numberIndex++)
            if (!isNumber(this.fileName.charAt(numberIndex)))
                break;
        String number = this.fileName.substring(numberStartIndex, numberIndex);
        return Integer.parseInt(number);
    }
    private boolean isNumber (char ch) {
        if (ch >= '0' && ch <= '9')
            return true;
        return false;
    }
    private String findHead () {
        int fileLength = this.fileName.length();
        int index = 0;
        for (; index < fileLength; index++)
            if (isNumber(this.fileName.charAt(index)))
                break;
        return this.fileName.substring(0, index);
    }
}