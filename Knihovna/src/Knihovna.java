/*PRŮVODNÍ POZNÁMKY
POUŽÍVAT ANGLICKÉ NÁZVY PROMĚNNÝCH, JE TO PRAKTIČTĚJŠÍ
POUŽÍVAT ANGLICKÉ NÁZVY PROMĚNNÝCH, JE TO PRAKTIČTĚJŠÍ
POUŽÍVAT ANGLICKÉ NÁZVY PROMĚNNÝCH, JE TO PRAKTIČTĚJŠÍ
*
*
*/

import java.util.Scanner;


public class Knihovna {

	public static void main(String[] args) {
		System.out.println("( ﾉ ﾟｰﾟ)ﾉ Vítejte v invetarizačním programu Knihovna. ＼(ﾟｰﾟ＼)\n");
		System.out.println("Načítáme databázi, prosím vyčkejte.");
		//volání funkce pro načtení z databáze
		//na konci vrátí funkce hodnotu true / false
		//if true then System.out.println("Načítání databáze dokončeno.");
		
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int choice = 0;
		
		//Začátek práce s daty a iterakce s uživatelem
				
		while(run)
		{
			//Menu
			System.out.println("Vyberte požadovanou činnost:");
		    System.out.println("1 ... Přidání nové knihy"); //Přidání nové knihy – uživatel vybere typ knihy a zadá všechny její dostupné parametry.
			System.out.println("2 ... Úprava knihy"); // Úprava knihy – uživatel vybere knihu podle názvu a může provést úpravu autora/autorů, roku vydání nebo stavu dostupnosti.
			System.out.println("3 ... Smazání knihy"); //Smazání knihy – uživatel vybere knihu podle názvu a smaže ji ze seznamu.
			System.out.println("4 ... Označení knihy"); //Označení knihy jako vypůjčené/vrácené – uživatel označí knihu jako vypůjčenou nebo vrácenou, což ovlivní stav dostupnosti.
			System.out.println("5 ... Výpis knih"); //Výpis knih – uživatel může nechat vypsat všechny knihy v abecedním pořadí, přičemž se zobrazí název, autoři, žánr/ročník dle typu knihy, rok vydání a stav dostupnosti.
			System.out.println("6 ... Vyhledání knihy"); // Vyhledání knihy – uživatel zadá název knihy a zobrazí se mu veškeré informace o ní.
			System.out.println("7 ... Výpis všech knih autora"); //Výpis všech knih daného autora v chronologickém pořadí.
			System.out.println("8 ... Výpis všech knih konkrétního žánru"); //Výpis všech knih, které patří do konkrétního žánru – uživatel zadá žánr a zobrazí se mu seznam knih patřících do tohoto žánru.
			System.out.println("9 ... Výpis všech vypůjčených knih"); //Výpis všech vypůjčených knih s informací jestli se jedná o učebnici či román. 
			System.out.println("10 .. Export informací o knize"); //Uložení informace o vybrané knize (dle jejího názvu) do souboru.
			System.out.println("11 .. Import informací o knize"); //Načtení všech informací o dané knize ze souboru (soubor obsahuje vždy jednu knihu)
			System.out.println("12 .. ukonceni aplikace"); //Při ukončení se uloží vše zpět do databáze
			
			//Volba menu
			//doplnit nacitani volby z konzole
		    switch (choice) {
		      case 1:
		      	break;
		      case 2:
		       	break;
		      case 3:
		       	break;
		      case 4:
		       	break;
		      case 5:
		       	break;
		      case 6:
		       	break;
		      case 7:
		       	break;
		      case 8:
		      	break;
		      case 9:
		       	break;
		      case 10:
		       	break;
		      case 11:
		       	break;
		      case 12:
		       	break;
		      default:
		        run = false;
		        break;
		    }//konec switche
		      
		}//konec while(run)
		
		
		//Uložení do databáze před ukončením programu
		if (run == false) {
			//zavolej příslušnou funkci a uloz do databaze
		}
		//If ukládání true then konec programu
	}
}
