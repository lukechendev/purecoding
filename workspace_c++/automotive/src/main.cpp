#include <iostream>

#include "include/car.h"
#include "include/carpropertymanager.h"

using namespace std;

int main()
{
    Car car = Car();
    CarPropertyManager* propertyManager = (CarPropertyManager*) car.getCarManager(CarService::Property);
    delete propertyManager;
    return 0;
}
