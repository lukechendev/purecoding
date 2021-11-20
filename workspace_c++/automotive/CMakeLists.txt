cmake_minimum_required(VERSION 3.5)

project(automotive VERSION 1.0)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

set(SOURCES
    src/Car.cpp
    src/main.cpp
)

set(HEADERS
    include/Car.h
)

add_executable(car ${SOURCES})

target_include_directories(car PUBLIC
    ${HEADERS}
)
