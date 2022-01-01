// addMoney.cpp

#include <functional>
#include <iostream>
#include <thread>
#include <vector>
#include <mutex>

std::mutex countMutex;

struct Account{
  int balance{100};                             
};

void addMoney(Account& to, int amount){
  countMutex.lock();
  to.balance += amount;  
  countMutex.unlock();                       
}

int play() {
  Account account;
  
  std::vector<std::thread> vecThreads(100);
  
                                                 
  for (auto& thr: vecThreads) thr = std::thread(addMoney, std::ref(account), 50);
  
  for (auto& thr: vecThreads) thr.join();

  return account.balance;
}

int main(){
  
  std::cout << std::endl;

  int count = 0;
  int ret = 5100;
  while (ret == 5100 && count < 1000) {
    count++;
    ret = play();
  }

  std::cout << "#" << count << " account.balance: " << ret << std::endl;
  
  std::cout << std::endl;

}
