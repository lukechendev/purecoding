// asyncVersusThread.cpp

#include <future>
#include <thread>
#include <iostream>
#include <chrono>

int cal() {
  std::cout << "start cal" << std::endl;
  std::this_thread::sleep_for(std::chrono::milliseconds(2000));
  return 2000 + 2;
}

int main(){

  std::cout << std::endl;

  int res;
  std::thread t([&]{ res = 2000 + 11; });
  t.join();
  std::cout << "res: " << res << std::endl;

  auto fut= std::async([]{ return 2000 + 11; });
  std::cout << "fut.get(): " << fut.get() << std::endl;

  auto fut2 = std::async(cal);
  std::this_thread::sleep_for(std::chrono::milliseconds(2000));
  std::cout << "fut2.get(): " << fut2.get() << std::endl;

  auto fut3 = std::async(&cal);
  std::this_thread::sleep_for(std::chrono::milliseconds(2000));
  std::cout << "fut3.get(): " << fut3.get() << std::endl;

  auto fut4 = std::async(&cal);
  std::this_thread::sleep_for(std::chrono::milliseconds(2000));
  std::cout << "fut4.get(): " << fut4.get() << std::endl;

  std::cout << std::endl;
}
