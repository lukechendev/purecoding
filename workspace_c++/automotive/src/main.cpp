#include <iostream>

#include "include/car.h"
#include "include/carpropertymanager.h"

using namespace std;

int main()
{
    Car car = Car();
    CarPropertyManager* propManager = (CarPropertyManager*) car.getCarManager(CarManagerType::Property);

    delete propManager;
    return 0;
}

