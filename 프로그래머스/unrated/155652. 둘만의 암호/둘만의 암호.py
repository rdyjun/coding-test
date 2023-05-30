def solution(s, skip, index):
    arr = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
    arr = [i for i in arr if skip.count(i) <= 0]
    answer = ""
    
    for i in list(s):
        idx = (arr.index(i) + index) % len(arr)
        answer += arr[idx]
    return answer