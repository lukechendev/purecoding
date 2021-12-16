#include <iostream>

#include "include/car.h"
#include "include/carpropertymanager.h"
#include "include/carpropertyids.h"

using namespace std;

int main()
{
    Car car = Car();
    CarPropertyManager* propManager = (CarPropertyManager*) car.getCarManager(CarManagerType::Property);

    // list all properties
    cout << "**************************" << endl;
    for (const auto& prop : CarPropertyIds::ALL) {
        auto propId = prop.first;
        auto propStr = prop.second;
        auto propValue = propManager->getProperty(propId).getValue();
        cout << propStr << "=" << propValue << endl;
    }

    // copy construct property
    cout << "**************************" << endl;
    CarPropertyValue cp1(propManager->getProperty(CarPropertyIds::INFO_VIN));

    // move construct property
    cout << "**************************" << endl;
    CarPropertyValue cp2(std::move(propManager->getProperty((CarPropertyIds::ENGINE_OIL_LEVEL))));

    // property copy assignment
    cout << "**************************" << endl;
    CarPropertyValue cp1copy(CarPropertyIds::INFO_VIN, 0);
    cp1copy = cp1;
    cout << "cp1: " << cp1.getValue() << "; cp1copy: " << cp1copy.getValue() << endl;

    // property move assignment
    cout << "**************************" << endl;
    CarPropertyValue cp2move(CarPropertyIds::INFO_VIN, 0);
    cp2move = std::move(cp1copy);
    cout << "cp1copy: " << cp1copy.getValue() << "; cp2move: " << cp2move.getValue() << endl;

    cout << "**************************" << endl;

    delete propManager;
    return 0;
}

