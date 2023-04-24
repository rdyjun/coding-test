def solution(str1, str2):
    answer = ""
    for i in range(len(str2)) :
        answer += str1[i] if len(str1) > i else ""
        answer += str2[i] if len(str2) > i else ""
    return answer