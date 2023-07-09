def solution(myString):
    return ''.join([i.upper() if i in ('a', 'A') else i.lower() for i in myString])