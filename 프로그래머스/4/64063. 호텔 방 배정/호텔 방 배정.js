function unionFind(k) {
    let room = new Map();
    
    function find(roomId) {
        if (!room.has(roomId)) {
            return roomId;
        }
        
        room.set(roomId, find(room.get(roomId)));
        return room.get(roomId);
    }
    
    function union(target) {
        room.set(target, room.get(target + 1) ?? target + 1);
    }
    
    return {
        find,
        union
    }
}

function solution(k, room_number) {
    const uf = unionFind(k);
    let answer = [];
    
    room_number.forEach((roomId) => {
        const assignedRoomId = uf.find(roomId);
        answer.push(assignedRoomId);
        uf.union(assignedRoomId);
    });
    
    return answer;
}