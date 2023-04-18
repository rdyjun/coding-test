def solution(chicken):
    answer = 0
    n = 0
    while True :
        if (int(chicken / 10) > 0):
            answer += int(chicken / 10) # 108 + 10 + 1, 1
            chicken = int(chicken / 10) + int(chicken % 10) # 108 + 1, 10 + 9, 1 + 9, 1
        else:
            break
    
    return int(answer)