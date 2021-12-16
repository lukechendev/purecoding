#include <iostream>
#include <limits>

#include "include/car.h"
#include "include/carpropertymanager.h"
#include "include/carpropertyids.h"

// prop is copied in parameter and moved in return
CarPropertyValue f(CarPropertyValue prop) {
    return prop;
}

void listProperties(CarPropertyManager& propManager) {
    // list all properties
    std::cout << "***list all properties***********************" << std::endl;
    for (const auto& prop : CarPropertyIds::ALL) {
        auto propId = prop.first;
        auto propStr = prop.second;
        auto propValue = propManager.getProperty(propId).getValue();
        std::cout << propStr << "=" << propValue << std::endl;
    }
}

void testConstructors(CarPropertyManager& propManager) {
    // copy construct property
    std::cout << "***copy construct property***********************" << std::endl;
    CarPropertyValue cp1(propManager.getProperty(CarPropertyIds::INFO_VIN));
    std::cout << cp1 << std::endl;

    // move construct property
    std::cout << "***move construct property***********************" << std::endl;
    CarPropertyValue cp2(std::move(propManager.getProperty((CarPropertyIds::ENGINE_OIL_LEVEL))));
    std::cout << cp2 << std::endl;

    // conversion construct property
    std::cout << "***conversion construct property***********************" << std::endl;
    std::pair<int, int> pair(CarPropertyIds::FUEL_LEVEL, 3);
    CarPropertyValue cp3(pair);
    std::cout << cp3 << std::endl;

    std::cout << "**************************" << std::endl;
}

void testOperators(CarPropertyManager& propManager) {
    // copy construct property
    std::cout << "***copy construct property***********************" << std::endl;
    CarPropertyValue cp1(propManager.getProperty(CarPropertyIds::INFO_VIN));

    // move construct property
    std::cout << "***move construct property***********************" << std::endl;
    CarPropertyValue cp2(std::move(propManager.getProperty((CarPropertyIds::ENGINE_OIL_LEVEL))));
    std::cout << cp2 << std::endl;

    // property copy assignment
    std::cout << "***property copy assignment***********************" << std::endl;
    CarPropertyValue cp1copy(CarPropertyIds::INFO_VIN, 0);
    cp1copy = cp1;
    std::cout << "cp1: " << cp1.getValue() << "; cp1copy: " << cp1copy.getValue() << std::endl;

    // property move assignment
    std::cout << "***property move assignment***********************" << std::endl;
    CarPropertyValue cp2move(CarPropertyIds::INFO_VIN, 0);
    cp2move = std::move(cp1copy);
    // Warning: Method called on moved-from object 'cp1copy'
    std::cout << "cp1copy: " << cp1copy.getValue() << "; cp2move: " << cp2move.getValue() << std::endl;

    // property copy & move via f()
    std::cout << "***property move via f()***********************" << std::endl;
    CarPropertyValue cp3move(CarPropertyIds::INFO_VIN, 0);
    cp3move = f(cp2move);
    std::cout << "cp2move: " << cp2move.getValue() << "; cp3move: " << cp3move.getValue() << std::endl;

    // property operator ostream <<
    std::cout << "***property operator ostream <<***********************" << std::endl;
    std::cout << cp1 << std::endl;

    // property operator << int
    std::cout << "***property operator << int***********************" << std::endl;
    cp1 << std::numeric_limits<int>::max();
    std::cout << cp1 << std::endl;

    // property operator << double
    std::cout << "***property operator << double***********************" << std::endl;
    cp1 << 3.234;
    std::cout << cp1 << std::endl;

    // property operator istream >>
    std::cout << "***property operator istream >>***********************" << std::endl;
    // cin >> cp1; // uncomment to execute
    std::cout << cp1 << std::endl;

    // property operator int >>
    std::cout << "***property operator int >>***********************" << std::endl;
    333 >> cp1;
    std::cout << cp1 << std::endl;

    // property operator +=
    std::cout << "***property operator +=***********************" << std::endl;
    CarPropertyValue cp1more(CarPropertyIds::INFO_VIN, 100);
    cp1 += cp1more;
    cp1.operator+=(cp1more); // explicit operator call
    std::cout << cp1 << std::endl;

    // property operator += int
    std::cout << "***property operator +=***********************" << std::endl;
    cp1 += 100;
    cp1.operator+=(100); // explicit operator call
    std::cout << cp1 << std::endl;

    // property operator conversion int
    std::cout << "***property operator conversion int***********************" << std::endl;
    int theValue(cp1);
    std::cout << theValue << std::endl;

    std::cout << "**************************" << std::endl;
}

int main()
{
    Car car = Car();
    CarPropertyManager* propManager = (CarPropertyManager*) car.getCarManager(CarManagerType::Property);

    listProperties(*propManager);
    testConstructors(*propManager);
    testOperators(*propManager);

    delete propManager;
    return 0;
}

