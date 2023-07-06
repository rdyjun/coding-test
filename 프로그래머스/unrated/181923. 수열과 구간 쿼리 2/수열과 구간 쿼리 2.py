def solution(arr, queries):
    result = []
    for i in queries:
        n = -1
        for k in arr[i[0]:i[1] + 1]:
            if k > i[2]:
                if n == -1:
                    n = k
                elif n > k:
                    n = k
        result.append(n)
        
            
    return result