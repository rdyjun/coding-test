def solution(new_id):
    new_id = ''.join([i.lower() for i in new_id if i.isalpha() or i.isdecimal() or i in ('-', '_', '.')])
    while new_id.find('..') != -1:
        new_id = new_id.replace('..', '.')
    
    if new_id and new_id[len(new_id) - 1] == '.':
        new_id = new_id[:len(new_id) - 1]
    if new_id and new_id[0] == '.':
        new_id = new_id[1:]
    if not new_id:
        new_id = 'a'
    elif len(new_id) >= 16:
        new_id = new_id[:15]
        if new_id and new_id[len(new_id) - 1] == '.':
            new_id = new_id[:len(new_id) - 1]
    if len(new_id) <= 2:
        while len(new_id) < 3:
            new_id = new_id + new_id[len(new_id) - 1]
    return new_id