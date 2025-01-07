const input = require('fs').readFileSync(0)
    .toString()
    .trim()
    .split('\n');

const max = input.reduce((acc, cur) => {
    return Number(cur) > Number(acc) ? Number(cur) : Number(acc);
}, Number(input[0])) * 2;

let array = [];
array[1] = true;

for (let i = 2; i < max; i++) {
    let k = 2;
    while (i * k <= max) {
        array[i * k] = true;
        
        k++;
    }
}

let count = [];
count[1] = 0;

for (let i = 2; i <= max; i++) {
    count[i] = count[i - 1] + (!array[i] ? 1 : 0);
}

input.forEach((value) => {
    if (value === '0') {
        return;
    }

    console.log(count[value * 2] - count[value]);
});