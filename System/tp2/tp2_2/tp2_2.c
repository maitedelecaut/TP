#include <stdio.h>

struct rat
{
  int den;
  int num;
};

struct rat rat_produit(struct rat n1, struct rat n2){
  int den =  n1.den * n2.den;
  int num = n1.num * n2.num;
  struct rat ratP= {den, num};
  return ratP;
}

struct rat rat_somme(struct rat n1, struct rat n2){
  if(n1.den = n2.den){
    int den = n1.den + n2.den;
    int num = n1.num + n2.den;
    struct rat ratS = {den, num};
    return ratS;
  }
  else{
    int den = n1.den*n2.den;
    int num = n1.num * n2.den + n2.num * n2.den; 
    struct rat ratS = {den, num};
    return ratS;
  }
}

struct rat rat_plus_petit(struct rat list[]){
  struct rat ratP = {list[0].den, list[0].num};
  float min = (float)list[0].num / (float)list[0].den;
  int i = 0;
  while(list[i].den != 0){
    if((float)list[i].num/(float)list[i].den < min){
      min = (float)list[i].num / (float)list[i].den;
      ratP.num = list[i].num;
      ratP.den = list[i].den;
    }
    i = i+1;
  }
  return ratP;
}

void main(void){
  struct rat r1 = {1,2};
  struct rat r2 = {2,2};
  struct rat r3 = {8,1};
  struct rat r4 = {30,1};
  struct rat fin = {0,0};
  struct rat resP = rat_produit(r1, r2);
  struct rat resS = rat_somme(r1, r2);
  
  struct rat liste [5] = {r1, r2, r3, r4, fin};
  struct rat ratP = rat_plus_petit(liste);


  //printf("Produit : %d / %d \n", resP.num ,resP.den);
  //printf("Somme : %d / %d \n", resS.num ,resS.den);

  printf("Le plus petit : %d / %d \n", ratP.num, ratP.den);
  
}
