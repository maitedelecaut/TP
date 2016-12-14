create table Personne(pno Serial, nom char(25), prenom char(25), mdp text, role text, check(nom is not null), check(prenom is not null), check(mdp is not null), check(role is not null), constraint pk_Personne primary key(pno));

create table Abs(ano Serial, cours Text, CreneauD Time, CreneauF Time, date Date, pno_Eleve integer, pno_Prof integer, numJ integer,
check(cours is not null), check(creneauD is not null), check(creneauF is not null), check(pno_Eleve is not null), check(pno_Prof is not null), check (date is not null),
constraint pk_Abs primary key(ano),
foreign key(pno_Eleve) references Personne(pno),
foreign key(pno_Prof) references Personne(pno),
foreign key(numJ) references Justif(numJ));

create table Justif(numJ Serial, text Text, dateD Date, dateF Date, pno_Eleve integer, pno_Secretaire integer, check(pno_Eleve is not null), check(pno_Secretaire is not null), check(dateD is not null), check(dateF is not null),
constraint pk_Justif primary key(numJ),
foreign key(pno_Eleve) references Personne(pno),
foreign key(pno_Secretaire) references Personne(pno));
