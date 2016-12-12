# Ces cibles ne sont pas des vrais fichiers
.PHONY: clean
# On désactive toutes les règles implicites
.SUFFIXES:

# Déclarations de constantes
CC = gcc
FLAGS = -Wall -Werror -W
SOURCES=$(wildcard *.c)
OBJECTS=$(SOURCES:.c=.o)

# compilation finale
tp.exe: $(OBJECTS)
	$(CC) -o $@ $^

# Règle générique : $< == le fichier .c compilé
%.o: %.c
	$(CC) $(FLAGS) -c -o $@ $<

clean:
	rm -f *.o