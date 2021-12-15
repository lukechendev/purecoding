#ifndef CARPROPERTYMANAGER_H
#define CARPROPERTYMANAGER_H

#include "carmanagerbase.h"
#include "carpropertyvalue.h"
#include "carservice.h"

class CarPropertyManager : public CarManagerBase {
public:
    CarPropertyValue getProperty(const int propId) const;
    void setProperty(const CarPropertyValue prop);

private:
    CarPropertyManager();

    friend class Car;

    CarService carService;
};

#endif // CARPROPERTYMANAGER_H
