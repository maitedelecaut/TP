#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

#include "ligne_commande.h"

void execute_ligne_commande(){
  char*** cmd;
  int flag;
  int nb;
  
  cmd = ligne_commande(&flag, &nb);
  // affiche(cmd);
  if(flag == 1){
    int f = fork();
    if(f == -1){
      perror("");
    }
    else if(f == 0){
      execvp(cmd[0][0], cmd[0]);
    }
    else{
      perror("");
    }
  }
  else if(flag == 0){
    execvp(cmd[0][0], cmd[0]);
  }
  else{
    perror(cmd[0][0]);
  }
  
  libere(cmd);
}

void affiche_prompt(){
  //printf("iutsh$\n");
  //printf("USER : %s\n", getenv("USER"));

  char hostname[128];
  gethostname(hostname, sizeof hostname);
  //printf("COMPUTERNAME : %s\n", hostname);

  char cour[128];
  getcwd(cour, sizeof cour);
  //printf("REP-COUR : %s\n", cour);

  printf("%s@%s:%s$ ", getenv("USER"), hostname, cour);
  fflush(stdout);
}

int main(void){
  affiche_prompt();
  execute_ligne_commande();
}
