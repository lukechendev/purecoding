const a = "hello!";
console.log(a);

var b = 5;
console.log(b);

var testArr: any[] = [];
testArr.push(a);
testArr.push(b);
console.log(testArr);

var strArr: string[] = [];
strArr.push(a);
strArr.push(b as any);
console.log(strArr);