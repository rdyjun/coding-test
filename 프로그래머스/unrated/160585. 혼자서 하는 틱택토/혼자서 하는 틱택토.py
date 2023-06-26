def solution(board):
    xc = 0
    oc = 0
    cx = 0
    co = 0
    for i in board:
        xc += i.count('X')
        oc += i.count('O')
        
    if oc != xc and oc - 1 != xc:
        return 0
        
    a = ''.join([val[idx] for (idx, val) in enumerate(board)])
    b = ''.join([val[2 - idx] for (idx, val) in enumerate(board)])
    print(a)
    print(b)

    arr = [''.join([i[k] for i in board]) for k in range(len(board))]
    co += board.count('OOO') + arr.count('OOO') + a.count('OOO') + b.count('OOO')
    cx += board.count('XXX') + arr.count('XXX') + a.count('XXX') + b.count('XXX')
    
    if co > 0 and cx > 0:
        return 0
    elif co > 0 and not xc + 1 == oc:
        return 0
    elif cx > 0 and not xc == oc:
        return 0
    return 1