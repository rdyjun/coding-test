def solution(arr, queries):
    for i in queries:
        for k in range(i[0], i[1] + 1):
            if k % i[2] == 0:
                arr[k] += 1
    return arr