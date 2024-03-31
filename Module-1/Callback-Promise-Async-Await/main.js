let courses = ['Javascript', 'PHP', 'Ruby'];

Array.prototype.map2 = function(callback) {
    let arrayLength = this.length;
    let output = [];
    for (let i = 0; i < arrayLength; i++) {
        let html = callback(this[i])
        output.push(html);
    }
    return output;
} 

let htmls = courses.map2(function(course) {
    return `<h2>${course}</h2>`
})

console.log(htmls)