#ifndef CARPROPERTYVALUE_H
#define CARPROPERTYVALUE_H

#include <iostream>

class CarPropertyValue {
public:
    CarPropertyValue() =  delete;

    explicit CarPropertyValue(int id, int value);

    // copy
    CarPropertyValue(const CarPropertyValue& prop);

    // move
    CarPropertyValue(CarPropertyValue&& prop);

    // operator copy assignment
    CarPropertyValue& operator=(const CarPropertyValue& prop);

    // operator move assignment
    CarPropertyValue& operator=(CarPropertyValue&& prop);

    // operator <<
    friend std::ostream& operator<<(std::ostream& os, const CarPropertyValue& prop);

    // operator <<
    friend CarPropertyValue& operator<<(CarPropertyValue& prop, const int newValue);

    // operator >>
    friend std::istream& operator>>(std::istream& is, CarPropertyValue& prop);

    // operator +=
    CarPropertyValue& operator+=(const CarPropertyValue& prop);
//    friend CarPropertyValue& operator+=(CarPropertyValue& p1, CarPropertyValue& p2);

    // operator <<

    int getId() const;
    int getValue() const;

private:
    int id;
    int value;
};

#endif // CARPROPERTYVALUE_H
