#include <iostream>
#include <limits>

#include "include/car.h"
#include "include/carpropertymanager.h"
#include "include/carpropertyids.h"

using namespace std;

// prop is copied in parameter and moved in return
CarPropertyValue f(CarPropertyValue prop) {
    return prop;
}

int main()
{
    Car car = Car();
    CarPropertyManager* propManager = (CarPropertyManager*) car.getCarManager(CarManagerType::Property);

    // list all properties
    cout << "***list all properties***********************" << endl;
    for (const auto& prop : CarPropertyIds::ALL) {
        auto propId = prop.first;
        auto propStr = prop.second;
        auto propValue = propManager->getProperty(propId).getValue();
        cout << propStr << "=" << propValue << endl;
    }

    // copy construct property
    cout << "***copy construct property***********************" << endl;
    CarPropertyValue cp1(propManager->getProperty(CarPropertyIds::INFO_VIN));

    // move construct property
    cout << "***move construct property***********************" << endl;
    CarPropertyValue cp2(std::move(propManager->getProperty((CarPropertyIds::ENGINE_OIL_LEVEL))));

    // property copy assignment
    cout << "***property copy assignment***********************" << endl;
    CarPropertyValue cp1copy(CarPropertyIds::INFO_VIN, 0);
    cp1copy = cp1;
    cout << "cp1: " << cp1.getValue() << "; cp1copy: " << cp1copy.getValue() << endl;

    // property move assignment
    cout << "***property move assignment***********************" << endl;
    CarPropertyValue cp2move(CarPropertyIds::INFO_VIN, 0);
    cp2move = std::move(cp1copy);
    // Warning: Method called on moved-from object 'cp1copy'
    cout << "cp1copy: " << cp1copy.getValue() << "; cp2move: " << cp2move.getValue() << endl;

    // property copy & move via f()
    cout << "***property move via f()***********************" << endl;
    CarPropertyValue cp3move(CarPropertyIds::INFO_VIN, 0);
    cp3move = f(cp2move);
    cout << "cp2move: " << cp2move.getValue() << "; cp3move: " << cp3move.getValue() << endl;

    // property operator ostream <<
    cout << "***property operator ostream <<***********************" << endl;
    cout << cp1 << endl;

    // property operator << int
    cout << "***property operator << int***********************" << endl;
    cp1 << std::numeric_limits<int>::max();
    cout << cp1 << endl;

    // property operator istream >>
    cout << "***property operator istream >>***********************" << endl;
    // cin >> cp1; // uncomment to execute
    cout << cp1 << endl;

    // property operator int >>
    cout << "***property operator int >>***********************" << endl;
    333 >> cp1;
    cout << cp1 << endl;

    // property operator +=
    cout << "***property operator +=***********************" << endl;
    CarPropertyValue cp1more(CarPropertyIds::INFO_VIN, 100);
    cp1 += cp1more;
    cout << cp1 << endl;

    // property operator += int
    cout << "***property operator +=***********************" << endl;
    cp1 += 100;
    cout << cp1 << endl;

    cout << "**************************" << endl;

    delete propManager;
    return 0;
}

