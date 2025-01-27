const visited = new Set();
const answer = [];
let globalGrid;
let width;
let height;

const DIRECTION = {
    TOP: 1,
    RIGHT: 2,
    BOTTOM : 3,
    LEFT: 4
};

const MOVEMENT = {
    S: moveStraight,
    R: moveRight,
    L: moveLeft
};

const MOVEMENT_BY_DIRECTION = [
    null,
    [0, -1],
    [1, 0],
    [0, 1],
    [-1, 0]
];

function solution(grid) {
    globalGrid = grid;
    width = grid[0].length;
    height = grid.length;
    
    for (let row = 0; row < height; row++) {
        for (let column = 0; column < width; column++) {
            for (let directionIndex = 1; directionIndex <= 4; directionIndex++) {
                const result = move(column, row, directionIndex);
                if (result > 0) {
                    answer.push(result);
                }
            }
        }
    }
    
    return answer.sort((a, b) => a - b);
}

function move(startX, startY, dir) {
    let cycle = 0;
    let nowPosition = [startX, startY];
    let nextPosition = initializeEndPoint(startX, startY, dir);
    let x, y, direction = dir;
    while (true) {
        try {
            ({ x, y, direction } = getNextStep(nowPosition, nextPosition[0], nextPosition[1], direction));
            x = transferX(x);
            y = transferY(y);

            cycle++;
            nowPosition = nextPosition;
            nextPosition = [x, y];
        } catch {
            break;
        }
    }
    
    return cycle;
}

function initializeEndPoint(x, y, dir) {
    const endX = transferX(x + MOVEMENT_BY_DIRECTION[dir][0]);
    const endY = transferY(y + MOVEMENT_BY_DIRECTION[dir][1]);
    return [endX, endY];
}

function getNextStep(nowPosition, endX, endY, direction) {
    const startPoint = `${nowPosition}:${direction}`;
    if (visited.has(startPoint)) {
        throw new Error('이미 방문한 좌표입니다.');
    }
    
    visited.add(startPoint);
    
    const moveSide = globalGrid[endY][endX];
    return MOVEMENT[moveSide](endX, endY, direction);
}

function transferY(y) {
    if (y >= height) {
        return 0;
    }
    
    if (y < 0) {
        return height - 1;
    }
    
    return y;
}

function transferX(x) {
    if (x >= width) {
        return 0;
    }
    
    if (x < 0) {
        return width - 1;
    }
    
    return x;
}


function moveLeft(x, y, direction) {
    direction = direction === 1 ? 4 : direction - 1;
    
    return {
        x: transferX(x + MOVEMENT_BY_DIRECTION[direction][0]),
        y: transferY(y + MOVEMENT_BY_DIRECTION[direction][1]),
        direction
    };
}

function moveRight(x, y, direction) {
    direction = direction === 4 ? 1 : direction + 1;
    
    return {
        x: transferX(x + MOVEMENT_BY_DIRECTION[direction][0]),
        y: transferY(y + MOVEMENT_BY_DIRECTION[direction][1]),
        direction
    };
}

function moveStraight(x, y, direction) {
    return {
        x: transferX(x + MOVEMENT_BY_DIRECTION[direction][0]),
        y: transferY(y + MOVEMENT_BY_DIRECTION[direction][1]),
        direction
    };
}