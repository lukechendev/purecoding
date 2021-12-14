#ifndef CAR_H
#define CAR_H

#include "carmanagerbase.h"

enum class CarManagerType {
    Property,
    Audio,
    Bluetooth,
    Navigation
};

class Car {
public:
    Car();
    CarManagerBase* getCarManager(CarManagerType type);
};

#endif // CAR_H
