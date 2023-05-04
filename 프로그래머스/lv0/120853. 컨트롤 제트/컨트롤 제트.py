def solution(s):
    arr = s.split(" ")
    for i in range(len(arr)) :
        if (arr[i] == 'Z') :
            arr[i] = str(int(arr[i - 1]) * -1)
    return sum(map(int, arr))