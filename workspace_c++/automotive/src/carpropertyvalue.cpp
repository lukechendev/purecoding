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
        prop.value = 0;
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

CarPropertyValue& operator>>(const int newValue, CarPropertyValue& prop) {
    prop.value = newValue;
    return prop;
}

CarPropertyValue& CarPropertyValue::operator+=(const CarPropertyValue& prop) {
    std::cout << "CarPropertyValue += member" << std::endl;
    if (id == prop.id) {
        value += prop.value;
    }

    return *this;
}

CarPropertyValue& operator+=(CarPropertyValue& p1, CarPropertyValue& p2) {
    std::cout << "CarPropertyValue += non-member" << std::endl;
    if (p1.id == p2.id) {
        p1.value += p2.value;
    }

    return p1;
}

CarPropertyValue& CarPropertyValue::operator+=(const int more) {
    value += more;
    return *this;
}

int CarPropertyValue::getId() const {
    return id;
}

int CarPropertyValue::getValue() const {
    return value;
}
