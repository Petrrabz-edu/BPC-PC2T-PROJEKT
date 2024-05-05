package projekt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import projekt.program.DatabazeKniha;
import projekt.program.data.Kniha;

public class KnihovnaApp {

	public static void main(String[] args) {
		System.out.println("( ﾉ ﾟｰﾟ)ﾉ Vítejte v invetarizačním programu Knihovna. ＼(ﾟｰﾟ＼)\n");
		System.out.println("Načítáme databázi, prosím vyčkejte.");
		
		DatabazeKniha databazeKniha = new DatabazeKniha();
		databazeKniha.nactiKnihyZDatabaze();
		
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int choice = 0;
		int innerChoice = -1;
		String nazevKnihy;
		String autorKnihy;
		Integer rokVydani;
		Integer stav;
		String vhodnost = null;
		String typRomanu = null;
		Kniha kniha;
		List<Kniha> tempList = new ArrayList<>();
				
		while(run)
		{
			System.out.println(System.lineSeparator());
			System.out.println("Vyberte požadovanou činnost:");
		    System.out.println("1 ... Přidání nové knihy");
			System.out.println("2 ... Úprava knihy");
			System.out.println("3 ... Smazání knihy");
			System.out.println("4 ... Označení knihy");
			System.out.println("5 ... Výpis knih");
			System.out.println("6 ... Vyhledání knihy");
			System.out.println("7 ... Výpis všech knih autora");
			System.out.println("8 ... Výpis všech knih konkrétního žánru");
			System.out.println("9 ... Výpis všech vypůjčených knih"); 
			System.out.println("10 .. Export informací o knize");
			System.out.println("11 .. Import informací o knize");
			System.out.println("12 .. ukonceni aplikace");
			
			choice = ConsoleInput.readNumberInputFromConsole(sc);
			
		    switch (choice) {
		      case 1:
		      	{
			    	System.out.println("Vyberte typ knihy: 1 - Roman, 2 - Učebnice");
			  	    innerChoice = ConsoleInput.readNumberInputFromConsoleInLimits(sc,1,2);
	
			  	    System.out.println("Zadajte název knihy:");
			  	    sc.nextLine();
			  	    nazevKnihy = sc.nextLine();
	
			  	    System.out.println("Zadajte autora knihy:");
			  	    autorKnihy = sc.nextLine();
	
			  	    System.out.println("Zadajte rok vydání knihy:");
			  	    rokVydani = ConsoleInput.readNumberInputFromConsole(sc);
	
			  	    System.out.println("Zadajte stav knihy:");
			  	    System.out.println("0 - půjčeno / 1 - dostupná");
			  	    stav = ConsoleInput.readNumberInputFromConsoleInLimits(sc,0,1);
			  	    
			  	    if (innerChoice == 1) {
			  	        System.out.println("Zadajte typ románu:");
			  	        System.out.println("1 - Historický");
			  	        System.out.println("2 - Detektivní");
			  	        System.out.println("3 - Sci-Fi");
			  	    	System.out.println("4 - Dobrodružný");
			  	  		System.out.println("5 - Rytířský");
			  	  		innerChoice = ConsoleInput.readNumberInputFromConsoleInLimits(sc,1,5);
			  	    	switch (innerChoice) {
			  	    	case 1: typRomanu = "Historický"; break;
			  	    	case 2: typRomanu = "Detektivní"; break;
			  	    	case 3: typRomanu = "Sci-Fi"; break;
			  	    	case 4: typRomanu = "Dobrodružný"; break;
			  	    	case 5: typRomanu = "Rytířský"; break;
			  	    	}
			  	    	databazeKniha.pridejRoman(nazevKnihy, autorKnihy, rokVydani, stav, typRomanu);
			  	    }
			  	    
			  	    else if (innerChoice == 2){
			  	    	System.out.println("Zadajte vhodnost učebnice:");
			  	        System.out.println("1 - předškolní věk");
			  	        System.out.println("2 - 1. stupeň ZŠ");
			  	        System.out.println("3 - 2. stupeň ZŠ");
			  	    	System.out.println("4 - SŠ");
			  	  		System.out.println("5 - VŠ");
			  	  		innerChoice = ConsoleInput.readNumberInputFromConsoleInLimits(sc,1,5);
			  	    	switch (innerChoice) {
			  	    	case 1: vhodnost = "předškolní věk"; break;
			  	    	case 2: vhodnost = "1. stupeň ZŠ"; break;
			  	    	case 3: vhodnost = "2. stupeň ZŠ"; break;
			  	    	case 4: vhodnost = "SŠ"; break;
			  	    	case 5: vhodnost = "VŠ"; break;
			  	    	}
			  	    	databazeKniha.pridejUcebnici(nazevKnihy, autorKnihy, rokVydani, stav, vhodnost);
			  	    }
			  	    else {
			  	        System.out.println("Neplatný výber typu knihy.");
			  	    }
			      }
		      	ConsoleInput.pressEnterToContinue();
		      	break;
		      case 2:
		    	  System.out.println("Zadajte název knihy, kterou chcete upravit:");
		    	  sc.nextLine();
		    	  nazevKnihy = sc.nextLine();
		    	  kniha = databazeKniha.najdiKnihuDleJmena(nazevKnihy);
	              if (kniha != null) {
		    	  System.out.println("Co chcete upravit?");
				  System.out.println("1 - Autor/autoři");
				  System.out.println("2 - Rok vydání");
				  System.out.println("3 - Stav dostupnosti");
				  innerChoice = ConsoleInput.readNumberInputFromConsoleInLimits(sc, 1, 3);
				  switch (innerChoice) {
				  	case 1:
				  		System.out.println("Původní autor/autoři: "+kniha.getAutorKnihy());
				  		System.out.println("Zadajte nového autora/autory:");
				  		sc.nextLine();
                        autorKnihy = sc.nextLine();
                        kniha.setAutorKnihy(autorKnihy);
                        System.out.println("Autor/autoři byl úspešne aktualizovaný.");
				  		break;
				  	case 2:
				  		System.out.println("Původní rok vydání: "+kniha.getRokVydani());
				  		System.out.println("Zadajte nový rok vydání:");
                        rokVydani = ConsoleInput.readNumberInputFromConsole(sc);
                        kniha.setRokVydani(rokVydani);
                        System.out.println("Rok vydání byl úspešne aktualizovaný.");
				  		break;
				  	case 3:
				  		stav = kniha.getStav();
				  		if (stav == 0) {
				  			System.out.println("Původní stav dostupnosti: 0 - Půjčno");
				  		}
				  		else {
				  			System.out.println("Původní stav dostupnosti: 1 - Dostupné");
				  		}
				  		System.out.println("Zadajte nový stav(0 - Půjčeno / 1 - Dostupné):");
				  		stav = ConsoleInput.readNumberInputFromConsoleInLimits(sc,0,1);
                        kniha.setStav(stav);
                        System.out.println("Stav byl úspešne aktualizovaný.");
				  		break;
				  	default:
				  		System.out.println("Neplatná volba");
				  		break;
				  	}
				  }
	              else {
	            	  System.out.println("Zadali jste neplatný název knihy.");
	              }
	              ConsoleInput.pressEnterToContinue();
		       	break;
		      case 3:
		    	  System.out.println("Zadajte název knihy, kterou chete smazat: ");
		    	  sc.nextLine();
		    	  nazevKnihy = sc.nextLine(); 
		    	  databazeKniha.odebraniKnihyDleNazvu(nazevKnihy);
		    	  ConsoleInput.pressEnterToContinue();
		       	break;
		      case 4:
		    	  System.out.println("Zadajte název knihy, které chcete změnit stav:");
		    	  sc.nextLine();
		    	  nazevKnihy = sc.nextLine(); 
		    	  kniha = databazeKniha.najdiKnihuDleJmena(nazevKnihy);
	              if (kniha != null) {
			  		System.out.println("Zadajte nový stav(0 - Půjčno / 1 - Vráceno):");
			  		stav = ConsoleInput.readNumberInputFromConsoleInLimits(sc,0,1);
                  kniha.setStav(stav);
                  System.out.println("Stav byl úspešne aktualizovaný.");
	              }
	              else {
	            	  System.out.println("Zadali jste neplatný název knihy.");
	              }
	              ConsoleInput.pressEnterToContinue();
		       	break;
		      case 5:{
		    	  databazeKniha.vypisSetrizeneKnihy();
		    	  ConsoleInput.pressEnterToContinue();
		    	  }
		       	break;
		      case 6:
		    	  System.out.println("Zadajte název knihy, kterou chcete vyhledat: ");
		    	  sc.nextLine();
		    	  nazevKnihy = sc.nextLine(); 
		    	  kniha = databazeKniha.najdiKnihuDleJmena(nazevKnihy);
		    	  databazeKniha.vypisInfoKnihy(kniha);
		    	  ConsoleInput.pressEnterToContinue();
		       	break;
		      case 7:
		    	  System.out.println("Zadajte jméno autora, jehož knihy chete vyhledat: ");
		    	  sc.nextLine();
                  autorKnihy = sc.nextLine();
		    	  databazeKniha.vypisKnihyAutora(autorKnihy);
		    	  ConsoleInput.pressEnterToContinue();
		       	break;
		      case 8:
		    	  System.out.println("Zadajte typ románu:");
		  	      System.out.println("1 - Historický");
		  	      System.out.println("2 - Detektivní");
		  	      System.out.println("3 - Sci-Fi");
		  	      System.out.println("4 - Dobrodružný");
		  	      System.out.println("5 - Rytířský");
		  	      innerChoice = ConsoleInput.readNumberInputFromConsoleInLimits(sc,1,5);
		  	      switch (innerChoice) {
		  	      case 1: typRomanu = "Historický"; break;
		  	      case 2: typRomanu = "Detektivní"; break;
		  	      case 3: typRomanu = "Sci-Fi"; break;
		  	      case 4: typRomanu = "Dobrodružný"; break;
		  	      case 5: typRomanu = "Rytířský"; break;
		  	      }
		    	  databazeKniha.vyhledejKnihyZanru(typRomanu);
		    	  ConsoleInput.pressEnterToContinue();
		      	break;
		      case 9:
		    	  tempList = databazeKniha.vypisVypujceneKnihy();
		    	  for (Kniha cacheKniha : tempList) {
		    		  System.out.println(cacheKniha.getNazevKnihy() + " - " + cacheKniha.getTypKnihy());
		    		  
		    	  }
		    	  ConsoleInput.pressEnterToContinue();
		       	break;
		      case 10:
		    	  System.out.println("Zadajte název knihy, kterou chcete exportovat: ");
		    	  sc.nextLine();
		    	  nazevKnihy = sc.nextLine();
		    	  kniha = databazeKniha.najdiKnihuDleJmena(nazevKnihy);
		    	  databazeKniha.ulozDoSouboru("kniha.txt", kniha);
		    	  ConsoleInput.pressEnterToContinue();
		       	break;
		      case 11:
		    	  System.out.println("Zadajte název souboru, ze kterého chete knihu importovat: ");
		    	  nazevKnihy = sc.next();
		    	  databazeKniha.nactiZeSouboru(nazevKnihy, sc);
		    	  ConsoleInput.pressEnterToContinue();
		       	break;
		      case 12:
		    	  System.out.println("Program byl ukončen, nashledanou. (´•︵•`)");
		    	  databazeKniha.ulozKnihyDoDatabaze();
		    	  sc.close();
		    	  run = false;
		       	break;
		      default:
		        run = false;
		        break;
		    }
		      
		}
	}
}
