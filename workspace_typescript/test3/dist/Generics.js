"use strict";
class Observable {
    subscribe(member) {
        console.log(`Subscribed to ${member.name} with ${member.special}`);
    }
}
const john = {
    name: "John",
    birthYear: 18,
    special: "painting"
};
console.log("Member: " + john.name);
new Observable().subscribe(john);
