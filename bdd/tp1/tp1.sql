--2

Create Table Terrain
(tid Serial,
 nom char(20),
 prenom char(20),
 sport char(10),
Constraint pk_Terrain primary key(tid));

Create Table Abonne
(aid Serial,
 nom char(100),
 prenom char(100),
 dateExpAb Date,
 ParrainePar Integer,
Constraint pk_Abonne primary key(Aid),
Constraint fk_Abonne foreign key (ParrainePar) references Abonne(aid) on delete cascade);


Create Table Creneau
(Date date,
 Heure int,
 Constraint pk_Creneau primary key(date,heure));

Create Table Reservation
(aid int,
 date date,
 heure int,
 tid int,
 aidP int,
 utilise boolean,
Constraint pk_Reservation primary key(aid, aidP, date, heure, tid),
Constraint fk_Abonne foreign key (aid) references Abonne(aid) on delete cascade,
Constraint fk_Abonne1 foreign key (aidP) references Abonne(aid) on delete cascade,
Constraint fk_Creneau foreign key (date, heure) references Creneau(date,heure) on delete cascade,
Constraint fk_Terrain foreign key (tid) references Terrain(tid) on delete cascade);

--3
insert into Abonne(nom, prenom,dateExpAb) values ('Durand', 'Paul', '17/09/16');
insert into Abonne(nom, prenom,dateExpAb) values ('Leclerg', 'Jean', '17/09/16');
insert into Terrain(nom,sport) values ('T1', 'Tennis');
insert into Terrain(nom,sport) values ('B2', 'Bad');

insert into Creneau(date, heure) values ('16/09/16', 14);
insert into Creneau(date, heure) values ('02/12/16', 18);

insert into Reservation (aid, aidP, date, heure, tid)
       select ab2.aid, ab1.aid, date, heure, tid from Abonne ab1, Abonne ab2, Creneau, Terrain
       where ab1.nom = 'Leclerg' and ab2.nom = 'Durand'
       And Creneau.date = '16/09/16' And Creneau.heure = 14
       And Terrain.nom = 'B2';
--TD
--3
select * from Terrain where sport = 'Tennis';

select * from Abonne where ParrainePar is null;

