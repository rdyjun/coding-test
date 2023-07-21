def solution(storey):
    answer = 0
    i = 1
    while i <= storey:
        n = storey // i % 10
        if n != 0:
            m = storey // (i * 10) % 10
            if n > 5:
                answer += 10 - n
                storey += (10 - n) * i
            else:
                if n == 5 and m >= 5:
                    storey += 5 * i
                answer += n
        i *= 10
            
    return answer