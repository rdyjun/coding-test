def solution(k, tangerine):
    arr = [0] * max(tangerine)
    for i in tangerine:
        arr[i - 1] += 1
    arr.sort(reverse=True)

    for i, v in enumerate(arr):
        k -= v
        if k <= 0:
            return i + 1
    
    
    return len(tangerine)