"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
function getEmail(input) {
    return `${input.firstName}.${input.lastName}.${input.job}@email.com`;
}
function getDetailForPerson(input) {
    var detail = `
            ${input.firstName} ${input.lastName}\n
            Job: ${input.job}\n
            Email: ${getEmail(input)}\n
            Phone: `;
    if (input.phone) {
        detail += input.phone;
    }
    else {
        detail += "N/A";
    }
    return detail;
}
function getDetail(input) {
    if ("firstName" in input && "lastName" in input) {
        return getDetailForPerson(input);
    }
    else {
        return input;
    }
}
function asyncGetDetail() {
    return __awaiter(this, void 0, void 0, function* () {
        return "details";
    });
}
console.log(getDetail({
    firstName: "Joe",
    lastName: "Dawn",
    job: "developer"
}));
console.log(getDetail({
    firstName: "Jack",
    lastName: "Dawe",
    job: "teacher",
    phone: "222-988-4820"
}));
console.log(getDetail({
    name: "C&Y Co.",
    phone: "222-988-4820"
}));
console.log(asyncGetDetail());
