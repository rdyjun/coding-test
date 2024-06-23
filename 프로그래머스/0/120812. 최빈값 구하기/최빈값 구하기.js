// function solution(array) {
//     let map = new Map();
    
//     array.forEach(v => {
//         map.set(v, (map.get(v) || 0) + 1);
//     });
    
//     let max = Math.max(...map.values());
//     let arr = [...map.entries()].filter(([key, value]) => value === max)
    
//     if (arr.length > 1) {
//         return -1;
//     }
    
//     return arr[0][0];
// }

function solution(array) {
    let map = new Map();
    
    array.forEach(v => {
        map.set(v, (map.get(v) || 0) + 1);
    });
    
    let max = Math.max(...map.values());
    let arr = [...map.entries()].filter(([key, value]) => value === max)
    
    if (arr.length > 1) {
        return -1;
    }
    
    return arr[0][0];
}