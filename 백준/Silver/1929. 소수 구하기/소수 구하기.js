const input = require('fs').readFileSync(0)
    .toString()
    .trim()
    .split(' ');

const min = Number(input[0]);
const max = Number(input[1]);

let array = [];
array[1] = true;

for (let i = 2; i < max; i++) {
    let k = 2;
    while (i * k <= max) {
        array[i * k] = true;
        
        k++;
    }
}

for (let i = min; i <= max; i++) {
    if (!array[i]) {
        console.log(i);
    }
}