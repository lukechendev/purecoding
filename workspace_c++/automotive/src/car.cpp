#include <iostream>

#include "include/car.h"
#include "include/carmanagerbase.h"
#include "include/carpropertymanager.h"

using namespace std;

Car::Car() {
    cout << "Car constructor" << endl;
}

CarManagerBase* Car::getCarManager(CarManagerType type) {
    switch (type) {
        case CarManagerType::Property: {
            return new CarPropertyManager();
        }
        case CarManagerType::Navigation: {
            return nullptr;
        }
        case CarManagerType::Audio: {
            return nullptr;
        }
        case CarManagerType::Bluetooth: {
            return nullptr;
        }
        default: {
            return nullptr;
        }
    }

    return nullptr;
}
