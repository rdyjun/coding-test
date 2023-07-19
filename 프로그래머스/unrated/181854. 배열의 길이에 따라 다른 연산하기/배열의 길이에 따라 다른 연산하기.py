def solution(arr, n):
    if len(arr) % 2 == 1:
        arr = [v + n if i % 2 == 0 else v for i, v in enumerate(arr)]
    else:
        arr = [v + n if i % 2 == 1 else v for i, v in enumerate(arr)]
    return arr