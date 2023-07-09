def solution(myString, pat):
    return 1 if ''.join(['B' if i == 'A' else 'A' for i in myString]).find(pat) != -1 else 0