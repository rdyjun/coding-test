import heapq

def solution(n, k, enemy):
    
    arr = [0] * k
    heapq.heapify(arr)
    
    for idx, i in enumerate(enemy):
        if i > arr[0]:
            n -= heapq.heapreplace(arr, i)
        else:
            n -= i
        if n < 0:
            return idx
    return len(enemy)