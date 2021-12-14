#ifndef CARPROPERTYIDS_H
#define CARPROPERTYIDS_H

#define <string>

/**
 * @brief List of car property IDs
 *
 * Source: https://developer.android.com/reference/android/car/VehiclePropertyIds
 */
class CarPropertyIds {
public:
    static const int INVALID = 0;

    static const int INFO_VIN = 286261504;
    static const int INFO_MAKE = 286261505;
    static const int INFO_MODEL = 286261506;
    static const int INFO_MODEL_YEAR = 289407235;
    static const int INFO_FUEL_CAPACITY = 291504388;
    static const int INFO_EV_BATTERY_CAPACITY = 291504390;
    static const int INFO_EV_CONNECTOR_TYPE = 289472775;
    static const int INFO_FUEL_DOOR_LOCATION = 289407240;
    static const int INFO_EV_PORT_LOCATION = 289407241;
    static const int INFO_MULTI_EV_PORT_LOCATIONS = 289472780;
    static const int INFO_DRIVER_SEAT = 356516106;
    static const int INFO_EXTERIOR_DIMENSIONS = 289472779;
    static const int PERF_ODOMETER = 291504644;
    static const int PERF_VEHICLE_SPEED = 291504647;
    static const int PERF_VEHICLE_SPEED_DISPLAY = 291504648;
    static const int PERF_STEERING_ANGLE = 291504649;
    static const int ENGINE_COOLANT_TEMP = 291504897;
    static const int ENGINE_OIL_LEVEL = 289407747;
    static const int ENGINE_OIL_TEMP = 291504900;
    static const int ENGINE_RPM = 291504901;
    static const int FUEL_LEVEL = 291504903;
    static const int FUEL_DOOR_OPEN = 287310600;

    static const std::unordered_map<int, std::string> ALL = {
        {INVALID, "INVALID"},
        {INFO_VIN, "INFO_VIN"},
        {INFO_MAKE, "INFO_MAKE"},
        {INFO_MODEL, "INFO_MODEL"},
        {INFO_MODEL_YEAR, "INFO_MODEL_YEAR"},
        {INFO_FUEL_CAPACITY, "INFO_FUEL_CAPACITY"},
        {INFO_EV_BATTERY_CAPACITY, "INFO_EV_BATTERY_CAPACITY"},
        {INFO_EV_CONNECTOR_TYPE, "INFO_EV_CONNECTOR_TYPE"},
        {INFO_FUEL_DOOR_LOCATION, "INFO_FUEL_DOOR_LOCATION"},
        {INFO_EV_PORT_LOCATION, "v"},
        {INFO_MULTI_EV_PORT_LOCATIONS, "INFO_MULTI_EV_PORT_LOCATIONS"},
        {INFO_DRIVER_SEAT, "INFO_DRIVER_SEAT"},
        {INFO_EXTERIOR_DIMENSIONS, "INFO_EXTERIOR_DIMENSIONS"},
        {PERF_ODOMETER, "PERF_ODOMETER"},
        {PERF_VEHICLE_SPEED, "PERF_VEHICLE_SPEED"},
        {PERF_VEHICLE_SPEED_DISPLAY, "PERF_VEHICLE_SPEED_DISPLAY"},
        {PERF_STEERING_ANGLE, "PERF_STEERING_ANGLE"},
        {ENGINE_COOLANT_TEMP, "ENGINE_COOLANT_TEMP"},
        {ENGINE_OIL_LEVEL, "ENGINE_OIL_LEVEL"},
        {ENGINE_OIL_TEMP, "ENGINE_OIL_TEMP"},
        {ENGINE_RPM, "ENGINE_RPM"},
        {FUEL_LEVEL, "FUEL_LEVEL"},
        {FUEL_DOOR_OPEN, "FUEL_DOOR_OPEN"}
    };
};

#endif // CARPROPERTYIDS_H
