// let cities = [
//     ['Ha Noi','Sai Gon','Da Nang'],
//     ['New York','California','Miami'],
//     ['Tokyo','Nagofa','Osaka'],
//     ['London','Manchester','Liverpool'],
// ];
// for (let i = 0; i < cities.length; i++) {
//     for (let j = 0; j < cities[i].length; j++) {
//         document.write(cities[i][j] + '<br>');
//     }
// }
// let matrix = new Array(10).fill(new Array(10));
// for (let i = 0; i < matrix.length; i++) {
//     for (let j = 0; j < matrix[i].length; j++) {
//         matrix[i][j] = Math.floor((Math.random()*100)+1);
//     }
// }
//console.log(matrix);
let matrix = [
    [1,2,3,4,5,6,7,8,9,10],
    [2,3,4,5,6,7,8,9,10,11],
    [3,4,5,6,7,8,9,10,11,12],
    [4,5,6,7,8,9,10,11,12,13],
    [5,6,7,8,9,10,11,12,13,14],
]

// Gán giá trị cho mảng
for (let row = 0; row < matrix.length; row++) {
    for (let column = 0; column < matrix[row].length; column++) {
        matrix[row][column] = Math.floor((Math.random() * 100) + 1);
    }
}
// console.log(matrix);
document.write(matrix.toString() + "<br>")


// // Hiển thị các phần tử trong mảng
// for (let row = 0; row < matrix.length; row++) {
//     for (let column = 0; column < matrix[row].length; column++) {
//         console.log(matrix[row][column] + '');
//     }
// }

// //Tổng các phần tử trong mảng
// let total = 0;
// for (let row = 0; row < matrix.length; row++) {
//     for (let column = 0; column < matrix[row].length; column++) {
//         total += matrix[row][column];
//     }
// }
// console.log(total)

// //Tổng 1 hàng
// let totalRows = 0;
// for (let row = 0; row < matrix.length; row++) {
//     for (let column = 0; column < matrix[row].length; column++) {
//         totalRows += matrix[row][column];
//     }
//     console.log(totalRows);
//     totalRows = 0;
// }

//Tổng 1 cột
// let totalColums = 0;
// let row = 0;
// for (let column = 0; column < matrix[row].length; column++) {
//     for (let row = 0; row < matrix.length; row++) {
//         totalColums += matrix[row][column];
//     }
//     console.log(totalColums);
//     totalColums = 0;
// }

// //Tìm hàng có tổng lớn nhất
// let maxRow = 0;
// let inDexOfMaxRow = 0;
// var row = 0;
// for (let column = 0; column < matrix[0].length; column++) {
//     maxRow += matrix[0][column];
// }
// for (row = 1; row < matrix.length; row++) {
//     let totalOfThisRow = 0;
//     for (let column = 0; column < matrix[row].length; column++) {
//         totalOfThisRow += matrix[row][column];
//     }
//     if (totalOfThisRow > maxRow) {
//         maxRow = totalOfThisRow;
//         inDexOfMaxRow = row;
//     }
// }
// console.log('Hàng ' + inDexOfMaxRow + ' có tổng lớn nhất là: ' + maxRow);

//Trộn ngẫu nhiên các phần tử
// for (let i = 0; i < matrix.length; i++) {
//     for (let j = 0; j < matrix[i].length; j++) {
//         let i1 = +Math.floor(Math.random()*matrix.length);
//         let j1 = +Math.floor(Math.random()*matrix[i].length);
//         console.log(i1, j1)
//         let temp = matrix[i][j];
//         console.log("temp: " + temp)
//         matrix[i][j] = matrix[i1][j1];
//         console.log("matrix cua " + i + "va" + j + "la " + matrix[i][j])
//         matrix[i1][j1] = temp;
//         console.log("matrix cua " + i1 + "va" + j1 + "la " + matrix[i1][j1])
//         break
//     }
// }
// console.log(matrix);
// document.write(matrix.toString())
var x = 0;

for (var i=1; i<4; i++)
{
    x = x + i;
    console.log(x);
    console.log(i);
}