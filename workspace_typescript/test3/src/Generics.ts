interface Member <T> {
    name: string
    birthYear: number
    special: T
}

class Observable <T extends Member<string>> {
    subscribe(member: T) {
        console.log(`Subscribed to ${member.name} with ${member.special}`);
    }
}

const john: Member <string> = {
    name: "John",
    birthYear: 18,
    special: "painting"
}
console.log("Member: " + john.name);

new Observable<typeof john>().subscribe(john);
