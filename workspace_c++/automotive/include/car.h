#ifndef CAR_H
#define CAR_H

#include "carmanagerbase.h"

using namespace std;

enum class CarService {
    Property,
    Audio,
    Bluetooth,
    Navigation
};

class Car {
public:
    Car();
    CarManagerBase* getCarManager(CarService service);
};

#endif // CAR_H
