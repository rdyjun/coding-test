def solution(sides):
    l = max(sides[0], sides[1])
    s = min(sides[0], sides[1])
    
        
    return len(range(l - s + 1, l + 1)) + len(range(l + 1, l + s))