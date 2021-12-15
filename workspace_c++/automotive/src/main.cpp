#include <iostream>

#include "include/car.h"
#include "include/carpropertymanager.h"
#include "include/carpropertyids.h"

using namespace std;

int main()
{
    Car car = Car();
    CarPropertyManager* propManager = (CarPropertyManager*) car.getCarManager(CarManagerType::Property);

    cout << "**************************" << endl;
    for (const auto& prop : CarPropertyIds::ALL) {
        auto propId = prop.first;
        auto propStr = prop.second;
        auto propValue = propManager->getProperty(propId).getValue();
        cout << propStr << "=" << propValue << endl;
    }
    cout << "**************************" << endl;

    delete propManager;
    return 0;
}

