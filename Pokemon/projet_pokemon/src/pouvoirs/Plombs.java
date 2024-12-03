package pouvoirs;

import ErrorManager.PokemonNotFound;
import Pokemon.Pokemon;
import Structure.GrandTerrain;
import Structure.Terrain;
import affinite.pouvoirPlombs;

import java.util.List;

public class Plombs implements Pouvoirs{
    Pokemon m_pokeAdverse;
    public static String[] m_questions = {"Sélectionnez le numéro du Pokemon dont vous voulez changer l'affinité pour Plombs: "};
    String m_nom = "Plombs";
    String m_description = "Plombs : Le Pokémon choisi change pour une affinitéplomb. Le Plomb est un nouvel élément sur lequel tous les autres éléments ont un avantage.";

    public String getNom(){
        return m_nom;
    }

    @Override
    public String[] getQuestions() {
        return m_questions;
    }

    @Override
    public void use(Pokemon lanceur, String pokemonVise, GrandTerrain terrain, boolean humain) throws PokemonNotFound {
        Pokemon vise = terrain.getPokemon(pokemonVise, !humain);
        vise.setType(new pouvoirPlombs());
        lanceur.setBoolPouvoir(true);
    }

    @Override
    public String getDescription() {
        
        return m_description;
    }
    

}
