package projekt;



import java.util.Scanner;

/**
 * Tøída sloužící k výbìru uživatelské volby z konzole
 * 
 * Jiøí Pøinosil
 * 
 * Upravil a rozšíøil Petr Ondrušek
 * 
 */
public class ConsoleInput {

  public static int readNumberInputFromConsole(Scanner sc) {
    int cislo = 0;
    try {
      cislo = sc.nextInt();
    } catch (Exception e) {
      //System.out.println("Nastala vyjimka typu " + e.toString());
      System.out.println("zadejte prosim cele cislo ");
      sc.nextLine();
      cislo = readNumberInputFromConsole(sc);
    }
    return cislo;
  }

  public static int readNumberInputFromConsoleInLimits(Scanner sc, int dolniMez, int horniMez) {
        int cislo = 0;
        try {
            cislo = sc.nextInt();
          } catch (Exception e) {
            //System.out.println("Nastala vyjimka typu " + e.toString());
            System.out.println("zadejte prosim cele cislo ");
            sc.nextLine();
            cislo = readNumberInputFromConsoleInLimits(sc, dolniMez, horniMez);
          }
        while (cislo < dolniMez || cislo > horniMez) {
        	System.out.println("zadejte platnou volbu");
        	try {
                cislo = sc.nextInt();
              } catch (Exception e) {
                //System.out.println("Nastala vyjimka typu " + e.toString());
                System.out.println("zadejte prosim cele cislo ");
                sc.nextLine();
                cislo = readNumberInputFromConsoleInLimits(sc, dolniMez, horniMez);
              }
        }
        
    return cislo;
  }
    
  public static void pressEnterToContinue()
    { 
       System.out.println("");
       System.out.println("Zmáèknìte Enter pro návrat do menu...");
       try
       {
           System.in.read();
       }  
       catch(Exception e)
       {}  
    }

}
