#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <unistd.h>


char** processArgs(int argc, char *argv[]);
int traiter (int f, int *car, int *mot, int *lig);
int characters(char *buf);
int words(char * buf);
int lines(char * buf);


int c = 0;
int w = 0;
int l = 0;

int main(int argc, char *argv[])
{
	char **files = processArgs(argc,argv);
	for
	int *car = malloc(sizeof(int));
	int *wor = malloc(sizeof(int));
	int *lig = malloc(sizeof(int));
	int fd = open("test", O_RDONLY);
	traiter (fd, car, wor, lig);
	printf(" ");
	printf("%d  ", *lig);
	printf("%d ", *wor);
	printf("%d ", *car);
	printf("test\n");

	
	return 0;
}

char** processArgs(int argc, char *argv[])
{
	char **t = malloc(argc * sizeof(char*));
	int nbFiles = 0;	

	int i;
	for (i = 1; i < argc; i++)
	{
		
		//pour chaque arguments
		if(argv[i][0] == '-'){
			//on traite une option
			if(strstr(argv[i],"c") != NULL)
				c = 1;
			if(strstr(argv[i],"w") != NULL)
				w = 1;
			if(strstr(argv[i],"l") != NULL)
				l = 1;
		}
		else
		{
			//on traite un fichier
			t[nbFiles] = malloc(strlen(argv[i]) * sizeof(char));
			strcpy(t[nbFiles],argv[i]);
			nbFiles++;
		}
	}
	if(nbFiles < 1){
		printf("Veuillez entrer le chemin d'un fichier !\n");
		exit(1);
	}

	//on met la liste des fichiers dans un tableau à la bonne taille
	char **r = malloc(nbFiles * sizeof(char*));
	for (i = 0; i < nbFiles; i++)
	{
		r[i] = malloc(strlen(t[i]) * sizeof(char));
		strcpy(r[i],t[i]);
	}
	free(t);
	return r;
}
/*
int traiter (int fd, int *car, int *mot, int *lig)
{
	char *buf = malloc(80);
	int eof  = read(fd, buf, 80);
	*car = characters(buf);
	return 0;
}*/
int traiter (int fd, int *car, int *wor, int *lig)
{
	char *buf = malloc(80);
	int eof  = read(fd, buf, 80);
	int nCar = 0;
	int nWor = 0;
	int nLig = 0;
	while (eof > 0)
	{
		nCar += characters(buf);
		nWor += words(buf);
		nLig += lines(buf);
		eof  = read(fd, buf, 80);
	}
	*car = nCar;
	*wor = nWor;
	*lig = nLig;
	return 0;
}

int characters(char *buf)
{
	return strlen(buf);
}

int words(char * buf)
{
	int cpt = 0;
	unsigned int i;
	for(i = 0; i < strlen(buf); i++)
	{
		if(isspace(buf[i]))
			cpt++;
	} 

	return cpt-1;
}

int lines(char * buf)
{
	int cpt = 0;
	unsigned int i;
	for(i = 0; i < strlen(buf); i++)
	{
		if(buf[i] == '\n')
			cpt++;
	} 
	return cpt;

}
