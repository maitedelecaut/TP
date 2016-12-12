CC = gcc
CFLAGS = -Wall -w -Werror
wordCount: wordCount.o 
	$(CC) $(CFLAGS) -o wordCount wordCount.o 
wordCount.o : wordCount.c
	$(CC) $(CFLAGS) -c wordCount.c
