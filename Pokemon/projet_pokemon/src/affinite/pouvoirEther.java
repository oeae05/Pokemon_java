package affinite;

public class pouvoirEther implements TypePokemon{

    private static final int m_ID = 5;
    private int m_val;

    @Override
    public int getId() {
        return m_ID;
    }

    @Override
    public String getNom() {
        return "Ether";
    }

    @Override
    public boolean aUnAvantageSur(TypePokemon type) {
        m_val=10;
        return true;
    }

    @Override
    public boolean aUnDesavantageSur(TypePokemon type) {
        m_val=0;
        return false;
    }

    @Override
    public int getval() {
        return m_val;
    }

}
