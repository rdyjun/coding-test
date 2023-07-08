def solution(num_list):
    arr = [idx for idx, val in enumerate(num_list) if val < 0]
    return arr[0] if arr else -1