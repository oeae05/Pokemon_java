package affinite;
public interface TypePokemon {

        int getId();

        String getNom();
        
        boolean aUnAvantageSur(TypePokemon type);
    

        boolean aUnDesavantageSur(TypePokemon type);

        String toString();

        int getval();

}
