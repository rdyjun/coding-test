def solution(x, y, n):
    arr = [-1 for i in range(x, y + 1)] # 0 ~ 30
    arr[0] = 0
    for i in range(x, y): # x = 10 ~ y = 40
        if arr[i - x] != -1:
            if i * 3 <= y and (arr[i * 3 - x] == -1 or (arr[i * 3 - x] != -1 and arr[i * 3 - x] > arr[i - x] + 1)):
                arr[i * 3 - x] = arr[i - x] + 1
            if (i * 2 <= y) and (arr[i * 2 - x] == -1 or (arr[i * 2 - x] != -1 and arr[i * 2 - x] > arr[i - x] + 1)):
                arr[i * 2 - x] = arr[i - x] + 1
            if (i + n <= y) and (arr[i + n - x] == -1 or (arr[i + n - x] != -1 and arr[i + n - x] > arr[i - x] + 1)):
                arr[i + n - x] = arr[i - x] + 1
                    
    return arr[y - x]