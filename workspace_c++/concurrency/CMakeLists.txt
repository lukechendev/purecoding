cmake_minimum_required(VERSION 3.0)

set(CMAKE_BUILD_TYPE Debug)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -pthread -lpthread -std=c++14 -Wall -Wextra -Werror")

set(CMAKE_CXX_FLAGS_DEBUG "${CMAKE_CXX_FLAGS_DEBUG} -pthread -lpthread -std=c++14 -Wall -Wextra -Werror")
set(CMAKE_CXX_FLAGS_RELEASE "${CMAKE_CXX_FLAGS_RELEASE} -pthread -lpthread -std=c++14 -Wall -Wextra -Werror")

project(concurrency)

add_executable(
  spinLock
  spinLock.cpp
)

add_executable(
  mutex
  mutex.cpp
)

add_executable(
  conditionVariable
  conditionVariable.cpp
)

add_executable(
  conditionVariable2
  conditionVariable2.cpp
)

add_executable(
  atomicCondition
  atomicCondition.cpp
)
