def solution(n, l, r):
    answer = r - l + 1
    for i in range(l - 1, r):
        while i > 0 :
            a, b = divmod(i, 5)
            if a == 2 or b == 2:
                answer -= 1
                break
            else:
                i = a
        
    return answer