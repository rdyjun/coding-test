class Solution {
    public String solution(String m, String[] musicinfos) {
        int musicsLen = musicinfos.length;
        int mLen = getMLen(m);
        String answer = "(None)";
        int answerMusicLength = 0;
        for (int i = 0; i < musicsLen; i++) {
            String[] musicInfo = musicinfos[i].split(",");
            int duration = getDuration(musicInfo[0], musicInfo[1]);
            if (mLen > duration)
                continue;
            String music = getFullMusic(mLen, duration, musicInfo[3]);
            if (isInclude(m, music) && answerMusicLength < duration) {
                answer = musicInfo[2];
                answerMusicLength = duration;
            }
        }
        return answer;
    }
    private boolean isInclude (String m, String music) {
        int len = m.length();
        int idx = music.indexOf(m);
        while (idx != -1) {
            if (music.length() == len + idx || music.charAt(len + idx) != '#')
                return true;
            idx = music.indexOf(m, idx + 1);
        }
        return false;
    }
    private int getMLen (String m) {
        int len = m.length();
        int length = 0;
        for (int i = 0; i < len - 1; i++) {
            if (m.charAt(i + 1) == '#')
                i++;
            length++;
        }
        if (m.charAt(len - 1) != '#')
            length++;
        return length;
    }
    private int getDuration (String start, String end) {
        String[] splitStart = start.split(":");
        String[] splitEnd = end.split(":");
        int startMinute = Integer.parseInt(splitStart[0]) * 60 + Integer.parseInt(splitStart[1]);
        int endMinute = Integer.parseInt(splitEnd[0]) * 60 + Integer.parseInt(splitEnd[1]);
        int duration = endMinute - startMinute;

        return duration;
    }
    private String getFullMusic (int mLen, int duration, String music) {
        StringBuilder stringBuilder = new StringBuilder();
        int len = music.length() + mLen;
        for (int i = 0; i < len && i < duration; i++) {
            stringBuilder.append(music.charAt(i % music.length()));
            if (music.charAt((i + 1) % music.length()) == '#') {
                stringBuilder.append("#");
                i++;
                duration++;
                len++;
            }
        }
        return stringBuilder.toString();
    }
}