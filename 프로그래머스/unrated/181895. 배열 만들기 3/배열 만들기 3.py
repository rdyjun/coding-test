def solution(arr, intervals):
    return [k for i in intervals for k in arr[i[0]:i[1] + 1]]