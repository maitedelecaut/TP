#include <stdio.h>
#include "tp1-2.h"

void fonction_b(int param)
{
  if(param ==0)
    printf("Le param�tre est nul\n");
  else
    printf("Le retour de la fonction_a est %d\n", fonction_a(param));
}
