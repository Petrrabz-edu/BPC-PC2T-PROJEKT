package projekt.program.data;

public class Ucebnice extends Kniha{
	public String vhodnost;

	public Ucebnice(Integer idKnihy, String nazevKnihy, String autorKnihy, Integer rokVydani, Integer stav, String vhodnost) {
		super(idKnihy, nazevKnihy, autorKnihy, rokVydani, stav);
		this.vhodnost = vhodnost;
	}

	public void setVhodnost(String vhodnost) {
		this.vhodnost = vhodnost;
	}
	
	@Override
    public String getNazevKnihy() {
        return nazevKnihy;
    }

	@Override
    public String getTypKnihy() {
        return "Uèebnice";
    }
    @Override
    public void vypisSpecifikace() {
        System.out.println("Vhodnost: " + vhodnost);
    }
    @Override
    public String getSpecifikace() {
        return vhodnost;
    }

	
}
