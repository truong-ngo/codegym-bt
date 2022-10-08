function square(number) {
    let result = number**2;
    return result;
}
function calSquare() {
    let num = document.getElementById('input').value;
    let result = square(num);
    document.getElementById('result').innerText = result;
}

// function myFunction() {
//     let firstArg = arguments[0];
//     let secondArg = arguments[1];
//     alert("firstArg is: " + firstArg);
//     alert("secondArg is: " + secondArg);
// }
// myFunction("hello","world");

function logF(arg1,arg2) {
    console.log(arg1)
    console.log(arg2)
    return true;
}
logF("hello","world");

// let aNewVariable = "is global.";
// function doSomething(incomingBits) {
//     alert("Global variable within the function: " + aNewVariable); //is global.
//     alert("Local variable within the function: " + incomingBits);  //is a local variable
// }
// doSomething("is a local variable");
// alert("Global var outside the function: " + aNewVariable);
// alert("Local var outside the function: " + incomingBits); // incomingBits chỉ tồn tại trong hàm

function myFunction() {
    let myNum = 10;
    function showNum() {
        alert(myNum);
    }
    return showNum();
}
let callFunc = myFunction();
myFunction();

for(var i=9; i<=20; i++) {
    if(i == 10)
    {
        break;
    }
    else
    {
        console.log('hello');
    }

    console.log(i);
}