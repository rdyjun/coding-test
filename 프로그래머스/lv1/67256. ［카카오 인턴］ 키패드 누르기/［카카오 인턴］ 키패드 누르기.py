def solution(numbers, hand):
    numbers = [11 if i == 0 else i for i in numbers]
    print(numbers)
    
    answer = ''
    lh = [3, 0]
    rh = [3, 2]
    for i in numbers:
        if (i - 1) % 3 == 0:
            answer += 'L'
            lh = [i // 3, 0] 
        elif i % 3 == 0:
            answer += 'R'
            rh = [i // 3 - 1, 2]
        elif (i - 2) % 3 == 0:
            n = abs((i - 2) // 3 - lh[0]) + abs(1 - lh[1]) # 1 + 1
            m = abs((i - 2) // 3 - rh[0]) + abs(1 - rh[1]) # 0 + 1
            s = ''
            if n < m:
                s = 'L'
            elif m < n:
                s = 'R'
            elif m == n:
                s += 'R' if hand == 'right' else 'L'
            if s == 'L':
                answer += 'L'
                lh = [(i - 2) // 3,1]
            else:
                answer += 'R'
                rh = [(i - 2) // 3, 1]
            
    return answer