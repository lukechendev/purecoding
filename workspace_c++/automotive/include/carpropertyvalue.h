#ifndef CARPROPERTYVALUE_H
#define CARPROPERTYVALUE_H

class CarPropertyValue {
public:
    CarPropertyValue() =  delete;

    explicit CarPropertyValue(int id, int value);

    // copy
    CarPropertyValue(const CarPropertyValue& prop);

    // operator = copy
    CarPropertyValue& operator=(const CarPropertyValue& prop);

    // operator = move
    CarPropertyValue& operator=(CarPropertyValue&& prop);

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