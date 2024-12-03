package pouvoirs;

import ErrorManager.PokemonHasNoPower;
import Pokemon.Pokemon;
import Structure.GrandTerrain;
import Structure.Terrain;

import java.util.List;

public class nul implements Pouvoirs{

    String m_nom = "Aucun";
    String m_description = "Aucun : pas de pouvoir";


    @Override
    public String[] getQuestions() throws PokemonHasNoPower {
        throw new PokemonHasNoPower();
    }

    public String getNom(){
        return m_nom;
    }

    @Override
    public void use(Pokemon lanceur, String pokemonVise, GrandTerrain terrain, boolean humain) throws PokemonHasNoPower {
        throw new PokemonHasNoPower();
    }

    @Override
    public String getDescription() {
        return m_description;
    }

}

