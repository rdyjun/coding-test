def solution(keymap, targets):
    answer = []
    
    for i in targets:
        n = 0
        for j in list(i):
            m = -1
            for k in keymap:
                c = list(k).count(j)
                if c != 0:
                    idx = list(k).index(j)
                    m = idx if m == -1 else (m if m < idx else idx)

            
            if m == -1:
                n = 0
                break
            else:
                n += m + 1
        answer.append(n if n != 0 else -1)
    return answer