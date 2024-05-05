package projekt.program;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import projekt.program.data.Kniha;
import projekt.program.data.Roman;
import projekt.program.data.Ucebnice;

public class DatabazeKniha {
	private List<Kniha> seznamKnih = new ArrayList<>();
	private Connection conn;

    public boolean pridejRoman(String nazevKnihy, String autorKnihy, Integer rokVydani, Integer stav,String typRomanu) {
    	Roman roman = new Roman(getLastIdKnihy(seznamKnih) + 1,nazevKnihy, autorKnihy, rokVydani, stav, typRomanu);
        if (seznamKnih.contains(roman)) {
            return false;
        }

        seznamKnih.add(roman);
        return true;
    }
    
    public boolean pridejUcebnici(String nazevKnihy, String autorKnihy, Integer rokVydani, Integer stav,String vhodnost) {
    	Ucebnice ucebnice = new Ucebnice(getLastIdKnihy(seznamKnih) + 1,nazevKnihy, autorKnihy, rokVydani, stav, vhodnost);
        if (seznamKnih.contains(ucebnice)) {
            return false;
        }

        seznamKnih.add(ucebnice);
        return true;
    }
    
    public Kniha najdiKnihuDleJmena(String nazevKnihy) {
    	for (Kniha kniha : seznamKnih) {
    		if (kniha.getNazevKnihy().equalsIgnoreCase(nazevKnihy)) {
                return kniha;
            }
    	}
    	System.out.println("Kniha "+nazevKnihy+" nebyla nalezena");
		return null;
    }
    
    public boolean existujeIdKnihy(Integer idKnihy) {
    	for (Kniha kniha : seznamKnih) {
    		if (kniha.getIdKnihy().equals(idKnihy)) {
    			System.out.println("Kniha s ID "+idKnihy+" již existuje");
                return true;
            }
    	}
    	return false;
    }

    public void odebraniKnihyDleNazvu(String nazevKnihy) {
    	Kniha kniha = najdiKnihuDleJmena(nazevKnihy);
		if (seznamKnih.remove(kniha)) {
			System.out.println("Kniha "+nazevKnihy+" úspìšnì odstranìna");
		}
		else {
			System.out.println("Kniha "+nazevKnihy+" nebyla odstranìna!");
		}
    }
    
    public void vypisInfoKnihy(Kniha kniha) {
    	if (kniha != null) {
    		System.out.println("Název knihy: " + kniha.getNazevKnihy());
            System.out.println("Autor: " + kniha.getAutorKnihy());
            System.out.println("Typ knihy: " + kniha.getTypKnihy());
            kniha.vypisSpecifikace();
            System.out.println("Rok vydání: " + kniha.getRokVydani());
            System.out.println("Stav dostupnosti: " + kniha.getStav());
            System.out.println("------------------");	
    	}
    }
    
    public void vypisVsechnyKnihy() {
    	seznamKnih.sort(Comparator.comparing(Kniha::getNazevKnihy));
        for (Kniha kniha : seznamKnih) {
        	vypisInfoKnihy(kniha);
        }
    }

    public Kniha vyhledejKnihuPodleNazvu(String nazevKnihy) {
        for (Kniha kniha : seznamKnih) {
            if (kniha.getNazevKnihy().equalsIgnoreCase(nazevKnihy)) {
                return kniha;
            }
        }
        return null;
    }

    public List<Kniha> vyhledejKnihyAutora(String autor) {
        List<Kniha> knihyAutora = new ArrayList<>();
        for (Kniha kniha : seznamKnih) {
            if (kniha.getAutorKnihy().equalsIgnoreCase(autor)) {
                knihyAutora.add(kniha);
            }
        }
        if (knihyAutora.size() == 0) {
        	System.out.println("Autor nemá žádné knihy");
        	return null;
        }
        else {
        	return knihyAutora;
        }
        
    }

    public List<Kniha> vyhledejKnihyZanru(String zanr) {
        List<Kniha> knihyZanru = new ArrayList<>();
        for (Kniha kniha : seznamKnih) {
            if (kniha.getSpecifikace().equalsIgnoreCase(zanr)) {
                knihyZanru.add(kniha);
                vypisInfoKnihy(kniha);
            }
        }
        return knihyZanru;
    }

    public List<Kniha> vypisVypujceneKnihy() {
        List<Kniha> vypujceneKnihy = new ArrayList<>();
        for (Kniha kniha : seznamKnih) {
            if (kniha.getStav() == 0) {
                vypujceneKnihy.add(kniha);
            }
        }
        return vypujceneKnihy;
    }
    
	public Integer getLastIdKnihy(List<Kniha> seznamKnih) {
	    int lastIdKnihy = 0;
	
	    for (Kniha kniha : seznamKnih) {
	        int idKnihy = kniha.getIdKnihy();
	
	        if (idKnihy > lastIdKnihy) {
	            lastIdKnihy = idKnihy;
	        }
	    }
	    return lastIdKnihy;
	}
	
	public void vypisSetrizeneKnihy() {
	    Collections.sort(seznamKnih, Comparator.comparing(Kniha::getNazevKnihy));
	
	    System.out.println("Výpis všech knih v abecedním poøadí:");
	    for (Kniha kniha : seznamKnih) {
	        vypisInfoKnihy(kniha);
	    }
	}
	
	public void vypisKnihyAutora(String autorKnihy) {
		if (vyhledejKnihyAutora(autorKnihy)!= null){
			System.out.println("Výpis všech knih autora:");
			System.out.println("");
			for (Kniha kniha : vyhledejKnihyAutora(autorKnihy)) {
		    	System.out.println("Název knihy: " + kniha.getNazevKnihy());
		        System.out.println("Typ knihy: " + kniha.getTypKnihy());
		        kniha.vypisSpecifikace();
		        System.out.println("Rok vydání: " + kniha.getRokVydani());
		        System.out.println("Stav dostupnosti: " + kniha.getStav());
		        System.out.println("------------------");
		    } 
		 }
	}
    
	public void ulozDoSouboru(String nazevSouboru, Kniha kniha) {
    	nazevSouboru = "ImportExportKnih/"+nazevSouboru;
    	if (kniha != null) {
    		try {
                PrintWriter writer = new PrintWriter(nazevSouboru);
                writer.println(kniha.getIdKnihy());
                writer.println(kniha.getNazevKnihy());
                writer.println(kniha.getAutorKnihy());
                writer.println(kniha.getRokVydani());
                writer.println(kniha.getStav());
                writer.println(kniha.getTypKnihy());
                if (kniha.getTypKnihy().equals("Roman")) {
                    writer.println(kniha.getSpecifikace());
                } else if (kniha.getTypKnihy().equals("Ucebnice")) {
                    writer.println(kniha.getSpecifikace());
                }
                writer.close();
                System.out.println("Soubor byl úspìšnì uložen.");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }	
    	}
    	else {
    		System.out.println("Soubor nelze vytvoøit bez existující knihy.");
    	}
    }

    public void nactiZeSouboru(String nazevSouboru, Scanner sc) {
    	nazevSouboru = "ImportExportKnih/"+nazevSouboru;
        try {
            File file = new File(nazevSouboru);
            sc = new Scanner(file);
            Integer idKnihy = Integer.parseInt(sc.nextLine()); 
            if (idKnihy > 0) {
            	if (existujeIdKnihy(idKnihy)) {
            		System.out.println("Kniha nebyla importována.");
            	}
            	else {
            		Kniha kniha = null;
            		String nazevKnihy = sc.nextLine();
                    String autorKnihy = sc.nextLine();
                    Integer rokVydani = Integer.parseInt(sc.nextLine());
                    Integer stav = Integer.parseInt(sc.nextLine());
                    String typKnihy = sc.nextLine();
                    if (typKnihy.equals("Roman")) {
                        String dalsiInfo = sc.nextLine();
                        kniha = new Roman(idKnihy ,nazevKnihy, autorKnihy, rokVydani, stav, dalsiInfo);
                    } else if (typKnihy.equals("Ucebnice")) {
                        String dalsiInfo = sc.nextLine();
                        kniha = new Roman(idKnihy ,nazevKnihy, autorKnihy, rokVydani, stav, dalsiInfo);
                    }
                    seznamKnih.add(kniha);
            	}	
            }
            else {
            	String nazevKnihy = sc.nextLine();
                String autorKnihy = sc.nextLine();
                Integer rokVydani = Integer.parseInt(sc.nextLine());
                Integer stav = Integer.parseInt(sc.nextLine());
                String typKnihy = sc.nextLine();
                if (typKnihy.equals("Roman")) {
                    String dalsiInfo = sc.nextLine();
                    pridejRoman(nazevKnihy, autorKnihy, rokVydani, stav, dalsiInfo);
                } else if (typKnihy.equals("Ucebnice")) {
                    String dalsiInfo = sc.nextLine();
                    pridejUcebnici(nazevKnihy, autorKnihy, rokVydani, stav, dalsiInfo);
                }
                System.out.println("Kniha úspìšnì importována.");
            }
            sc.close();
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        	System.out.println("Zadaný soubor se nepodaøilo najít.");
        }
    }

    public void nactiKnihyZDatabaze() {
    	
    	try {
    		Connection conn = DriverManager.getConnection("jdbc:sqlite:db/DB_knihovna.db");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT SeznamKnih.IdKnihy, SeznamKnih.Nazev, SeznamKnih.Autor, " +
                                                         "SeznamKnih.RokVydani, SeznamKnih.Stav, " +
                                                         "Romany.Typ AS TypRomanu, Ucebnice.Vhodnost " +
                                                         "FROM SeznamKnih " +
                                                         "LEFT JOIN Romany ON SeznamKnih.IdKnihy = Romany.IdKnihy " +
                                                         "LEFT JOIN Ucebnice ON SeznamKnih.IdKnihy = Ucebnice.IdKnihy");

            while (rs.next()) {
                int idKnihy = rs.getInt("IdKnihy");
                String nazevKnihy = rs.getString("Nazev");
                String autorKnihy = rs.getString("Autor");
                int rokVydani = rs.getInt("RokVydani");
                int stav = rs.getInt("Stav");
                String typRomanu = rs.getString("TypRomanu");
                String vhodnost = rs.getString("Vhodnost");

                
                Kniha kniha;
                if (typRomanu != null) {
                    kniha = new Roman(idKnihy, nazevKnihy, autorKnihy, rokVydani, stav, typRomanu);
                } else if (vhodnost != null) {
                    kniha = new Ucebnice(idKnihy, nazevKnihy, autorKnihy, rokVydani, stav, vhodnost);
                } else {
                    System.out.println("Databáze je vadná, kontaktujte administrátora.");
                    continue;
                }

                seznamKnih.add(kniha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Databáze úspìšnì naètena.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void ulozKnihyDoDatabaze() {     
        try {
        	Connection conn = DriverManager.getConnection("jdbc:sqlite:db/DB_knihovna.db");
        	
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM Romany");
            st.executeUpdate("DELETE FROM Ucebnice");
            st.executeUpdate("DELETE FROM SeznamKnih");
        	
            PreparedStatement psSeznamKnih = conn.prepareStatement("INSERT INTO SeznamKnih (IdKnihy, Nazev, Autor, RokVydani, Stav) VALUES (?, ?, ?, ?, ?)");
            PreparedStatement psRomany = conn.prepareStatement("INSERT INTO Romany (IdKnihy, Typ) VALUES (?, ?)");
            PreparedStatement psUcebnice = conn.prepareStatement("INSERT INTO Ucebnice (IdKnihy, Vhodnost) VALUES (?, ?)");
            Integer idKnihy = 0;

            for (Kniha kniha : seznamKnih) {
            	idKnihy = kniha.getIdKnihy();
            	psSeznamKnih.setInt(1, idKnihy);
                psSeznamKnih.setString(2, kniha.getNazevKnihy());
                psSeznamKnih.setString(3, kniha.getAutorKnihy());
                psSeznamKnih.setInt(4, kniha.getRokVydani());
                psSeznamKnih.setInt(5, kniha.getStav());
                psSeznamKnih.executeUpdate();

                if (kniha instanceof Roman) {
                    Roman roman = (Roman) kniha;
                    psRomany.setInt(1, idKnihy);
                    psRomany.setString(2, roman.getSpecifikace());
                    psRomany.executeUpdate();
                } else if (kniha instanceof Ucebnice) {
                    Ucebnice ucebnice = (Ucebnice) kniha;
                    psUcebnice.setInt(1, idKnihy);
                    psUcebnice.setString(2, ucebnice.getSpecifikace());
                    psUcebnice.executeUpdate();
                }
            }
            
            System.out.println("Knihy úspìšnì uloženy do databáze.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


