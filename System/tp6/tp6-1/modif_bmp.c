#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

#include <stdlib.h>

#include <stdio.h>

#include <unistd.h>

//#define DEBUG

/* On déclare des types dont on est sûr de la taille.
Si on doit implémenter le TP sur une architecture différente, il
suffit de changer ces déclarations
*/
typedef unsigned short uint16;
typedef unsigned int uint32;

typedef struct
{
	uint16 signature;
	uint32 taille_fichier;
	uint32 reserve;
	uint32 offset_donnees;
} entete_fichier;

typedef struct
{
	uint32 taille_entete;
	uint32 largeur;
	uint32 hauteur;
	uint16 nombre_plans;
	uint16 profondeur;
	uint32 compression;
	uint32 taille_donnees_image;
	uint32 resolution_horizontale;
	uint32 resolution_verticale;
	uint32 taille_palette; /* en nombre de couleurs */
	uint32 nombre_de_couleurs_importantes; /* 0 */
} entete_bitmap;

typedef struct
{
	entete_fichier fichier;
	entete_bitmap bitmap;
} entete_bmp;

int lire_deux_octets(int fd, uint16 *val)
{
	return read(fd, val, 2);
}

int lire_quatre_octets(int fd, uint32 *val)
{
	return read(fd, val, 4);
}

int lire_entete(int fd, entete_bmp *entete)
{
	if(lire_deux_octets(fd,&entete->fichier.signature) == -1)
		return -1;
	if(lire_quatre_octets(fd,&entete->fichier.taille_fichier) == -1)
		return -1;
	if(lire_quatre_octets(fd,&entete->fichier.reserve) == -1)
		return -1;
	if(lire_quatre_octets(fd,&entete->fichier.offset_donnees) == -1)
		return -1;
	
	if(lire_quatre_octets(fd,&entete->bitmap.taille_entete) == -1)
		return -1;
	if(lire_quatre_octets(fd,&entete->bitmap.largeur) == -1)
		return -1;
	if(lire_quatre_octets(fd,&entete->bitmap.hauteur) == -1)
		return -1;
	if(lire_deux_octets(fd,&entete->bitmap.nombre_plans) == -1)
		return -1;
	if(lire_deux_octets(fd,&entete->bitmap.profondeur) == -1)
		return -1;
	if(lire_quatre_octets(fd,&entete->bitmap.compression) == -1)
		return -1;
	if(lire_quatre_octets(fd,&entete->bitmap.taille_donnees_image) == -1)
		return -1;
	if(lire_quatre_octets(fd,&entete->bitmap.resolution_horizontale) == -1)
		return -1;
	if(lire_quatre_octets(fd,&entete->bitmap.resolution_verticale) == -1)
		return -1;
	if(lire_quatre_octets(fd,&entete->bitmap.taille_palette) == -1)
		return -1;
	if(lire_quatre_octets(fd,&entete->bitmap.nombre_de_couleurs_importantes) == -1)
		return -1;
	
	return 0;
}

int ecrire_deux_octets(int fd, uint16 val)
{
	return write(fd,&val,2);
}

int ecrire_quatre_octets(int fd, uint32 val)
{
	return write(fd,&val,4);
}

int ecrire_entete(int fd, entete_bmp *entete)
{
	if(ecrire_deux_octets(fd, entete->fichier.signature) == -1)
		return -1;
	if(ecrire_quatre_octets(fd, entete->fichier.taille_fichier) == -1)
		return -1;
	if(ecrire_quatre_octets(fd, entete->fichier.reserve) == -1)
		return -1;
	if(ecrire_quatre_octets(fd, entete->fichier.offset_donnees) == -1)
		return -1;
	
	if(ecrire_quatre_octets(fd, entete->bitmap.taille_entete) == -1)
		return -1;
	if(ecrire_quatre_octets(fd, entete->bitmap.largeur) == -1)
		return -1;
	if(ecrire_quatre_octets(fd, entete->bitmap.hauteur) == -1)
		return -1;
	if(ecrire_deux_octets(fd, entete->bitmap.nombre_plans) == -1)
		return -1;
	if(ecrire_deux_octets(fd, entete->bitmap.profondeur) == -1)
		return -1;
	if(ecrire_quatre_octets(fd, entete->bitmap.compression) == -1)
		return -1;
	if(ecrire_quatre_octets(fd, entete->bitmap.taille_donnees_image) == -1)
		return -1;
	if(ecrire_quatre_octets(fd, entete->bitmap.resolution_horizontale) == -1)
		return -1;
	if(ecrire_quatre_octets(fd, entete->bitmap.resolution_verticale) == -1)
		return -1;
	if(ecrire_quatre_octets(fd, entete->bitmap.taille_palette) == -1)
		return -1;
	if(ecrire_quatre_octets(fd, entete->bitmap.nombre_de_couleurs_importantes) == -1)
		return -1;
	
	return 0;
}

int verifier_entete(entete_bmp *entete)
{
	if(entete->bitmap.profondeur != 24)
		return -1;
	return 0;
}

unsigned char* allouer_pixels(entete_bmp *entete)
{
	return malloc(entete->bitmap.taille_donnees_image);
}

int lire_pixels(int fd, entete_bmp *entete, unsigned char *pixels)
{
	return read(fd, pixels, entete->bitmap.taille_donnees_image);
}

int ecrire_pixels(int fd, entete_bmp *entete, unsigned char *pixels)
{
	return write(fd,pixels,entete->bitmap.taille_donnees_image);
}


int copier_bmp(int de, int vers)
{
	entete_bmp entete;
	unsigned char *pixels;
	/* lecture du fichier source */
	lire_entete(de, &entete);
	pixels = allouer_pixels(&entete);
	lire_pixels(de, &entete, pixels);
	/* écriture du fichier destination */
	ecrire_entete(vers, &entete);
	ecrire_pixels(vers, &entete, pixels);
	free(pixels);
	return 1;
}

void rouge(entete_bmp *entete, unsigned char *pixels)
{
	#ifdef DEBUG
		printf("nb octets (pixels) : %d\n",entete->bitmap.largeur * entete->bitmap.hauteur*3);
		printf("nb octets (total): %d\n", entete->bitmap.taille_donnees_image);
		printf("bourage : %d\n",entete->bitmap.taille_donnees_image - entete->bitmap.largeur * entete->bitmap.hauteur*3);
		printf("bourage/lignes : %d\n",(entete->bitmap.taille_donnees_image - entete->bitmap.largeur * entete->bitmap.hauteur*3)/entete->bitmap.hauteur);
	#endif
	unsigned int id_pix = 0;
	unsigned int id_lig = 0;
	int bourage = (entete->bitmap.taille_donnees_image - entete->bitmap.largeur * entete->bitmap.hauteur*3)/entete->bitmap.hauteur;
	
	unsigned int largeur = entete->bitmap.largeur;
	unsigned int hauteur = entete->bitmap.hauteur;
	
	
	for(id_lig = 0; id_lig <= hauteur ; id_lig++){
		for(id_pix = id_lig*largeur*3 + id_lig*bourage;     id_pix < (id_lig+1)*largeur*3+(id_lig+1)*bourage;     id_pix += 3){	
			pixels[id_pix] = 0;
			pixels[id_pix+1] = 0;
		}
	}
}

void negatif(entete_bmp *entete, unsigned char *pixels)
{
	unsigned int id_pix = 0;
	unsigned int id_lig = 0;
	int bourage = (entete->bitmap.taille_donnees_image - entete->bitmap.largeur * entete->bitmap.hauteur*3)/entete->bitmap.hauteur;
	
	unsigned int largeur = entete->bitmap.largeur;
	unsigned int hauteur = entete->bitmap.hauteur;
	
	
	for(id_lig = 0; id_lig <= hauteur ; id_lig++){
		for(id_pix = id_lig*largeur*3 + id_lig*bourage;     id_pix < (id_lig+1)*largeur*3+(id_lig+1)*bourage;     id_pix++){	
			pixels[id_pix] = ~pixels[id_pix];
		}
	}
	
}

void noir_et_blanc(entete_bmp *entete, unsigned char *pixels)
{
	unsigned int id_pix = 0;
	unsigned int id_lig = 0;
	int bourage = (entete->bitmap.taille_donnees_image - entete->bitmap.largeur * entete->bitmap.hauteur*3)/entete->bitmap.hauteur;
	
	unsigned int largeur = entete->bitmap.largeur;
	unsigned int hauteur = entete->bitmap.hauteur;
	
	for(id_lig = 0; id_lig <= hauteur ; id_lig++){
		for(id_pix = id_lig*largeur*3 + id_lig*bourage;     id_pix < (id_lig+1)*largeur*3+(id_lig+1)*bourage;     id_pix += 3){
			int gray = 0.07*pixels[id_pix] + 0.72*pixels[id_pix+1] + 0.21*pixels[id_pix+2];
			pixels[id_pix] = gray;
			pixels[id_pix+1] = gray;
			pixels[id_pix+2] = gray;
		}
	}
}

void moitie(entete_bmp *entete, unsigned char *pixels, int sup){

	unsigned int hauteur = entete->bitmap.hauteur;
	
	if(sup == 1){
		unsigned int i;
		for(i=entete->bitmap.taille_donnees_image/2;   i<entete->bitmap.taille_donnees_image;i++){
			pixels[i-entete->bitmap.taille_donnees_image/2] = pixels[i];
		}
		entete->bitmap.hauteur = hauteur/2;
	}else{
		entete->bitmap.hauteur = hauteur/2;
	}
}

int main(int argc, char *argv[]){
	int i;
	for(i = 1; i<argc; i++){
		
	}	
	
	
	
	//=============
	//	INFORMATIONS
	//=============
	
	int fd = open("test24.bmp",O_RDONLY);
	
	entete_bmp entete;
	
	lire_entete(fd, &entete);
	if (verifier_entete(&entete) == -1)
	{
		printf("Compression non prise en compte\n");
		return -1;
	}
	
	printf("Magic Number : 0x%04X\n",entete.fichier.signature);
	printf("FileSize : %d bytes\n",entete.fichier.taille_fichier);
	printf("Reserve : %d\n",entete.fichier.reserve);
	printf("DataOffset : 0x%08X\n",entete.fichier.offset_donnees);
	
	printf("HeaderSize : %d\n",entete.bitmap.taille_entete);
	printf("ImageSize : %dx%d\n",entete.bitmap.largeur, entete.bitmap.hauteur);
	printf("ColorPlanes : %d\n",entete.bitmap.nombre_plans);
	printf("ImageDepth : %d\n",entete.bitmap.profondeur);
	printf("CompressionMethod : %d\n",entete.bitmap.compression);
	printf("ImageDataSize : %d bytes\n",entete.bitmap.taille_donnees_image);
	printf("Resolution : %dx%d ppm\n",entete.bitmap.resolution_horizontale, entete.bitmap.resolution_verticale);
	printf("PaletteSize : %d\n",entete.bitmap.taille_palette);
	printf("ImportantPaletteColors : %d\n",entete.bitmap.nombre_de_couleurs_importantes);
	
	unsigned char *pixels = allouer_pixels(&entete);
	
	lire_pixels(fd, &entete, pixels);
	close(fd);
	
	
	//=============
	//	COPIE
	//=============
	
	
	fd = open("test24.bmp",O_RDONLY);
	int fd2 = open("copie.bmp",O_CREAT | O_WRONLY,0777);
	
	copier_bmp(fd,fd2);
	close(fd);
	close(fd2);
	
	//=============
	//	ROUGE
	//=============
	
	fd = open("test24.bmp",O_RDONLY);
	fd2 = open("copieRouge.bmp",O_CREAT | O_WRONLY,0777);
	
	lire_entete(fd, &entete);
	pixels = allouer_pixels(&entete);
	lire_pixels(fd, &entete, pixels);
	
	rouge(&entete, pixels);
	
	ecrire_entete(fd2, &entete);
	ecrire_pixels(fd2, &entete, pixels);
	
	close(fd);
	close(fd2);
	
	
	//=============
	//	NEGATIF
	//=============
	
	fd = open("test24.bmp",O_RDONLY);
	fd2 = open("copieNegatif.bmp",O_CREAT | O_WRONLY,0777);

	lire_entete(fd, &entete);
	lire_pixels(fd, &entete, pixels);

	negatif(&entete, pixels);

	ecrire_entete(fd2, &entete);
	ecrire_pixels(fd2, &entete, pixels);

	close(fd);
	close(fd2);
	
	//=============
	//	NOIR ET BLANC
	//=============
	
	fd = open("test24.bmp",O_RDONLY);
	fd2 = open("copieBW.bmp",O_CREAT | O_WRONLY,0777);

	lire_entete(fd, &entete);
	lire_pixels(fd, &entete, pixels);

	noir_et_blanc(&entete, pixels);

	ecrire_entete(fd2, &entete);
	ecrire_pixels(fd2, &entete, pixels);

	close(fd);
	close(fd2);
	
	//=============
	//	MOITIE HAUT
	//=============
	
	fd = open("test24.bmp",O_RDONLY);
	fd2 = open("copieMoitieHaut.bmp",O_CREAT | O_WRONLY,0777);

	lire_entete(fd, &entete);
	lire_pixels(fd, &entete, pixels);

	moitie(&entete, pixels,1);

	ecrire_entete(fd2, &entete);
	ecrire_pixels(fd2, &entete, pixels);
	
	close(fd);
	close(fd2);
	
	//=============
	//	MOITIE BAS
	//=============
	
	fd = open("test24.bmp",O_RDONLY);
	fd2 = open("copieMoitieBas.bmp",O_CREAT | O_WRONLY,0777);
	
	lire_entete(fd, &entete);
	lire_pixels(fd, &entete, pixels);

	moitie(&entete, pixels,0);

	ecrire_entete(fd2, &entete);
	ecrire_pixels(fd2, &entete, pixels);

	close(fd);
	close(fd2);


	return 0;
}
