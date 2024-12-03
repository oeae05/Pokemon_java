package affinite;

public class TypeAir implements TypePokemon {
    
    private static final int m_ID = 4;
    private int m_val;

    @Override
    public int getId() {
        return m_ID;
    }
    @Override
    public String getNom(){
        return "Air";
    }

    @Override
    public boolean aUnAvantageSur(TypePokemon type) {
        m_val=10;
        if(type.getId() == 1 || type.getId()== 6){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean aUnDesavantageSur(TypePokemon type) {
        m_val=-10;
        if(type.getId() == 3 || type.getId()== 5){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int getval(){
        return m_val;
    }

    @Override
    public String toString(){
        return getNom() + m_ID;
    }

}