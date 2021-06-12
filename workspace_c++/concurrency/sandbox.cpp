// asyncVersusThread.cpp

#include <future>
#include <thread>
#include <iostream>
#include <chrono>

int cal() {
  std::cout << "start cal" << std::endl;
  // std::this_thread::sleep_for(std::chrono::milliseconds(2000));
  return 2000 + 2;
}

int main(){

  std::cout << std::endl;

  auto fut4 = std::async(&cal);
  std::this_thread::sleep_for(std::chrono::milliseconds(2000));
  std::cout << "fut4.get(): " << fut4.get() << std::endl;

  auto fut5 = std::async(std::launch::deferred, &cal);
  std::this_thread::sleep_for(std::chrono::milliseconds(2000));
  std::cout << "fut5.get(): " << fut5.get() << std::endl;

  std::cout << std::endl;
}
