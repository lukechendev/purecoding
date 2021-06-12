// asyncVersusThread.cpp

#include <future>
#include <thread>
#include <iostream>
#include <chrono>

int cal(int id) {
  std::cout << "start cal " << id << std::endl;
  // std::this_thread::sleep_for(std::chrono::milliseconds(2000));
  return 2000 + 2;
}

int main(){

  std::cout << std::endl;

  std::async(std::launch::async, &cal, -1);

  auto fut4 = std::async(std::launch::async, &cal, 0);
  std::this_thread::sleep_for(std::chrono::milliseconds(1000));
  std::cout << "fut4.get(): " << fut4.get() << std::endl;

  auto fut5 = std::async(std::launch::deferred, &cal, 1);
  std::this_thread::sleep_for(std::chrono::milliseconds(1000));
  std::cout << "fut5.get(): " << fut5.get() << std::endl;

  std::async(std::launch::async, &cal, 2);

  std::cout << std::endl;
}
