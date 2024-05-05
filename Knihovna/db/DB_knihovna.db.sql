BEGIN TRANSACTION;
DROP TABLE IF EXISTS "SeznamKnih";
CREATE TABLE IF NOT EXISTS "SeznamKnih" (
	"IdKnihy"	INTEGER NOT NULL,
	"Nazev"	TEXT NOT NULL,
	"Autor"	TEXT,
	"RokVydani"	INTEGER NOT NULL,
	"Stav"	INTEGER NOT NULL,
	PRIMARY KEY("IdKnihy" AUTOINCREMENT)
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
	"Typ"	TEXT,
	PRIMARY KEY("IdKnihy"),
	FOREIGN KEY("IdKnihy") REFERENCES "SeznamKnih"("IdKnihy")
);
INSERT INTO "SeznamKnih" ("IdKnihy","Nazev","Autor","RokVydani","Stav") VALUES (1,'Rytířská čest','Nicole Lockeová',2021,1);
INSERT INTO "SeznamKnih" ("IdKnihy","Nazev","Autor","RokVydani","Stav") VALUES (2,'Neobyčejný román o Ježíšovi','Mercier Jean',2020,1);
INSERT INTO "SeznamKnih" ("IdKnihy","Nazev","Autor","RokVydani","Stav") VALUES (3,'Naučte se SQL za 28 dní','Ryan K. Stephens',2010,0);
INSERT INTO "Romany" ("IdKnihy","Typ") VALUES (1,'Rytířksý');
INSERT INTO "Romany" ("IdKnihy","Typ") VALUES (2,'Sci-Fi');
COMMIT;
