// conditionVariable2.cpp

#include <iostream>
#include <condition_variable>
#include <mutex>
#include <thread>
#include <chrono>

std::mutex mutex_;
std::condition_variable condVar;

bool dataReady{false};

void doTheWork(){
  std::cout << "Processing shared data." << std::endl;
}

void waitingForWork(){
    std::cout << "Worker: Start." << std::endl;
    std::this_thread::sleep_for(std::chrono::milliseconds(1000));
    std::cout << "Worker: Waiting for work." << std::endl;
    std::unique_lock<std::mutex> lck(mutex_);
    condVar.wait(lck, []{ return dataReady; });
    doTheWork();
    std::cout << "Work done." << std::endl;
}

void setDataReady(){

    {
      std::lock_guard<std::mutex> lck(mutex_);
      std::cout << "pending data ready" << std::endl;
      std::this_thread::sleep_for(std::chrono::milliseconds(1000));
      dataReady = true;
      std::cout << "Sender: Data is ready."  << std::endl;
      // better std::cout << "Sender: Data is ready.\n";
    }
    // condVar.notify_one();
    std::cout << "Sender: notified."  << std::endl;
}

int main(){

  std::cout << std::endl;

  std::thread t1(waitingForWork);
  std::thread t2(setDataReady);

  std::cout << "Main: to join t1."  << std::endl;
  t1.join();
  std::cout << "Main: t1 joined."  << std::endl;
  std::cout << "Main: to join t2."  << std::endl;
  t2.join();
  std::cout << "Main: t2 joined."  << std::endl;

  std::cout << "Main: end" << std::endl;
}
