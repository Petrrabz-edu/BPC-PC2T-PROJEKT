BEGIN TRANSACTION;
DROP TABLE IF EXISTS "Autor";
CREATE TABLE IF NOT EXISTS "Autor" (
	"IdAutora"	INTEGER NOT NULL,
	"JmenoAutora"	TEXT NOT NULL,
	PRIMARY KEY("IdAutora" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "AutorovyKnihy";
CREATE TABLE IF NOT EXISTS "AutorovyKnihy" (
	"IdKnihy"	INTEGER NOT NULL,
	"IdAutora"	INTEGER NOT NULL,
	PRIMARY KEY("IdKnihy","IdAutora"),
	FOREIGN KEY("IdAutora") REFERENCES "Autor"("IdAutora"),
	FOREIGN KEY("IdKnihy") REFERENCES "SeznamKnih"("IdKnihy")
);
DROP TABLE IF EXISTS "Ucebnice";
CREATE TABLE IF NOT EXISTS "Ucebnice" (
	"IdKnihy"	INTEGER NOT NULL,
	"Vhodnost"	TEXT NOT NULL,
	PRIMARY KEY("IdKnihy"),
	FOREIGN KEY("IdKnihy") REFERENCES "SeznamKnih"("IdKnihy")
);
DROP TABLE IF EXISTS "Romany";
CREATE TABLE IF NOT EXISTS "Romany" (
	"IdKnihy"	INTEGER NOT NULL,
	"Typ"	TEXT NOT NULL CHECK("Typ" IN ('Historický', 'Detektivní', 'Sci-fi', 'Dobrodružný', 'Rytířský')),
	PRIMARY KEY("IdKnihy"),
	FOREIGN KEY("IdKnihy") REFERENCES "SeznamKnih"("IdKnihy")
);
DROP TABLE IF EXISTS "SeznamKnih";
CREATE TABLE IF NOT EXISTS "SeznamKnih" (
	"IdKnihy"	INTEGER NOT NULL,
	"Nazev"	TEXT NOT NULL,
	"RokVydani"	INTEGER NOT NULL,
	"Stav"	TEXT NOT NULL CHECK("Stav" IN ('k dispozici', 'vypůjčeno')),
	PRIMARY KEY("IdKnihy" AUTOINCREMENT)
);
INSERT INTO "Autor" ("IdAutora","JmenoAutora") VALUES (1,'Nicole Lockeová');
INSERT INTO "Autor" ("IdAutora","JmenoAutora") VALUES (2,'Mercier Jean');
INSERT INTO "Autor" ("IdAutora","JmenoAutora") VALUES (3,'Ryan K. Stephens');
INSERT INTO "AutorovyKnihy" ("IdKnihy","IdAutora") VALUES (1,1);
INSERT INTO "AutorovyKnihy" ("IdKnihy","IdAutora") VALUES (2,2);
INSERT INTO "AutorovyKnihy" ("IdKnihy","IdAutora") VALUES (3,3);
INSERT INTO "Ucebnice" ("IdKnihy","Vhodnost") VALUES (3,'');
INSERT INTO "Romany" ("IdKnihy","Typ") VALUES (1,'Rytířský');
INSERT INTO "Romany" ("IdKnihy","Typ") VALUES (2,'Historický');
INSERT INTO "SeznamKnih" ("IdKnihy","Nazev","RokVydani","Stav") VALUES (1,'Rytířská čest',2021,'k dispozici');
INSERT INTO "SeznamKnih" ("IdKnihy","Nazev","RokVydani","Stav") VALUES (2,'Neobyčejný román o Ježíšovi',2020,'k dispozici');
INSERT INTO "SeznamKnih" ("IdKnihy","Nazev","RokVydani","Stav") VALUES (3,'Naučte se SQL za 28 dní',2010,'vypůjčeno');
COMMIT;
