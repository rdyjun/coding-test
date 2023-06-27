from collections import deque

def bfs(maps, start, end):
    q = deque([(start[0], start[1], 0)])
    m = [*maps]
    h = len(maps[0])
    v = len(maps)
    
    lever_bool = False
    visited = set()
    path = [[0, 1], [0, -1], [1, 0], [-1, 0]]
    print(start, ' ', end, '---------------')
    while q:
        t = q.popleft()
        print(t)
        qy, qx, c = t[0], t[1], t[2]
        if (qy, qx) in visited:
            continue
        else:
            visited.add((qy, qx))
            
        if (qy, qx) == tuple(end):
            return c
        
        for i in path:
            py = qy + i[0]
            px = qx + i[1]
            if 0 <= px < h and 0 <= py < v and (py, px) not in visited and maps[py][px] != 'X':
                q.append((py, px, c + 1))
    
    return -1

def solution(maps):
    for idx, val in enumerate(maps):
        if val.count('S') > 0: start = [idx, val.index('S')]
        if val.count('E') > 0: exit = [idx, val.index('E')]
        if val.count('L') > 0: lever = [idx, list(val).index('L')]
    a = bfs(maps, start, lever)
    if a == -1:
        return -1
    b = bfs(maps, lever, exit)
    if b == -1:
        return -1
    print(a)
    print(b)
    return a + b