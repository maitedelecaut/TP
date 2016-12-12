#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <ctype.h>

#define BUFF_SIZE 80

int main(int argc, char *argv[]){
  int fichier;
  fichier = open(argv[1], O_RDONLY);
  int *c = malloc(sizeof(int));
  int *m = malloc(sizeof(int));
  int *l = malloc(sizeof(int));
  int i = 2;
  if (fichier != NULL)
    {
      printf("fichier ouvert\n");;
      traiter(fichier,c,m,l);
      
      for(i; i<argc; i++){
	if(strpbrk(argv[i], "c")){
	    printf("Nombre de caractere : %d\n", *c);
	}
        if(strpbrk(argv[i], "w")){
	  printf("Nombre de mot : %d\n", *m);
	}
        if(strpbrk(argv[i], "l")){
	  printf("Nombre de ligne : %d\n", *l);
	}
      }
      close(fichier); //on ferme le fichier
    }else{
      // On affiche un message d'erreur si on veut
      printf("Impossible d'ouvrir le fichier test.txt\n");
      }

    return 0;
  }

int traiter (int f, int *car, int *mot, int *lig){
  char buffer[BUFF_SIZE];
  int c = 0;
  int m = 1;
  int l = 0;

  while(read(f, buffer,BUFF_SIZE)>0){
    int i;
    for(i = 0; i < strlen(buffer); i++){
      c++;
	if(isspace(buffer[i]) && buffer[i]!='\n'){
	  m++;
	}
	if(buffer[i] == '\n'){
	  l++;
	}
      } 
  }
    
  *car = c;
  *mot = m;
  *lig = l;
 return 1;
}
