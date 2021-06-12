// fireAndForgetFutures.cpp

#include <chrono>
#include <future>
#include <iostream>
#include <thread>

int main(){

  std::cout << std::endl;

  std::string name = "world";

  std::cout << "main fire first" << std::endl;
  std::async(std::launch::async, [&]{
    std::this_thread::sleep_for(std::chrono::seconds(2));
    std::cout << "first thread " << name << std::endl;
    });

  std::cout << "main fire second" << std::endl;
  std::async(std::launch::async, []{
    std::this_thread::sleep_for(std::chrono::seconds(1));
    std::cout << "second thread" << std::endl;}
    );

  std::cout << "main thread" << std::endl;

  std::cout << std::endl;
}
