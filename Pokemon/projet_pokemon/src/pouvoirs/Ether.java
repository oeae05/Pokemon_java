package pouvoirs;

import ErrorManager.PokemonNotFound;
import Pokemon.Pokemon;
import Structure.GrandTerrain;
import Structure.Terrain;
import affinite.pouvoirEther;

import java.util.List;

public class Ether implements Pouvoirs{
    public static String[] m_questions = {"Sélectionnez le numéro du Pokemon dont vous voulez changer l'affinité pour Ether: "};
    String m_nom = "Ether";
    String m_description = "Ether: Le Pokémon change son affinité pour une affinité avec l'Ether. L'Ether est un élément ayant un avantage sur tous les autres.";

    public String getNom(){
        return m_nom;
    }

    @Override
    public String[] getQuestions() {
        return m_questions;
    }


    @Override
    public void use(Pokemon lanceur, String pokemonVise, GrandTerrain terrain, boolean humain) throws PokemonNotFound {
        Pokemon vise = terrain.getPokemon(pokemonVise, humain);

        vise.setType(new pouvoirEther());
        lanceur.setBoolPouvoir(true);
    }

    @Override
    public String getDescription() {
        return m_description;
    }

}
