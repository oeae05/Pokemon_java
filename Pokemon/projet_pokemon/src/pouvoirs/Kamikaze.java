package pouvoirs;

import ErrorManager.PokemonNotFound;
import Pokemon.Pokemon;
import Structure.GrandTerrain;
import Structure.Terrain;

import java.util.List;

public class Kamikaze implements Pouvoirs {
    private Pokemon m_pokeUtilisateur;
    private Pokemon m_pokeAdverse;
    public static String[] m_questions = {"Sélectionnez le numéro du Pokemon que vous voulez tuer: "};
    String m_nom = "Kamikaze";
    String m_description = "Kamikaze : le Pokémon choisit un Pokémon du camp adverse. Les deux Pokémons sont alors éliminés.";

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
        vise.setVie(0);
        lanceur.setVie(0);
        lanceur.setBoolPouvoir(true);
    }

    @Override
    public String getDescription() {
        return m_description;
    }

}
