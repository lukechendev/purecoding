#include <iostream>

#include "include/carpropertyvalue.h"

using namespace std;

CarPropertyValue::CarPropertyValue(int id, int value) : id(id), value(value) {
    cout << "CarPropertyValue constructor" << endl;
}

CarPropertyValue::CarPropertyValue(const CarPropertyValue& prop) {
    cout << "CarPropertyValue copy constructor" << endl;
    id = prop.id;
    value = prop.value;
}

CarPropertyValue& CarPropertyValue::operator=(const CarPropertyValue& prop) {
    cout << "CarPropertyValue copy =" << endl;

    if (id == prop.id) {
        value = prop.value;
    }

    return *this;
}

CarPropertyValue& CarPropertyValue::operator=(CarPropertyValue&& prop) {
    cout << "CarPropertyValue move =" << endl;

    if (id == prop.id) {
        value = move(prop.value);
    }

    return *this;
}

CarPropertyValue& CarPropertyValue::operator+=(const CarPropertyValue& prop) {
    cout << "CarPropertyValue +=" << endl;
    if (id == prop.id) {
        value += prop.value;
    }

    return *this;
}

int CarPropertyValue::getId() const {
    return id;
}

int CarPropertyValue::getValue() const {
    return value;
}
