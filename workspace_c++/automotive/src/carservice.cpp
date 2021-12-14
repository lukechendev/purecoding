#include <iostream>

#include "include/carservice.h"
#include "include/carpropertyvalue.h"

CarService::CarService() {
    cout << "CarService constructor" << endl;

    // TODO: fetch in a background thread
    fetchProperties();
    ready = true;
}

CarPropertyValue CarService::getProperty(const int propId) const {
    auto prop = props.find(propId);
    if (prop != props.end()) {
        return props.at(propId);
    }

    return CarPropertyValue(propId, 0);
}

void CarService::setProperty(const int propId, const int propValue) {
    auto prop = props.find(propId);
    if (prop != props.end()) {
        prop->second = std::move(CarPropertyValue(propId, propValue));
    } else {
        // TODO: is there a way to avoid copy?
        // CarPropertyValue constructor
        // CarPropertyValue copy constructor
        props.emplace(propId, CarPropertyValue(propId, propValue));
    }
}

void CarService::fetchProperties() {
    setProperty(1, 1);
    setProperty(1, 2);
}
