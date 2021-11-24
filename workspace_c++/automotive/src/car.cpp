#include <iostream>

#include "include/car.h"
#include "include/carmanagerbase.h"
#include "include/carpropertymanager.h"

using namespace std;

Car::Car() {
    cout << "Car constructor" << endl;
}

CarManagerBase* Car::getCarManager(CarService service) {
    switch(service) {
        case CarService::Property: {
            return new CarPropertyManager();
        }
        case CarService::Navigation: {
            return nullptr;
        }
        default: {
            return nullptr;
        }
    }

    return nullptr;
}
