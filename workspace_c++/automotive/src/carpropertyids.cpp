#include <unordered_map>
#include <string>

#include "include/carpropertyids.h"

const int CarPropertyIds::INFO_VIN = 286261504;
const int CarPropertyIds::INFO_MAKE = 286261505;
const int CarPropertyIds::INFO_MODEL = 286261506;
const int CarPropertyIds::INFO_MODEL_YEAR = 289407235;
const int CarPropertyIds::INFO_FUEL_CAPACITY = 291504388;
const int CarPropertyIds::INFO_EV_BATTERY_CAPACITY = 291504390;
const int CarPropertyIds::INFO_EV_CONNECTOR_TYPE = 289472775;
const int CarPropertyIds::INFO_FUEL_DOOR_LOCATION = 289407240;
const int CarPropertyIds::INFO_EV_PORT_LOCATION = 289407241;
const int CarPropertyIds::INFO_MULTI_EV_PORT_LOCATIONS = 289472780;
const int CarPropertyIds::INFO_DRIVER_SEAT = 356516106;
const int CarPropertyIds::INFO_EXTERIOR_DIMENSIONS = 289472779;
const int CarPropertyIds::PERF_ODOMETER = 291504644;
const int CarPropertyIds::PERF_VEHICLE_SPEED = 291504647;
const int CarPropertyIds::PERF_VEHICLE_SPEED_DISPLAY = 291504648;
const int CarPropertyIds::PERF_STEERING_ANGLE = 291504649;
const int CarPropertyIds::ENGINE_COOLANT_TEMP = 291504897;
const int CarPropertyIds::ENGINE_OIL_LEVEL = 289407747;
const int CarPropertyIds::ENGINE_OIL_TEMP = 291504900;
const int CarPropertyIds::ENGINE_RPM = 291504901;
const int CarPropertyIds::FUEL_LEVEL = 291504903;
const int CarPropertyIds::FUEL_DOOR_OPEN = 287310600;

const std::unordered_map<int, std::string> CarPropertyIds::ALL = {
    {CarPropertyIds::INFO_VIN, "INFO_VIN"},
    {CarPropertyIds::INFO_MAKE, "INFO_MAKE"},
    {CarPropertyIds::INFO_MODEL, "INFO_MODEL"},
    {CarPropertyIds::INFO_MODEL_YEAR, "INFO_MODEL_YEAR"},
    {CarPropertyIds::INFO_FUEL_CAPACITY, "INFO_FUEL_CAPACITY"},
    {CarPropertyIds::INFO_EV_BATTERY_CAPACITY, "INFO_EV_BATTERY_CAPACITY"},
    {CarPropertyIds::INFO_EV_CONNECTOR_TYPE, "INFO_EV_CONNECTOR_TYPE"},
    {CarPropertyIds::INFO_FUEL_DOOR_LOCATION, "INFO_FUEL_DOOR_LOCATION"},
    {CarPropertyIds::INFO_EV_PORT_LOCATION, "INFO_EV_PORT_LOCATION"},
    {CarPropertyIds::INFO_MULTI_EV_PORT_LOCATIONS, "INFO_MULTI_EV_PORT_LOCATIONS"},
    {CarPropertyIds::INFO_DRIVER_SEAT, "INFO_DRIVER_SEAT"},
    {CarPropertyIds::INFO_EXTERIOR_DIMENSIONS, "INFO_EXTERIOR_DIMENSIONS"},
    {CarPropertyIds::PERF_ODOMETER, "PERF_ODOMETER"},
    {CarPropertyIds::PERF_VEHICLE_SPEED, "PERF_VEHICLE_SPEED"},
    {CarPropertyIds::PERF_VEHICLE_SPEED_DISPLAY, "PERF_VEHICLE_SPEED_DISPLAY"},
    {CarPropertyIds::PERF_STEERING_ANGLE, "PERF_STEERING_ANGLE"},
    {CarPropertyIds::ENGINE_COOLANT_TEMP, "ENGINE_COOLANT_TEMP"},
    {CarPropertyIds::ENGINE_OIL_LEVEL, "ENGINE_OIL_LEVEL"},
    {CarPropertyIds::ENGINE_OIL_TEMP, "ENGINE_OIL_TEMP"},
    {CarPropertyIds::ENGINE_RPM, "ENGINE_RPM"},
    {CarPropertyIds::FUEL_LEVEL, "FUEL_LEVEL"},
    {CarPropertyIds::FUEL_DOOR_OPEN, "FUEL_DOOR_OPEN"}
};
