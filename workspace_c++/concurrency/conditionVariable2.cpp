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
    std::this_thread::sleep_for(std::chrono::milliseconds(2000));
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
      std::this_thread::sleep_for(std::chrono::milliseconds(7000));
      dataReady = true;
      std::cout << "Sender: Data is ready."  << std::endl;
    }
    // condVar.notify_one();
    std::cout << "Sender: notified."  << std::endl;
}

int main(){

  std::cout << std::endl;

  std::thread t1(waitingForWork);
  std::thread t2(setDataReady);

  t1.join();
  t2.join();

  std::cout << std::endl;

}
