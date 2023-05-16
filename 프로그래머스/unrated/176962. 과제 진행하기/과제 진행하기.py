def solution(plans):
    plans = sorted(plans, key=lambda x: x[1])
    rv = []
    answer = []
    arr = {i[0] : [int(i[1].split(":")[0]) * 60 + int(i[1].split(":")[1]), int(i[2])] for i in plans} # {'korean': [700, 30], 'eng': [700, 30]}
    for idx, val in enumerate(plans[:len(plans) - 1]):
        a = sum(arr[val[0]]) #끝나는 시간
        b = arr[plans[idx + 1][0]][0] #다음시작시간
        if a > b:
            rv.insert(0,[val[0], a - b])
        elif b > a:
            answer.append(val[0])
            if len(rv) > 0:
                num = b - a
                n = 0
                for _ in range(len(rv)):
                    if int(rv[0][1]) <= num:
                        answer.append(rv[0][0])
                        num -= int(rv[0][1])
                        del rv[0]
                    else:
                        rv[0][1] = str(int(rv[0][1]) - num)
                        break
        else:
            answer.append(val[0])
    answer.append(plans[len(plans) - 1][0])
    for i in rv:
        answer.append(i[0])
            
            
    return answer