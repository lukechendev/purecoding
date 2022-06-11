
interface Person {
    firstName: string;
    lastName: string;
    job: Job;
    phone?: string;
}

type Job = "teacher" | "developer" | "engineer";

function getEmail(input: Person) {
    return `${input.firstName}.${input.lastName}.${input.job}@email.com`;
}

function getDetailForPerson(input: Person) {
    var detail = `
            ${input.firstName} ${input.lastName}\n
            Job: ${input.job}\n
            Email: ${getEmail(input)}\n
            Phone: `;

    if (input.phone) {
        detail += input.phone;
    } else {
        detail += "N/A";
    }

    return detail;
}

function getDetail(input: any) {
    if ("firstName" in input && "lastName" in input) {
        return getDetailForPerson(input);
    } else {
        return input;
    }
}

console.log(getDetail({
    firstName: "Joe",
    lastName: "Dawn",
    job: "developer"
}))

console.log(getDetail({
    firstName: "Jack",
    lastName: "Dawe",
    job: "teacher",
    phone: "222-988-4820"
}))

console.log(getDetail({
    name: "C&Y Co.",
    phone: "222-988-4820"
}))