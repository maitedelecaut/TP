#include <stdio.h>

void afficher(int liste[], int taille){
  int i;
  for(i=0; i<taille; i++){
    if(liste[i] != "null"){
      printf("%d \n" , liste[i]);
    }
  }
}

int somme (int liste[], int taille){
  int i;
  int somme = 0;
  for(i=0; i<taille; i++){
    somme = somme + liste[i];
  }
  return somme;
}

void copie_dans(int dest[], int src[], int taille){
  int i;
  for(i=0; i<taille; i++){
    dest[i] = src[i];
  }
}

void ajoute_apres(int dest[], int taille_dest, int src[], int taille_src){
  int i;
  int d = 0;
  for(i = taille_src; i <taille_dest; i++){
    dest[i] = src[d];
    d++;
    }
}

void main(void){

  int src [10];
  int t = 10;
  int dest [35];
  int taille = 35;
  int t2 = 10;
  int i;

  for(i =0; i< t; i++){
    src[i] = i;
  }
  //afficher(src, t);
  //printf ("%d \n" , somme(src, t));

  copie_dans(dest, src, t);
  //afficher(dest,t);

  ajoute_apres(dest, taille, src, t);
  afficher(dest, 20);
  
}
