def solution(survey, choices):
    arr = {'R' : 0, 'T' : 0, 'C' : 0, 'F' : 0, 'J' : 0, 'M' : 0, 'A' : 0, 'N' : 0}
    for idx, val in enumerate(choices):
        if val > 4:
            arr[survey[idx][1]] += val - 4
        elif val < 4:
            arr[survey[idx][0]] += 4 - val
    answer = ''
    answer += 'R' if arr['R'] > arr['T'] else 'R' if arr['R'] == arr['T'] else 'T'
    answer += 'C' if arr['C'] > arr['F'] else 'C' if arr['C'] == arr['F'] else 'F'
    answer += 'J' if arr['J'] > arr['M'] else 'J' if arr['J'] == arr['M'] else 'M'
    answer += 'A' if arr['A'] > arr['N'] else 'A' if arr['A'] == arr['N'] else 'N'
    return answer