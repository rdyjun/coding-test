str = input()
ans = []
for i in str : 
    if (i.isupper()): 
        ans.append(i.lower())
    else :
        ans.append(i.upper())
print("".join(ans))