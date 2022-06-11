function getEmail(input) {
    return "".concat(input.firstName, ".").concat(input.lastName, ".").concat(input.job, "@email.com");
}
function getDetail(input) {
    var detail = "\n            ".concat(input.firstName, " ").concat(input.lastName, "\n\n            Job: ").concat(input.job, "\n\n            Email: ").concat(getEmail(input), "\n\n            Phone: ");
    if (input.phone) {
        detail += input.phone;
    }
    else {
        detail += "N/A";
    }
    return detail;
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
