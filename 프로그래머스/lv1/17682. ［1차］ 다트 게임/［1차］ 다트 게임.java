class Solution {
    public int solution(String dart) {
        
        int answer = 0;
        int dlen = dart.length();
        int[] point = new int[2];
        int s = 0;
        String temp = new String();
        char c;
        
        
        for(int i = 0; i < dlen; i++){
                      
            c = dart.charAt(i);
            
            //문자 및 숫자 구분
            if(c >= '0' && c <= '9'){
                
                temp += c;
                
            } else if(c == 'S' || c == 'D' || c == 'T'){
                
                point[0] = point[1];
                point[1] = Integer.parseInt(temp);
                temp = new String();
                
                if(c == 'S'){s = 1;} else
                    if(c == 'D'){s = 2;} else
                        if(c == 'T'){s = 3;}
                
                point[1] = (int)Math.pow(point[1], s);
                
                answer += point[0];
                if(i+1 == dlen){answer += point[1];}
                
            } else if(c == '#' || c == '*'){
                
                if(c == '#'){s = -1;} else
                    if(c == '*'){s = 2;}
                
                if(c == '*'){
                answer -= point[0];
                point[0] *= s;
                answer += point[0];
                }
                
                point[1] *= s;
                point[0] = point[1];
                if(i+1 == dlen){answer += point[0];}
            }
            
        }
        
        return answer;
        }
        
}