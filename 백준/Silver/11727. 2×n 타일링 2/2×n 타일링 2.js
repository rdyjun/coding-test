const n = require('fs').readFileSync(0)
    .toString()
    .trim();

const arr = [];
arr[1] = 1;
arr[2] = 3;

for (let index = 3; index <= n; index++) {
    arr[index] = (arr[index - 1] + arr[index - 2] * 2) % 10007;
}

console.log(arr[n] % 10007);