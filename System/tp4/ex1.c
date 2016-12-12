#include <stdio.h>
#include <string.h>
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

char * saisie (){
	char c = getchar();
	char *s = malloc(0);
	int size = 0;
	while (c != '\n' ){
		s = realloc(s, (size+1)*sizeof(char) );
		s[size] = c;
		c = getchar();
		size++;
	}
	s[size] = '\0';
	return s;
}



int main (int argc, char *argv[]){
	int i;
	unsigned int j;
	short optm = 0;
	short opts = 0;
	short opt = 0;
	for (i = 1; i< argc; i++){
		if(argv[i][0] == '-'){
			for(j = 1;j<strlen(argv[i]);j++){
				if (argv[i][j] == 'm' ){
					optm = 10;
				}else if (argv[i][j] == 's'){
					opts= 1;
				}
				else{
					opt = 100;
				}	
			}
			/*if ( strchr(argv[i], 'm') != NULL ){
				optm = 10;
			}
			if ( strchr(argv[i], 's') != NULL ){
				opts= 1;
			}*/
		}
	}
	
	opt = opt + opts+optm;
	switch (opt)
	{
	case 1:
		printf("%s\n", saisie());
	break;
	case 10:
		optm = 0;
		for (i = 1; i< argc; i++){
			if(argv[i][0] != '-'){		
				optm =10;
				printf("%s\n", miroir(argv[i]));
			}
		}
		if(optm == 0){
			printf("Maivaise utilisation \n");
			return 1;
		}
	break;
	case 11:
		printf("%s\n", miroir(saisie()));
	break;
	default:
		printf("Maivaise utilisation \n");
		return 1;
	break;
	}
	return 0;
}
	