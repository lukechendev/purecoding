#ifndef CARSERVICE_H
#define CARSERVICE_H

#include <unordered_map>

#include "carpropertyvalue.h"

class CarService {

public:
    CarPropertyValue getProperty(const int propId) const;
    void setProperty(const int propId, const int propValue);

private:
    CarService();

    friend class CarPropertyManager;

    void fetchProperties();

    std::unordered_map<int, CarPropertyValue> props;

    bool ready = false;
};

#endif // CARSERVICE_H
