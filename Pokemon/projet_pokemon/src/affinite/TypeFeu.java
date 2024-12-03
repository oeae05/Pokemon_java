package affinite;



public class TypeFeu implements TypePokemon {
    private static final int ID = 3;
    private int m_val;

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public String getNom(){
        return "Feu";
    }

    @Override
    public boolean aUnAvantageSur(TypePokemon type) {
        m_val = 10;
        if(type.getId() == 4 || type.getId() == 6){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean aUnDesavantageSur(TypePokemon type) {
        m_val = -10;
        if(type.getId() == 2 || type.getId()== 5){
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
        return getNom() + ID;
    }


}
