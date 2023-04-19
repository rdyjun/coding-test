def solution(id_pw, db):
    answer = ''
    idx = -1
    for i in range(len(db)):
        if (db[i][0] == id_pw[0]):
            idx = i
        
    if (idx == -1) :
        return "fail"
    elif (idx >= 0) :
        if (db[idx][1] == id_pw[1]):
            return "login"
        else:
            return "wrong pw"
        
    return answer