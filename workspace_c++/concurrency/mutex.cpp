// mutex.cpp
#include <iostream>
#include <mutex>
#include <thread>

std::mutex mut;

void workOnResource(int id){
  mut.lock();
  std::cout << "Working on " << id << std::endl;
  std::this_thread::sleep_for(std::chrono::milliseconds(2000));
  mut.unlock();
  std::cout << "Work done " << id << std::endl;
}

int main(){

  std::thread t(workOnResource, 1);
  std::thread t2(workOnResource, 2);

  t.join();
  t2.join();

}
