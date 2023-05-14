def solution(park, routes):
    start = [0, 0]
    move = [0, 0, 0]
        
    for i in range(len(park)):
        if park[i].find("S") >= 0:
            start[0] = i
            start[1] = park[i].find("S")
            break
            
    for i in routes:
        rt = i.split(' ')
        if (rt[0] == 'E'):
            move[1] = int(rt[1])
        elif (rt[0] == 'W'):
            move[1] = int(rt[1]) * -1
        elif (rt[0] == 'N'):
            move[0] = int(rt[1]) * -1
        elif (rt[0] == 'S'):
            move[0] = int(rt[1])
        
        nxt = [start[0] + move[0], start[1] + move[1]]
            
        if (nxt[0] < 0 or nxt[0] >= len(park) or
            nxt[1] < 0 or nxt[1] >= len(park[0])):
            move = [0, 0]
            continue
            
        if(move[0] == 0):
            a = min(nxt[1], start[1])
            b = max(nxt[1], start[1])
            if park[start[0]][a:b + 1].find("X") == -1:
                start[1] += move[1]
        else:
            a = min(nxt[0], start[0])
            b = max(nxt[0], start[0])
            for k in range(a, b + 1):
                if park[k][start[1]] == "X":
                    break
                if k == b:
                    start[0] += move[0]
            
        move = [0, 0]
        
    return start