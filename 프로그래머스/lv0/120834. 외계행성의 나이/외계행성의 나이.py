def solution(age):
    a = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j']
    answer = ""
    for i in str(age) :
        answer += a[int(i)]
    return answer