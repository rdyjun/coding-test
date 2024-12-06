function findRouting(startPoint, endPoint) {
    const diff = [endPoint[0] - startPoint[0], endPoint[1] - startPoint[1]];

    const routing = [];
    const moveCount = Math.abs(diff[0]) + Math.abs(diff[1]);
    for (let i = 0; i < moveCount; i++) {
        if (diff[0] !== 0) {
            const moveDirection = diff[0] > 0 ? 1 : -1;
            startPoint[0] += moveDirection;
            routing.push([...startPoint]);
            diff[0] -= moveDirection;
            
            continue;
        }
        
        const moveDirection = diff[1] > 0 ? 1 : -1;
        startPoint[1] += moveDirection;
        routing.push([...startPoint]);
        diff[1] -= moveDirection;
    }
    
    return routing;
}

function getRouting(routingDictionary, startIndex, endIndex, points) {
    const savedRouting = routingDictionary[`${startIndex}/${endIndex}`];
    if (!savedRouting) {
        const routing = findRouting([...points[startIndex]], [...points[endIndex]]);
        routingDictionary[`${startIndex}/${endIndex}`] = routing;
        return routing;
    }
    
    return savedRouting;
}

function getStartCrash(routes) {
    const crashCount = 0;
    const visited = {};
    return routes.reduce((acc, cur) => {
        visited[cur[0]] = visited[cur[0]] ?? 0;
        visited[cur[0]] += 1;
        if (visited[cur[0]] === 2) {
            return acc + 1;
        }
        
        return acc;
    }, 0);
}

function solution(points, routes) {
    const crashed = {};
    const visited = {};
    const routingDictionary = {};
    const LIMIT_ROUTE_COUNT = routes[0].length;
    
    let answer = getStartCrash(routes);
    
    routes.forEach((route, routeIndex) => {
        let moveCount = 0;
        route.forEach((point, pointIndex) => {
            if (pointIndex === LIMIT_ROUTE_COUNT - 1) {
                return;
            }
            
            const routing = getRouting(routingDictionary, point - 1, route[pointIndex + 1] - 1, points);

            routing.forEach((routePoint, routePointIndex) => {
                moveCount++;
                visited[routePoint] = visited[routePoint] ?? [];
                
                if (!visited[routePoint].includes(moveCount)) {
                    visited[routePoint].push(moveCount);
                    return;
                }
                
                if (!crashed[routePoint] || !crashed[routePoint].includes(moveCount)) {
                    crashed[routePoint] = crashed[routePoint] ?? [];
                    crashed[routePoint].push(moveCount);
                    answer++;
                }
            });
        });
    });
    
    return answer;
}