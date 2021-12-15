#include "iostream"

#include "include/carpropertymanager.h"

using namespace std;

CarPropertyManager::CarPropertyManager() : CarManagerBase() {
    cout << "CarPropertyManager constructor" << endl;
}

CarPropertyValue CarPropertyManager::getProperty(const int propId) const {
    return carService.getProperty(propId);
}
void CarPropertyManager::setProperty(const CarPropertyValue prop) {
    carService.setProperty(prop.getId(), prop.getValue());
}
