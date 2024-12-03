package pouvoirs;

import ErrorManager.PokemonNotFound;
import Pokemon.Pokemon;
import Structure.GrandTerrain;
import Structure.Terrain;

import java.util.List;

public class SoinTotal implements Pouvoirs{
    String m_nom = "Soin";
    String m_description = "Soin : Le pokémon choisit regagne toute sa vie. ";

    private String[] m_questions = {"Sélectionnez le numéro du Pokémon que vous voulez soigner: "};

    public String getNom(){
        return m_nom;
    }

    @Override
    public String[] getQuestions() {
        return m_questions;
    }

    public void use(Pokemon lanceur, String pokemonVise, GrandTerrain terrain, boolean humain) throws PokemonNotFound {
        Pokemon vise = terrain.getPokemon(pokemonVise, humain);
        int vieInitiale = lanceur.getVieInitial();
        vise.setVie(vieInitiale);
        lanceur.setBoolPouvoir(true);
    }

    @Override
    public String getDescription() {
        return m_description;
    }
}
