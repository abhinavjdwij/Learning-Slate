const a : string = "1";
console.log(a);

type ID = string | number; // type alias

interface PersonInterface {
    id : ID;
    name : string,
    age? : number, // ? means not mandatory
    married?: boolean 
    address : string | null; // union
    getMessage() : string;
}

let p1 : PersonInterface = {
    id : "1",
    name: "Abhinav",
    getMessage() {
        return "Hello, " + p1.name;
    },
    address: null
}

let p2 : PersonInterface = {
    id : 2,
    name: "John",
    getMessage() {
        return "Hi, " + p1.name;
    },
    address: null
}

const idList : ID[] = [];
idList.push("1");
idList.push(2);
// idList.push(true); // error