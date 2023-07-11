import math

def solution(n):
    arr = [i for i in range(2, n + 1)]
    m = 1
    while m <= math.sqrt(n):
        m += 1
        if arr.count(m) > 0:
            arr = arr[:arr.index(m) + 1] + [k for k in arr[arr.index(m) + 1:] if k % m != 0 or k / m == 1]
            continue
        
    return len(arr)