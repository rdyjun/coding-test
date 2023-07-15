from collections import deque

def solution(maps):
    vl = len(maps)
    hl = len(maps[0])
    b = [[True if k != 'X' else False for k in i] for i in maps]
    qu = deque()
    dirt = [[0, 1], [0, -1], [1, 0], [-1, 0]]
    c = 0
    answer = []
    for idx1, val1 in enumerate(maps):
        for idx2, val2 in enumerate(val1):
            if b[idx1][idx2]:
                qu.append([idx1, idx2])
                b[idx1][idx2] = False
                while qu:
                    n = qu.popleft()
                    c += int(maps[n[0]][n[1]])
                    for i in dirt:
                        tmp = [n[0] + i[0], n[1] + i[1]]
                        if vl > tmp[0] >= 0 and hl > tmp[1] >= 0 and b[tmp[0]][tmp[1]]:
                            b[tmp[0]][tmp[1]] = False
                            qu.append([n[0] + i[0], n[1] + i[1]])
                    print(n, maps[n[0]][n[1]])
                answer.append(c)
                c = 0
                
    if len(answer) == 0:
        return [-1]
    else:
        return sorted(answer)