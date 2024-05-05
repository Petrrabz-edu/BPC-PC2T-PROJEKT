package projekt.program.data;

public class Roman extends Kniha{
	public String typRomanu;

	public Roman(Integer idKnihy, String nazevKnihy, String autorKnihy, Integer rokVydani, Integer stav, String typRomanu) {
		super(idKnihy, nazevKnihy, autorKnihy, rokVydani, stav);
		this.typRomanu = typRomanu;
	}

	public void setTypRomanu(String typRomanu) {
		this.typRomanu = typRomanu;
	}
	
	@Override
    public String getTypKnihy() {
        return "Roman";
    }
	
	@Override
    public String getNazevKnihy() {
        return nazevKnihy;
    }
    @Override
    public void vypisSpecifikace() {
        System.out.println("Typ románu: " + typRomanu);
    }
    @Override
    public String getSpecifikace() {
        return typRomanu;
    }

}
