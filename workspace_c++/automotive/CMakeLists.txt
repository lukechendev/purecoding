cmake_minimum_required(VERSION 3.5)

project(automotive VERSION 1.0 LANGUAGES CXX)

set(CMAKE_INCLUDE_CURRENT_DIR ON)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

set(SOURCES
    src/car.cpp
    src/carpropertymanager.cpp
    src/main.cpp
)

set(HEADERS
    include/car.h
    include/carpropertymanager.h
)

add_executable(
    car
    ${SOURCES}
    ${HEADERS}
)

target_include_directories(car PRIVATE
    ${HEADERS}
)
