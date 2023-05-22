def solution(arr):
    a = max(len(arr[0]), len(arr))
    b = min(len(arr[0]), len(arr))
    arr = [i + [0] * (a - len(arr[0])) for i in arr]
    arr += [[0] * a] * (a - len(arr))
    return arr