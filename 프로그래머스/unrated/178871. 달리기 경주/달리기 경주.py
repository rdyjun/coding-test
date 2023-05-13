def solution(players, callings):
    arr = {item : idx for idx, item in enumerate(players)}
    for i in callings:
        prev = arr[players[arr[i] - 1]]
        item = arr[i]
        players[prev], players[item] = players[item], players[prev]
        arr[players[prev]], arr[players[item]] = arr[players[item]], arr[players[prev]]
    return players