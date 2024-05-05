package projekt.program.data;

public abstract class Kniha {
	protected Integer idKnihy;
	protected String nazevKnihy;
	protected String autorKnihy;
	protected Integer rokVydani;
	protected Integer stav;
	
	public Kniha(Integer idKnihy, String nazevKnihy, String autorKnihy, Integer rokVydani, Integer stav) {
		this.idKnihy = idKnihy;
		this.nazevKnihy = nazevKnihy;
		this.autorKnihy = autorKnihy;
		this.rokVydani = rokVydani;
		this.stav = stav;
	}

	public Integer getIdKnihy() {
		return idKnihy;
	}

	public void setIdKnihy(Integer idKnihy) {
		this.idKnihy = idKnihy;
	}

	public void setNazevKnihy(String nazevKnihy) {
		this.nazevKnihy = nazevKnihy;
	}

	public String getAutorKnihy() {
		return autorKnihy;
	}

	public void setAutorKnihy(String autorKnihy) {
		this.autorKnihy = autorKnihy;
	}

	public Integer getRokVydani() {
		return rokVydani;
	}

	public void setRokVydani(Integer rokVydani) {
		this.rokVydani = rokVydani;
	}

	public Integer getStav() {
		return stav;
	}

	public void setStav(Integer stav) {
		this.stav = stav;
	}
	
    public abstract String getTypKnihy();
    public abstract void vypisSpecifikace();
    public abstract String getSpecifikace();
    public abstract String getNazevKnihy();

}
