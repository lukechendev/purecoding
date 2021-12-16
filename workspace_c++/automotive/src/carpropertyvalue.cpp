#include <iostream>

#include "include/carpropertyvalue.h"
#include "include/carpropertyids.h"

CarPropertyValue::CarPropertyValue(int id, int value) : id(id), value(value) {
    std::cout << "CarPropertyValue constructor" << std::endl;
}

CarPropertyValue::CarPropertyValue(const CarPropertyValue& prop) {
    std::cout << "CarPropertyValue copy constructor" << std::endl;
    id = prop.id;
    value = prop.value;
}

CarPropertyValue::CarPropertyValue(CarPropertyValue&& prop) {
    std::cout << "CarPropertyValue move constructor" << std::endl;
    id = std::move(prop.id);
    value = std::move(prop.value);
}

CarPropertyValue& CarPropertyValue::operator=(const CarPropertyValue& prop) {
    std::cout << "CarPropertyValue copy assignment" << std::endl;

    if (id == prop.id) {
        value = prop.value;
    }

    return *this;
}

CarPropertyValue& CarPropertyValue::operator=(CarPropertyValue&& prop) {
    std::cout << "CarPropertyValue move assignment" << std::endl;

    if (id == prop.id) {
        value = std::move(prop.value);
    }

    return *this;
}

std::ostream& operator<<(std::ostream& os, const CarPropertyValue& prop) {
    os << CarPropertyIds::ALL.at(prop.id) << "=" << prop.value;
    return os;
}

CarPropertyValue& operator<<(CarPropertyValue& prop, const int newValue) {
    prop.value = newValue;
    return prop;
}

std::istream& operator>>(std::istream& is, CarPropertyValue& prop) {
    is >> prop.value;
    return is;
}

CarPropertyValue& CarPropertyValue::operator+=(const CarPropertyValue& prop) {
    std::cout << "CarPropertyValue +=" << std::endl;
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
