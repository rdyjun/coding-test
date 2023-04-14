def solution(array):
    a = 0
    for i in array :
        if (array.count(i) > a) :
            a = array.count(i)
            answer = i
    for i in array :
        if (array.count(i) == a) :
            if (i != answer) :
                answer = -1
                break
            
    return answer