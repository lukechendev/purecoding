#include <stdio.h>
#include <stdlib.h>
#include <cstdlib>

void _start() {
  printf("in main thread\n");
  _exit(0);
}
