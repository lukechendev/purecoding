#ifndef CARPROPERTYIDS_H
#define CARPROPERTYIDS_H

#include <string>
#include <unordered_map>

/**
 * @brief List of car property IDs
 *
 * Source: https://developer.android.com/reference/android/car/VehiclePropertyIds
 */
class CarPropertyIds {
public:
    static const int INVALID = 0;

    static const int INFO_VIN;
    static const int INFO_MAKE;
    static const int INFO_MODEL;
    static const int INFO_MODEL_YEAR;
    static const int INFO_FUEL_CAPACITY;
    static const int INFO_EV_BATTERY_CAPACITY;
    static const int INFO_EV_CONNECTOR_TYPE;
    static const int INFO_FUEL_DOOR_LOCATION;
    static const int INFO_EV_PORT_LOCATION;
    static const int INFO_MULTI_EV_PORT_LOCATIONS;
    static const int INFO_DRIVER_SEAT;
    static const int INFO_EXTERIOR_DIMENSIONS;
    static const int PERF_ODOMETER;
    static const int PERF_VEHICLE_SPEED;
    static const int PERF_VEHICLE_SPEED_DISPLAY;
    static const int PERF_STEERING_ANGLE;
    static const int ENGINE_COOLANT_TEMP;
    static const int ENGINE_OIL_LEVEL;
    static const int ENGINE_OIL_TEMP;
    static const int ENGINE_RPM;
    static const int FUEL_LEVEL;
    static const int FUEL_DOOR_OPEN;

    static const std::unordered_map<int, std::string> ALL;
};

#endif // CARPROPERTYIDS_H
