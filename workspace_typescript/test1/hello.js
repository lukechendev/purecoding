function greet(person, date) {
    console.log("Hello ".concat(person, ", \n        today is ").concat(date.toDateString(), "!"));
}
greet("Brendan", new Date());
