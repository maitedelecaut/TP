CC = gcc
CFLAGS = -Wall -w -Werror
iutsh: iutsh.o ligne_commande.o
	$(CC) $(CFLAGS) -o iutsh iutsh.o ligne_commande.o
iutsh.o :iutsh.c
	$(CC) $(CFLAGS) -c iutsh.c

