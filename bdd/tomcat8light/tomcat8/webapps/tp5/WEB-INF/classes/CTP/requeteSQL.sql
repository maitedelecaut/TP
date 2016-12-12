create table salles(nom text, taille text, chaises text, portes text, fenetre text, ip text, dat text, constraint pk_salles primary key (nom));

/copy salles from 'data.txt' delimiter ';'
