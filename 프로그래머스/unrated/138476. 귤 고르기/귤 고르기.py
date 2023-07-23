from collections import Counter

def solution(k, tangerine):
    arr = Counter(tangerine)
    arr = sorted(arr.values())
    

    for i, v in enumerate(arr[::-1]):
        k -= v
        if k <= 0:
            return i + 1
    
    
    return len(tangerine)