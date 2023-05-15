def solution(wallpaper):
    answer = [0, 0, 0, 0]
    answer[0] = next((idx for idx, val in enumerate(wallpaper) if val.find("#") >= 0))
    
    for i in range(len(wallpaper[0])):
        if [word[i] for word in wallpaper].count("#") > 0:
            answer[1] = i
            break
    
    answer[2] = len(wallpaper) - next((idx for idx, val in enumerate(reversed(wallpaper)) if val.find("#") >= 0))
    
    for i in range(len(wallpaper[0]) - 1, -1, -1):
        if [word[i] for word in wallpaper].count("#") > 0:
            answer[3] = i + 1
            break
        
    return answer