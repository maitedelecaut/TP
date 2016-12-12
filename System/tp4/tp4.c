#include <stdio.h>
#include <stdlib.h>

char * miroir (const char *s){
	int  l=strlen(s), i=0;
	char *str=NULL;
	
	str=malloc((l+1)*sizeof(char)); 
	
	if(str == NULL){
		fprintf(stderr,"Erreur : memoire non disponible !");
		exit(EXIT_FAILURE);
	}
	for(i=0;i<l;++i)
		str[i]=s[l-i-1];
	str[l]='\0';
	
	return str;
}

char * saisie(){
  char c = getchar();
  int taille=0;
  char *t = malloc((taille+1)*sizeof(char));


  while(!isspace(c)){
    t[taille] = c;
    c = getchar();
    taille++;
    t=realloc(t, taille*sizeof(char));
  }
  return t;
}




void main(int argc, char *argv[]){
  int i = 1;
  int arg = 0;

  for(i; i<argc-1; i++){
    if(strpbrk(argv[i], "m")){
      arg = arg + 1;
      }
    if(strpbrk(argv[i], "s")){
      arg = arg + 2;
      }
    else{
      printf("mauvaise utilisation \n");
    }
  }

  if(arg == 1){
    printf("%s\n", miroir(argv[argc-1]));
  }
  else if(arg == 2){
    printf("%s\n", saisie());
  }
  else if(arg >2){
    printf("%s\n", miroir(saisie()));
  }
  
}
