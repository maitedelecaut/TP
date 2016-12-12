#include <stdio.h>
#include "malloc.h"


unsigned char heap[1000];

typedef struct
{
unsigned int free ;
unsigned int size ;
/* ces champs ne sont pas écrit dans la heap mais sont affectés par get_chunk */
unsigned char *addr ;
unsigned char *next_chunk ;
unsigned char *previous_chunk ;
} chunk ;


unsigned int get_int(void *ptr){
  return *((unsigned int*)ptr);
}

void set_int(void *ptr, unsigned int val){
  *(unsigned int *)ptr = val;
}

void set_chunk(chunk *c, unsigned char *ptr){
  set_int(ptr, c->free);
  set_int(ptr+sizeof(unsigned int), c->size);
  set_int((ptr + (c->size) - sizeof(unsigned int)),c->size);
}

void get_chunk(chunk *c, unsigned char *ptr){
  c->free = get_int(&ptr);
  c->size = get_int(&ptr+1);
  c->addr = ptr;

  if(ptr == heap){
    c->previous_chunk = NULL;
  }
  else{
    c->previous_chunk = ptr-get_int(&ptr-1);
  }

  if(get_int(&ptr)+c->size == 1000){
    c->next_chunk = NULL;
  }
  else{
    c->next_chunk=ptr+c->size;
    }
}

void init_alloc(){
  chunk init ;
  init.free = 1;
  init.size = 1000;
  init.next_chunk = NULL;
  init.previous_chunk = NULL;
  set_chunk(&init, heap);
}

void *my_malloc(unsigned int size){
  unsigned char * ptr = heap;
  chunk c;
  get_chunk(&c, ptr);

  while((c.free) == 0 || (c.size)<size){
    get_chunk(&c, get_int(ptr) + 3*(sizeof(unsigned int)));
  }
  c.free = 1;
  c.size = size;
}

void main(void){
}
