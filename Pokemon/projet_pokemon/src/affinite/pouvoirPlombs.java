package affinite;

public class pouvoirPlombs implements TypePokemon {
    private static final int m_ID = 6;
    private int m_val;

    @Override
    public int getId() {
        return m_ID;
    }

    @Override
    public String getNom() {
        return " Plombs";
    }

    @Override
    public boolean aUnAvantageSur(TypePokemon type) {
        m_val=0;
        return false;
    }

    @Override
    public boolean aUnDesavantageSur(TypePokemon type) {
        m_val=-10;
        return true;
    }

    @Override
    public int getval() {
        return m_val;
    }

}
