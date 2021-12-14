cmake_minimum_required(VERSION 3.5)

project(automotive VERSION 1.0 LANGUAGES CXX)

set(CMAKE_INCLUDE_CURRENT_DIR ON)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

set(SOURCES
    src/car.cpp
    src/carmanagerbase.cpp
    src/carpropertymanager.cpp
    src/carpropertyvalue.cpp
    src/carservice.cpp
    src/main.cpp
)

set(HEADERS
    include/car.h
    include/carmanagerbase.h
    include/carpropertymanager.h
    include/carpropertyvalue.h
    include/carservice.h
    include/carpropertyids.h
)

add_executable(
    car
    ${SOURCES}
    ${HEADERS}
)

target_include_directories(car PRIVATE
    ${HEADERS}
)
