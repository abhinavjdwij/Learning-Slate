var a = "1";
console.log(a);
var p1 = {
    id: "1",
    name: "Abhinav",
    getMessage: function () {
        return "Hello, " + p1.name;
    },
    address: null
};
var p2 = {
    id: 2,
    name: "John",
    getMessage: function () {
        return "Hi, " + p1.name;
    },
    address: null
};
var idList = [];
idList.push("1");
idList.push(2);
// idList.push(true); // error
