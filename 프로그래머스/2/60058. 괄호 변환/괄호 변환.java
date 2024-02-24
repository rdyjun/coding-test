class Solution {
    
    private StringBuilder stb;
    
    public String solution(String p) {
        stb = new StringBuilder();
        answer(p);
        
        return stb.toString();
    }
    
    public void answer(String p) {
        int open = 0;
        int n = p.length();
        boolean flag = true;
        
        for(int i = 0; i < n; i++) {
            if(i > 0 && open == 0) {
                if(flag) {
                    fill(p, i);
                    
                    if(i < n - 1)
                        answer(p.substring(i, n));
                }
                
                if(!flag) {
                    stb.append('(');
                    
                    if(i < n - 1)
                            answer(p.substring(i, n));
                    
                    stb.append(')');
                    
                    reverseFill(p.substring(0, i));
                }
                
                return;
            }
            
            char c = p.charAt(i);
            
            if(c == ')') {
                if(open == 0)
                    flag = false;
                open--;
                continue;
            }
            
            open++;
        }
        
        if(!flag) {
            stb.append('(');
            stb.append(')');

            reverseFill(p);
        }
        
        if(flag)
            fill(p, n);
    }
    
    private void fill(String p, int end) {
        for(int i = 0; i < end; i++)
            stb.append(p.charAt(i));
    }
    private void reverseFill(String p) {
        int n = p.length();
        for(int i = 1; i < n - 1; i++) {
            char c = p.charAt(i);
            
            if(c == '(')
                stb.append(')');
            
            if(c == ')')
                stb.append('(');
        }
    }
}