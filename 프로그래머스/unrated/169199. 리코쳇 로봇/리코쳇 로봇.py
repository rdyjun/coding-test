def solution(board):
    for idx, i in enumerate(board):
        if list(i).count('R'):
            start = [idx, list(i).index('R')] # 0 0
        if list(i).count('G'):
            end = [idx, list(i).index('G')] # 1 0
    que = [start]
    c = [0]
    
    yn = len(board)
    xn = len(board[0])
    
    bdr = [list(i) for i in board]
    
    DIR = [[0, 1], [0, -1], [1, 0], [-1, 0]]
    
    while True:
        if len(que) == 0:
            return -1
        else:
            t = que.pop(0)
            count = c.pop(0)
            if t == end:
                return count
            else:
                for i in DIR:
                    tmp = [*t]
                    for k in range(max(yn, xn)):
                        tmp[0] += i[0]
                        tmp[1] += i[1]
                        if 0 > tmp[0] or tmp[0] >= yn or 0 > tmp[1] or tmp[1] >= xn or bdr[tmp[0]][tmp[1]] == 'D':
                            tmp[0] -= i[0]
                            tmp[1] -= i[1]
                            break
                            
                    if bdr[tmp[0]][tmp[1]] not in ('N', 'R'):
                        bdr[tmp[0]][tmp[1]] = 'N'
                        c.append(count + 1)
                        que.append(tmp)