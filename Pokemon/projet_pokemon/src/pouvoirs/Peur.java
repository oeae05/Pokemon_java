package pouvoirs;

import ErrorManager.PokemonNotFound;
import Pokemon.Pokemon;
import Structure.GrandTerrain;
import Structure.Terrain;

import java.util.List;

public class Peur implements Pouvoirs{
    Pokemon m_pokeAdverse;
    public static String[] m_questions = {"Sélectionnez le numéro du Pokemon adverse dont l'attaque doit être diminuée: "};
    String m_nom = "Peur";
    String m_description ="Peur : les attaques du pokémon choisi infligent 10 dégats de moins.";

    public String getNom(){
        return m_nom;
    }

    @Override
    public String[] getQuestions() {
        return m_questions;
    }

    public void use(Pokemon lanceur, String pokemonVise, GrandTerrain terrain, boolean humain) throws PokemonNotFound {
        Pokemon vise = terrain.getPokemon(pokemonVise, !humain);
        int attaqueInitiale = vise.getAttaque();
        vise.setAttaque(attaqueInitiale-10);
        lanceur.setBoolPouvoir(true);
    }

    @Override
    public String getDescription() {
        return m_description;
    }
    
}
