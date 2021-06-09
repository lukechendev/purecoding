// spinLock.cpp
#include <iostream>
#include <atomic>
#include <thread>

class Spinlock{
  std::atomic_flag flag;
public:
  Spinlock(): flag(ATOMIC_FLAG_INIT){}

  void lock(){
    while( flag.test_and_set() );
  }

  void unlock(){
    flag.clear();
  }
};

Spinlock spin;

void workOnResource(int id){
  spin.lock();
  // shared resource
  std::cout << "Working on " << id << std::endl;
  std::this_thread::sleep_for(std::chrono::milliseconds(2000));
  spin.unlock();
  std::cout << "Work done" << id << std::endl;
}


int main(){
  std::thread t(workOnResource, 1);
  std::thread t2(workOnResource, 2);

  t.join();
  t2.join();

}
