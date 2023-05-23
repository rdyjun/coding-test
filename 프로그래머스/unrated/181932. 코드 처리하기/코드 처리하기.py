def solution(code):
    mode = 0
    answer = ''
    for idx, val in enumerate(list(code)):
        if val == '1':
            mode = abs(mode - 1)
            continue
        if (mode == 0 and not idx % 2) or (mode == 1 and idx % 2):
            answer += val
            
    return answer if answer != '' else "EMPTY"