def solution(book_time):
    book_time = sorted(book_time)
    b = [True for i in book_time]
    answer = 0
    for idx, val in enumerate(book_time):
        answer += 1
        if b[idx]:
            b[idx] = False
            n = val
            for i, v in enumerate(book_time[idx + 1:]):
                if b[i + idx + 1]:
                    nm = int(n[1][3:]) + 10
                    nh = int(n[1][:2]) + (nm // 60)
                    nm %= 60
                    vm = int(v[0][3:]) 
                    vh = int(v[0][:2])
                    
                    if vh > nh or (vh == nh and vm >= nm):
                        b[i + idx + 1] = False
                        n = v
        else:
            answer -=1
        
        
    return answer