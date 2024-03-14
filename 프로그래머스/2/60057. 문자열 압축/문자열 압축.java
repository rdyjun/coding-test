class Solution {
    
    private String s;
    
    private int max;
    
    private int result;
    
    private int stringLength;
    
    public int solution(String s) {
        int len = s.length();
        int answer = len;
        
        this.stringLength = s.length();
        this.s = s;
        this.max = len / 2;
        
        while (max > 0) {
            this.result = len;
            
            rotationLength();
            
            if (this.result < answer) {
                answer = this.result;
            }
            
            this.max--;
        }
        
        return answer;
    }
    
    private void rotationLength() {
        int mainIndex = 0;
        int limit = stringLength - max - max;
        
        while (mainIndex <= limit) {
            String target = s.substring(mainIndex, mainIndex + max);
            mainIndex = compareNextText(mainIndex + max, target);
        }
    }
    
    private int compareNextText(int subIndex, String target) {
        int count = 1;
        int limit = stringLength - max;
        
        while (subIndex <= limit) {
            String compare = s.substring(subIndex, subIndex + max);

            if (!target.equals(compare)) {
                break;
            }

            count++;
            result -= max;
            subIndex += max;
        }
        
        if (count > 1) {
            addCountLength(count);
        }
        
        return subIndex;
    }
    
    private void addCountLength(int count) {
        while (count > 0) {
            result += 1;
            count /= 10;
        }
    }
        
}