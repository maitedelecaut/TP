    CC = gcc
CFLAGS = -O4 -W -Wall

tp1_1: tp1_1.o tp1_2.o tp1_3.o
	$(CC) $(CFLAGS) tp1_1.o tp1_2.o tp1_3.o
tp1_1.o : tp1_1.c
	$(CC) $(CFLAGS) -c tp1_1.c

tp1_2.o : tp1_2.c
	$(CC) $(CFLAGS) -c tp1_2.c

tp1_3.o : tp1_3.c
	$(CC) $(CFLAGS) -c tp1_3.c
