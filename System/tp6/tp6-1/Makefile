# Ces cibles ne sont pas des vrais fichiers
.PHONY: clean
# On d�sactive toutes les r�gles implicites
.SUFFIXES:

# D�clarations de constantes
CC = gcc
FLAGS = -Wall -Werror -W
SOURCES=$(wildcard *.c)
OBJECTS=$(SOURCES:.c=.o)

# compilation finale
tp.exe: $(OBJECTS)
	$(CC) -o $@ $^

# R�gle g�n�rique : $< == le fichier .c compil�
%.o: %.c
	$(CC) $(FLAGS) -c -o $@ $<

clean:
	rm -f *.o